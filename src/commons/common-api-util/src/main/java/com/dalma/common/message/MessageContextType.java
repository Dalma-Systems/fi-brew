package com.dalma.common.message;

import lombok.Getter;

@Getter
public enum MessageContextType {
	WORK_ORDER("order"),
	ACTION("action"),
	UNKNOWN("unknown")
	;
	
	private String type;
	
	MessageContextType(String type) {
		this.type = type;
	}
	
	public static MessageContextType getMessageContextType(String type) {
		if (type == null) {
			return null;
		}
		
		for (MessageContextType t : values()) {
			if (t.getType().equals(type)) {
				return t;
			}
		}
		
		return null;
	}
}
