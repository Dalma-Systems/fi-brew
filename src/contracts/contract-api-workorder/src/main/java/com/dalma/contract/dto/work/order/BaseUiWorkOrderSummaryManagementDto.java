package com.dalma.contract.dto.work.order;

import com.dalma.contract.dto.work.order.UiWorkOrderSummaryManagementDto.WorkOrderStatusSummary;

import java.util.List;

public interface BaseUiWorkOrderSummaryManagementDto {
	public String getScheduleAt();
	public WorkOrderStatusSummary getStatus();
	public String getStartedAt();
	public String getEndedAt();
	public String getErpId();
	public String getWorkstation();
	public String getWarehouse();
	public void setMaterials(List<UiWorkOrderItemSummaryManagementDto> materials);
}
