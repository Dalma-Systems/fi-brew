package com.dalma.contract.dto.robot.notification;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrokerRobotNotificationLocationPointData {
	private String type;
	private Double[] coordinates;
}
