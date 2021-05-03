package com.dalma.common.sse.controller;

import com.dalma.common.sse.service.SsePushNotificationService;
import com.dalma.common.sse.util.SseEmitterUtil;
import com.dalma.contract.dto.sse.SseDestination;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class BaseSsePushNotificationController {
	private static final String NO = "no";
	private static final String HEADER_X_ACCEL_BUFFERING = "X-Accel-Buffering";

	@Value("${dalma.http.server.nginx:true}")
	private Boolean withNginx;
	
	final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();

	private final SseEmitterUtil sseEmitterUtil;
	private final SsePushNotificationService ssePushNotificationService;
	
	public BaseSsePushNotificationController(SseEmitterUtil sseEmitterUtil, SsePushNotificationService ssePushNotificationService) {
		this.sseEmitterUtil = sseEmitterUtil;
		this.ssePushNotificationService = ssePushNotificationService;
	}
	
	public ResponseEntity<SseEmitter> doNotify() {
		if (withNginx.booleanValue()) {
			MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
			headers.add(HEADER_X_ACCEL_BUFFERING, NO);
			return new ResponseEntity<>(sseEmitterUtil.createEmitter(destinationUi(), ssePushNotificationService), headers, HttpStatus.OK);
		}
		return new ResponseEntity<>(sseEmitterUtil.createEmitter(destinationUi(), ssePushNotificationService), HttpStatus.OK);
	}
	
	public void sync() {
		ssePushNotificationService.doNotify(destinationUi());
    }
	
	public abstract ResponseEntity<SseEmitter> registerEmitter();
	public abstract void syncStatus();
	public abstract SseDestination destinationUi();
}
