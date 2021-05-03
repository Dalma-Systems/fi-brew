package com.dalma.common.entity;

import lombok.Getter;

@Getter
public enum EntityType {
	ROBOT("AMR"),
	IDLE_STATION("Idlestation"),
	WORK_STATION("Workstation"),
	WAREHOUSE("Warehouse"),
	WAREHOUSE_MATERIAL("Material"),
	WORK_ORDER("WorkOrder"),
	WORK_ORDER_ITEM("WorkOrderItem"),
	;
	
	private String type;
	
	private EntityType(String type) {
		this.type = type;
	}
}
