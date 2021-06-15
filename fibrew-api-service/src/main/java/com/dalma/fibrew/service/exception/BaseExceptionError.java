package com.dalma.fibrew.service.exception;

public enum BaseExceptionError {
    BROKER_BRIDGE_ERROR_CODE("BROKER_BRIDGE"),
    ;

    private static final String DELIMITER = "_";

    String code;

    BaseExceptionError(String code) {
        this.code = code;
    }

    public String code() {
        return code + DELIMITER;
    }
}
