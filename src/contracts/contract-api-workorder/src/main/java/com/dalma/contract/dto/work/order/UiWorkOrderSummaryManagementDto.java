package com.dalma.contract.dto.work.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UiWorkOrderSummaryManagementDto implements BaseUiWorkOrderSummaryManagementDto {

    private String id;

    private String type;

    private String scheduleAt;

    private WorkOrderStatusSummary status;

    private String erpId;

    private String dtCreated;

    private String dtModified;

    private String warehouseId;

    private String warehouse;

    private String workstationId;

    private String workstation;

    private String startedAt;

    private String endedAt;

    private List<UiWorkOrderItemSummaryManagementDto> materials;

    public enum WorkOrderStatusSummary {
        RUNNING,
        SCHEDULED,
        COMPLETED,
        CANCELED,
        PAUSED;
    }
}
