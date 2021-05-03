package com.dalma.contract.dto.work.order.notification;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class WorkOrderLatteNotificationIntegration {
	
    private String id;
    
    private Date date;
    
    private List<String> scheduleIds;
}
