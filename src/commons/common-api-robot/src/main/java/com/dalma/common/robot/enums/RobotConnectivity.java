package com.dalma.common.robot.enums;

import lombok.Getter;

@Getter
public enum RobotConnectivity {
	ONLINE("online"), 
	OFFLINE("offline"),
	;

	private String connectivity;

	private RobotConnectivity(String connectivity) {
		this.connectivity = connectivity;
	}
	
	public static RobotConnectivity getRobotConnectivity(String connectivity) {
		if (connectivity == null) {
			return null;
		}
		
		for (RobotConnectivity c : values()) {
			if (c.getConnectivity().equalsIgnoreCase(connectivity)) {
				return c;
			}
		}
		
		return null;
	}
}
