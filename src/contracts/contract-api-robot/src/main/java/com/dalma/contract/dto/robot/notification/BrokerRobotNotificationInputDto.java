package com.dalma.contract.dto.robot.notification;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BrokerRobotNotificationInputDto {
	private String subscriptionId;
	private List<BrokerRobotNotificationData> data;
}
