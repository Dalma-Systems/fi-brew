package com.dalma.common.workorder.enums;

import lombok.Getter;

@Getter
public enum WorkOrderSortField {
    SCHEDULE("scheduleAt"),
    STATUS("status"),
    START("startedAt"),
    END("endedAt"),
    WORKSTATION("workstation"),
    WAREHOUSE("warehouse"),
    ID("erpId"),
    ;

    private String field;

    private WorkOrderSortField(String field) {
        this.field = field;
    }

    public static WorkOrderSortField getWorkOrderSortField(String f) {
        for (WorkOrderSortField sortField : values()) {
            if (sortField.getField().equals(f)) {
                return sortField;
            }
        }
        return null;
    }
}
