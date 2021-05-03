package com.dalma.contract.dto.robot.notification;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrokerRobotNotificationLocationData {
	private String type;
	private BrokerRobotNotificationLocationPointData value;
}
