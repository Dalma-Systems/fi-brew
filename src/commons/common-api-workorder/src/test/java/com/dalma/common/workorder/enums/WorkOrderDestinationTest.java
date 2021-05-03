package com.dalma.common.workorder.enums;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WorkOrderDestinationTest {
	@Test
	public void testWorkOrderDestinationTransaction() {
		assertEquals(WorkOrderDestination.WORK_STATION, WorkOrderDestination.WAREHOUSE.nextState());
		assertEquals(WorkOrderDestination.POSITION_ZERO, WorkOrderDestination.WORK_STATION.nextState());
		assertEquals(WorkOrderDestination.WAREHOUSE, WorkOrderDestination.POSITION_ZERO.nextState());
	}
}
