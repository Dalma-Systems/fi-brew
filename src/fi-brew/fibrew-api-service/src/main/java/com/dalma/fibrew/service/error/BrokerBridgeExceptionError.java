package com.dalma.fibrew.service.error;

import com.dalma.fibrew.base.error.BaseExceptionError;

import static com.dalma.fibrew.service.error.BaseExceptionError.BROKER_BRIDGE_ERROR_CODE;

public enum BrokerBridgeExceptionError implements BaseExceptionError {
	ACCESS_ERROR(BROKER_BRIDGE_ERROR_CODE.code() + "101", "Error accessing broker bridge: {0}"),
	;

	private String code;
	private String message;

	private BrokerBridgeExceptionError(String code, String message) {
		this.code = code;
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public String code() {
		return code;
	}
}
