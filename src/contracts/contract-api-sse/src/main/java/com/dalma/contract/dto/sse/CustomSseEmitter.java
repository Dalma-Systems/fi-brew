package com.dalma.contract.dto.sse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Getter
@Setter
@AllArgsConstructor
public class CustomSseEmitter extends SseEmitter {
    private SseDestination destination;
}
