package com.dalma.fibrew.service;

import com.dalma.contract.dto.work.order.notification.WorkOrderFibrewNotificationIntegration;
import com.dalma.fibrew.orm.entity.ImpOrdini;
import com.dalma.fibrew.orm.entity.ImpOrdiniRighe;
import com.dalma.fibrew.orm.repository.ImpOrdiniRepository;
import com.dalma.fibrew.orm.repository.ImpOrdiniRigheRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Slf4j
@Service
public class NotificationWorkOrderService {
	
	private static final String DEFAULT_STATUS = "WAIT";
	private final ImpOrdiniRepository impOrdiniRepository;
	private final ImpOrdiniRigheRepository impOrdiniRigheRepository;
	private final ObjectMapper objectMapper;
	
	public NotificationWorkOrderService(ImpOrdiniRepository impOrdiniRepository, ImpOrdiniRigheRepository impOrdiniRigheRepository, ObjectMapper objectMapper) {
		this.impOrdiniRepository = impOrdiniRepository;
		this.impOrdiniRigheRepository = impOrdiniRigheRepository;
		this.objectMapper = objectMapper;
	}

	/**
	 * Currently the only action that FIBREW makes with order integration
	 * is store it in Modula database.
	 * 
	 * @param notificationOrder order integration data
	 */
	@Transactional
	public void integrateOrder(WorkOrderFibrewNotificationIntegration notificationOrder) {
		ImpOrdini order = new ImpOrdini();
		
		// Schedule date
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(notificationOrder.getDate());
		order.setOrdDate(calendar);
		
		// Order erp id (manufacture order)
		order.setOrdOf(new BigDecimal(notificationOrder.getErpId()));
		
		// Default status - WAIT
		order.setOrdStatus(DEFAULT_STATUS);
		
		// Schedule hour
		order.setOrdTime(new SimpleDateFormat("HH:mm").format(notificationOrder.getDate()));
		
		order = impOrdiniRepository.save(order);
		try {
			log.info("Order received to integrate {}", objectMapper.writeValueAsString(notificationOrder));
			log.info("Integrated order {}", objectMapper.writeValueAsString(order));
		} catch (JsonProcessingException e) {
			// Unable to log, no action required
		}
		
		// The current database structure only supports one material for each work order, thus
		// it will be used hardcoded the first material.
		ImpOrdiniRighe orderLine = new ImpOrdiniRighe();

		// Id to connect with IMP_ORDINI
		orderLine.setRigOrdine(order.getOrdOrdine());
		
		// material id
		orderLine.setRigArticolo(notificationOrder.getMaterials().get(0).getMaterialId().replaceFirst("^0*", Strings.EMPTY));
		
		// workstation id
		orderLine.setRigHostcaus(notificationOrder.getWorkstation());
		
		// order erp id (manufacture order)
		orderLine.setRigOf(new BigDecimal(notificationOrder.getErpId()));
		
		// material quantity
		orderLine.setRigQtar(notificationOrder.getMaterials().get(0).getQuantity());
		
		// default status - WAIT
		orderLine.setRigStatus(DEFAULT_STATUS);
		
		// batch number
		orderLine.setRigSub1(notificationOrder.getMaterials().get(0).getBatchNumber());
		
		impOrdiniRigheRepository.save(orderLine);
		try {
			log.info("Integrated order lines {}", objectMapper.writeValueAsString(orderLine));
		} catch (JsonProcessingException e) {
			// Unable to log, no action required
		}
	}
}
