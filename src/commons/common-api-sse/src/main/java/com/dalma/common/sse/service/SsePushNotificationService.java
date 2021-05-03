package com.dalma.common.sse.service;

import com.dalma.contract.dto.sse.CustomSseEmitter;
import com.dalma.contract.dto.sse.SseDestination;
import com.dalma.contract.dto.sse.WorkOrderEventDto;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class SsePushNotificationService {
	private final DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	private static final Map<SseDestination, List<CustomSseEmitter>> emitters = new EnumMap<>(SseDestination.class);
	private static final Map<CustomSseEmitter, Instant> emittersLastEvent = new HashMap<>();
    private static Object mutex = new Object();

	public SsePushNotificationService() {
		initEmitters();
	}
	
	public void initEmitters() {
		for (SseDestination destination : SseDestination.values()) {
			emitters.put(destination, new CopyOnWriteArrayList<>());
		}
	}
	
	public static Map<CustomSseEmitter, Instant> getEmittersLastEvent() {
		return emittersLastEvent;
	}
	
	public static void setEmittersLastEvent(CustomSseEmitter emitter, Instant moment) {
		synchronized (mutex) {
			emittersLastEvent.put(emitter, moment);
		}
	}

	public static void removeDeadEmitters(List<CustomSseEmitter> deadEmitters) {
		synchronized (mutex) {
			deadEmitters.stream().forEach(emitter -> {
				emitters.get(emitter.getDestination()).remove(emitter);
				emittersLastEvent.remove(emitter);
			});
		}
	}

	public void addEmitter(final CustomSseEmitter emitter) {
		synchronized (mutex) {
			emitters.get(emitter.getDestination()).add(emitter);
			emittersLastEvent.put(emitter, Instant.now());
		}
	}

	public void removeEmitter(final CustomSseEmitter emitter) {
		synchronized (mutex) {
			emitters.get(emitter.getDestination()).remove(emitter);
		}
	}

	@Async
	public void doNotify(SseDestination destination) {
		List<SseEmitter> deadEmitters = new ArrayList<>();
		emitters.get(destination).forEach(emitter -> {
			try {
				emitter.send(SseEmitter.event()
						.data(retrieveEventDatata()));
				synchronized (mutex) {
					emittersLastEvent.put(emitter, Instant.now());
				}
			} catch (Exception e) {
				emitter.completeWithError(e);
				deadEmitters.add(emitter);
			}
		});
		if (!deadEmitters.isEmpty()) {
			synchronized (mutex) {
				emitters.get(destination).removeAll(deadEmitters);
			}
		}
	}

	private WorkOrderEventDto retrieveEventDatata() {
		WorkOrderEventDto eventData = new WorkOrderEventDto();
		eventData.setDate(dateFormatter.format(new Date()));
		eventData.setAction(WorkOrderEventDto.Action.SYNC);
		return eventData;
	}
}
