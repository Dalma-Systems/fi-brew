package com.dalma.contract.dto.robot.notification;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseRobotNotificationData<T> {
	private String type;
	private T value;
}
