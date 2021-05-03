package com.dalma.common.workorder.enums;

import lombok.Getter;

@Getter
public enum WorkOrderMaterialsSortField {
    ID("id"),
    QUANTITY("quantity"),
    TYPE("type"),
    UNIT("unit"),
    BATCH("batch"),
    ;

    private String field;

    private WorkOrderMaterialsSortField(String field) {
        this.field = field;
    }

    public static WorkOrderMaterialsSortField getWorkOrderMaterialSortField(String f) {
        for (WorkOrderMaterialsSortField sortField : values()) {
            if (sortField.getField().equals(f)) {
                return sortField;
            }
        }
        return null;
    }
}
