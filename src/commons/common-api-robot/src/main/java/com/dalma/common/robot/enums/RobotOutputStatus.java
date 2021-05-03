package com.dalma.common.robot.enums;

public enum RobotOutputStatus {
	IDLE, WORKING, STOPPED, CHARGING, LOADING_MATERIAL, UNLOADING_MATERIAL;

	private static final RobotOutputStatus[] workOrderRelatedStatus = new RobotOutputStatus[] {LOADING_MATERIAL, UNLOADING_MATERIAL};
	
	public static RobotOutputStatus getRobotOutputStatusByStatus(String status) {
		RobotStatus robotStatus = RobotStatus.getRobotStatus(status);
		if (status == null) {
			return getRobotWorkOrderRelatedStatus(status);
		}

		switch (robotStatus) {
		case IDLE:
			return RobotOutputStatus.IDLE;

		case CHARGING:
			return RobotOutputStatus.CHARGING;

		case PAUSED:
		case STOPPED:
			return RobotOutputStatus.STOPPED;
		
		case MOVING:
		case READY:
		default:
			return RobotOutputStatus.WORKING;
		}
	}
	
	public static RobotOutputStatus getRobotWorkOrderRelatedStatus(String status) {
		if (status == null) {
			return null;
		}
		
		for (RobotOutputStatus s : workOrderRelatedStatus) {
			if (s.name().equalsIgnoreCase(status)) {
				return s;
			}
		}
		return null;
	}
}
