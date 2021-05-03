package com.dalma.common.sse.util;

import com.dalma.common.sse.service.SsePushNotificationService;
import com.dalma.contract.dto.sse.CustomSseEmitter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class SseKeepAlive {
	private static final String PING = "ping";

	@Scheduled(fixedDelay = 20000L)
	public void keepConnectionsAlive() {
		List<CustomSseEmitter> deadEmitters = new ArrayList<>();
		SsePushNotificationService.getEmittersLastEvent().entrySet().stream().forEach(emitter -> {
			if (emitter.getValue() != null && Instant.now().minusMillis(30000L + 1000L).isAfter(emitter.getValue())) {
				try {
					emitter.getKey().send(SseEmitter.event().comment(PING));
					SsePushNotificationService.setEmittersLastEvent(emitter.getKey(), Instant.now());
				} catch (Exception e) {
					emitter.getKey().completeWithError(e);
					deadEmitters.add(emitter.getKey());
					log.error("Unable to ping emitter");
				}
			}
		});
		if (!deadEmitters.isEmpty()) {
			SsePushNotificationService.removeDeadEmitters(deadEmitters);
		}
	}
}
