package com.dalma.fibrew.api.controller;

import com.dalma.contract.dto.work.order.notification.WorkOrderFibrewNotificationIntegration;
import com.dalma.fibrew.service.NotificationWorkOrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static com.dalma.fibrew.contract.Paths.BASE_PATH;
import static com.dalma.fibrew.contract.Paths.INTEGRATE;
import static com.dalma.fibrew.contract.Paths.NOTIFICATION;
import static com.dalma.fibrew.contract.Paths.WORK_ORDER;

@Validated
@RestController
@RequestMapping(BASE_PATH + NOTIFICATION + WORK_ORDER)
public class NotificationWorkOrderController {
	
	private final NotificationWorkOrderService notificationWorkOrderService;
	
	public NotificationWorkOrderController(NotificationWorkOrderService notificationWorkOrderService) {
		this.notificationWorkOrderService = notificationWorkOrderService;
	}
	
	@PostMapping(INTEGRATE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Integrates the work orders in Modula's database", notes = "Endpoint called by Broker API when the integration callback is executed")
    public void integrate(@RequestBody WorkOrderFibrewNotificationIntegration notification) {
		notificationWorkOrderService.integrateOrder(notification);
    }
}
