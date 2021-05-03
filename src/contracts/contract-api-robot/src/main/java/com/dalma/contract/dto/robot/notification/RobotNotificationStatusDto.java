package com.dalma.contract.dto.robot.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RobotNotificationStatusDto extends BaseRobotNotificationDto<String> {
	
	public RobotNotificationStatusDto(String value, String contextId) {
		super.setValue(value);
		this.setContextId(contextId);
	}
	
	private String contextId;
}
