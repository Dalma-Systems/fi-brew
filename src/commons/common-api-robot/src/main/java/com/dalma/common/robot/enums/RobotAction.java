package com.dalma.common.robot.enums;

public enum RobotAction {
    PAUSE,
    RESUME,
    CANCEL,
    UPDATE;

    public String getAction() {
        return this.name().toLowerCase();
    }

    public static RobotAction getRobotAction(String action) {
        if (action == null) {
            return null;
        }

        for (RobotAction robotAction : values()) {
            if (robotAction.getAction().equalsIgnoreCase(action)) {
                return robotAction;
            }
        }

        return null;
    }
}
