package com.dalma.common.robot.enums;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class RobotOutputStatusTest {

	@Test
	public void testGetRobotOutputStatusByStatus() {
		assertNull(RobotOutputStatus.getRobotOutputStatusByStatus(null));
		assertEquals(RobotOutputStatus.IDLE, RobotOutputStatus.getRobotOutputStatusByStatus(RobotStatus.IDLE.getStatus()));
		assertEquals(RobotOutputStatus.CHARGING, RobotOutputStatus.getRobotOutputStatusByStatus(RobotStatus.CHARGING.getStatus()));
		assertEquals(RobotOutputStatus.WORKING, RobotOutputStatus.getRobotOutputStatusByStatus(RobotStatus.MOVING.getStatus()));
		assertEquals(RobotOutputStatus.WORKING, RobotOutputStatus.getRobotOutputStatusByStatus(RobotStatus.READY.getStatus()));
		assertEquals(RobotOutputStatus.STOPPED, RobotOutputStatus.getRobotOutputStatusByStatus(RobotStatus.STOPPED.getStatus()));
		assertNull(RobotStatus.getRobotStatus("FAKE_STATUS"));
	}
}
