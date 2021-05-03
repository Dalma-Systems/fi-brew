package com.dalma.contract.dto.sse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkOrderEventDto {
    private Action action;
    private String date;

    public enum Action {
        SYNC;
    }
}
