package com.dalma.common.robot.enums;

import lombok.Getter;

import java.util.List;

@Getter
public enum RobotStatus {
	IDLE("idle") { // identify that robot has nothing to do and is in position zero
		@Override
		public List<RobotStatus> nextState() {
			return List.of(MOVING, PAUSED, CHARGING);
		}
	},
	MOVING("moving") { // identify that robot is moving to destination (warehouse/working station)
		@Override
		public List<RobotStatus> nextState() {
			return List.of(IDLE, STOPPED, PAUSED);
		}
	},
	STOPPED("stopped") { // identify that robot is stopped in destination waiting for manual trigger
		@Override
		public List<RobotStatus> nextState() {
			return List.of(READY, MOVING, PAUSED);
		}
	},
	READY("ready") { // identify that robot is in destination ready to go to next destination
		@Override
		public List<RobotStatus> nextState() {
			return List.of(MOVING, PAUSED);
		}
	},
	PAUSED("paused") { // identify that robot was stopped by manual action in UI (supervisor / robot)
		@Override
		public List<RobotStatus> nextState() {
			return List.of(MOVING, IDLE, STOPPED, CHARGING);
		}
	},
	CHARGING("charging") { // identify that robot is charging
		@Override
		public List<RobotStatus> nextState() {
			return List.of(PAUSED, IDLE);
		}
	},
	UPDATE("update") { // identify that robot is performing update (not yet supported by robot)
		@Override
		public List<RobotStatus> nextState() {
			return List.of(IDLE);
		}
	},
	;

	private String status;

	private RobotStatus(String status) {
		this.status = status;
	}
	
    public abstract List<RobotStatus> nextState();

	public static RobotStatus getRobotStatus(String status) {
		if (status == null) {
			return null;
		}

		for (RobotStatus robotStatus : values()) {
			if (robotStatus.getStatus().equals(status)) {
				return robotStatus;
			}
		}
		return null;
	}
}
