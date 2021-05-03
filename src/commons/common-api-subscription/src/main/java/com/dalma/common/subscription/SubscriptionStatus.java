package com.dalma.common.subscription;

public enum SubscriptionStatus {
	ACTIVE,
	INACTIVE,
	EXPIRED;
	
	public String getStatus() {
		return this.name().toLowerCase();
	}
}
