package com.dalma.fibrew.service.enums;

import lombok.Getter;

@Getter
public enum BrokerApiPath {
	SUBSCRIPTION("/api/broker/subscription"), 
	CONDITION("/condition"),
    WORK_ORDER_NOTIFICATION_INTEGRATE_FIBREW("/api/broker/workorder/notification/integrate/fibrew"),
	;

	private String path;

	private BrokerApiPath(String path) {
		this.path = path;
	}
}
