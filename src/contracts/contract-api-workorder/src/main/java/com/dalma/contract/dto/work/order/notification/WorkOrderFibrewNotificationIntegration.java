package com.dalma.contract.dto.work.order.notification;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class WorkOrderFibrewNotificationIntegration {

	private String erpId;
    
	private Date date;
    
	private String workstation;

	private List<WorkOrderFibrewNotificationMaterialIntegration> materials;
	
	@Getter
	@Setter
	public static class WorkOrderFibrewNotificationMaterialIntegration {

		private String materialId;
	
		private String batchNumber;
	    
		private BigDecimal quantity;
	}
}
