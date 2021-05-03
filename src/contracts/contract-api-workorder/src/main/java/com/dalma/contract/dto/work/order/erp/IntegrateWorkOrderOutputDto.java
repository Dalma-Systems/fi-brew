package com.dalma.contract.dto.work.order.erp;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class IntegrateWorkOrderOutputDto {
	private List<String> workOrderIds = new ArrayList<>();
	private List<String> errors = new ArrayList<>();
}
