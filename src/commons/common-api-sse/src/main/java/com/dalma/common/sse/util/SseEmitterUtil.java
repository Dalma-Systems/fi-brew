package com.dalma.common.sse.util;

import com.dalma.common.sse.service.SsePushNotificationService;
import com.dalma.contract.dto.sse.CustomSseEmitter;
import com.dalma.contract.dto.sse.SseDestination;
import org.springframework.stereotype.Component;

@Component
public class SseEmitterUtil {
	
	public CustomSseEmitter createEmitter(SseDestination destination, SsePushNotificationService ssePushNotificationService) {
		final CustomSseEmitter emitter = new CustomSseEmitter(destination);
		ssePushNotificationService.addEmitter(emitter);
		ssePushNotificationService.doNotify(destination);
		emitter.onCompletion(() -> ssePushNotificationService.removeEmitter(emitter));
		emitter.onTimeout(() -> ssePushNotificationService.removeEmitter(emitter));
		return emitter;
	}
}
