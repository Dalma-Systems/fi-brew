package com.dalma.contract.dto.work.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UiWorkOrderItemSummaryManagementDto {

    private String id;

    private Double quantity;

    private String type;

    private String unit;

    private String batch;
}
