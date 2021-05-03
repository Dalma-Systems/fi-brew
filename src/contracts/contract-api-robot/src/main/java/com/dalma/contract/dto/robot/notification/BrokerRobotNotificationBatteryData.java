package com.dalma.contract.dto.robot.notification;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrokerRobotNotificationBatteryData {
	private String type;
	private Integer value;
}
