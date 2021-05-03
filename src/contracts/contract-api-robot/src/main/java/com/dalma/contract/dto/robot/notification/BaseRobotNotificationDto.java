package com.dalma.contract.dto.robot.notification;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public abstract class BaseRobotNotificationDto<T> {

	@NotBlank
	private T value;
}
