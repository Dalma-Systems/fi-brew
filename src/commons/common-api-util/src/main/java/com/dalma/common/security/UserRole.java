package com.dalma.common.security;

public enum UserRole {
    ADMIN("ADMIN"),
    SUPERVISOR("SUPERVISOR"),
    STORAGE("STORAGE"),
    ROBOT("ROBOT"),
    ;

    private String value;

    UserRole(String value) {
        this.value = value;
    }

    public String getRole() {
        return "ROLE_" + getValue();
    }

    public String getValue() {
        return value;
    }
}
