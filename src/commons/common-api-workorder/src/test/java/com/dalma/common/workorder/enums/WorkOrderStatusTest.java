package com.dalma.common.workorder.enums;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class WorkOrderStatusTest {
	@Test
	public void testWorkOrderStatusTransaction() {
		assertEquals(WorkOrderStatus.ASSIGNED, WorkOrderStatus.SCHEDULED.nextState());
		assertEquals(WorkOrderDestination.POSITION_ZERO, WorkOrderStatus.SCHEDULED.currentDestination());
		assertEquals(WorkOrderDestination.POSITION_ZERO, WorkOrderStatus.SCHEDULED.nextDestination());
		
		assertEquals(WorkOrderStatus.STARTED, WorkOrderStatus.ASSIGNED.nextState());
		assertEquals(WorkOrderDestination.POSITION_ZERO, WorkOrderStatus.ASSIGNED.currentDestination());
		assertEquals(WorkOrderDestination.WAREHOUSE, WorkOrderStatus.ASSIGNED.nextDestination());
		
		assertEquals(WorkOrderStatus.LOADING_MATERIAL, WorkOrderStatus.STARTED.nextState());
		assertEquals(WorkOrderDestination.WAREHOUSE, WorkOrderStatus.STARTED.currentDestination());
		assertEquals(WorkOrderDestination.WAREHOUSE, WorkOrderStatus.STARTED.nextDestination());
		
		assertEquals(WorkOrderStatus.TRANSPORTING_MATERIAL, WorkOrderStatus.LOADING_MATERIAL.nextState());
		assertEquals(WorkOrderDestination.WAREHOUSE, WorkOrderStatus.LOADING_MATERIAL.currentDestination());
		assertEquals(WorkOrderDestination.WORK_STATION, WorkOrderStatus.LOADING_MATERIAL.nextDestination());
		
		assertEquals(WorkOrderStatus.UNLOADING_MATERIAL, WorkOrderStatus.TRANSPORTING_MATERIAL.nextState());
		assertEquals(WorkOrderDestination.WORK_STATION, WorkOrderStatus.TRANSPORTING_MATERIAL.currentDestination());
		assertEquals(WorkOrderDestination.WORK_STATION, WorkOrderStatus.TRANSPORTING_MATERIAL.nextDestination());
		
		assertEquals(WorkOrderStatus.ENDED, WorkOrderStatus.UNLOADING_MATERIAL.nextState());
		assertEquals(WorkOrderDestination.WORK_STATION, WorkOrderStatus.UNLOADING_MATERIAL.currentDestination());
		assertEquals(WorkOrderDestination.POSITION_ZERO, WorkOrderStatus.UNLOADING_MATERIAL.nextDestination());
		
		assertNull(WorkOrderStatus.ENDED.nextState());
		assertEquals(WorkOrderDestination.POSITION_ZERO, WorkOrderStatus.ENDED.currentDestination());
		assertEquals(WorkOrderDestination.POSITION_ZERO, WorkOrderStatus.ENDED.nextDestination());
		
		assertNull(WorkOrderStatus.CANCELED.nextState());
		assertNull(WorkOrderStatus.CANCELED.currentDestination());
		assertEquals(WorkOrderDestination.POSITION_ZERO, WorkOrderStatus.CANCELED.nextDestination());
	}
	
	@Test
	public void testWorkOrderStatus() {
		assertEquals("assigned", WorkOrderStatus.ASSIGNED.getStatus());
		assertEquals(WorkOrderStatus.TRANSPORTING_MATERIAL, WorkOrderStatus.getWorkOrderStatus(WorkOrderStatus.TRANSPORTING_MATERIAL.getStatus()));
		assertNull(WorkOrderStatus.getWorkOrderStatus(null));
		assertNull(WorkOrderStatus.getWorkOrderStatus("FAKE"));
	}
}
