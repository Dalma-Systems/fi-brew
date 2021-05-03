package com.dalma.contract.dto.robot.notification;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrokerRobotNotificationStatusData extends BaseRobotNotificationData<String> {
	
	private BrokerRobotNotificationMetadata metadata;
}
