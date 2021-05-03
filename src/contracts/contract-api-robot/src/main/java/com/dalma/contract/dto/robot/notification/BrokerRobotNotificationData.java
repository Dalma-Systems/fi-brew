package com.dalma.contract.dto.robot.notification;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrokerRobotNotificationData {
	private String id;
	private String type;
	private BrokerRobotNotificationBatteryData battery;
	private BrokerRobotNotificationStatusData status;
	private BrokerRobotNotificationLocationData location;
	private BrokerRobotNotificationHeartbeatData heartbeat;
}
