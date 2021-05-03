package com.dalma.fibrew.service.seed;

import com.dalma.common.entity.EntityType;
import com.dalma.common.subscription.SubscriptionStatus;
import com.dalma.common.util.Constant;
import com.dalma.contract.dto.subscription.BrokerSubscriptionEntityInputDto;
import com.dalma.contract.dto.subscription.BrokerSubscriptionInputDto;
import com.dalma.contract.dto.subscription.BrokerSubscriptionSummaryOutputDto;
import com.dalma.fibrew.service.bridge.SubscriptionBridge;
import com.dalma.fibrew.service.enums.BrokerApiPath;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.dalma.fibrew.contract.Paths.APPLICATION;

@Slf4j
@Order(1)
@Component
public class SeedWorkOrderIntegrationNotification implements ApplicationListener<ServletWebServerInitializedEvent> {
	
    @Value("${dalma.subscription.notification.url}")
    private String subscriptionUrl;

	private final SubscriptionBridge subscriptionBridge;
	
	public SeedWorkOrderIntegrationNotification(SubscriptionBridge subscriptionBridge) {
		this.subscriptionBridge = subscriptionBridge;
	}
	
	@Override
    public void onApplicationEvent(ServletWebServerInitializedEvent event) {
		seedNotification();
    }

	private void seedNotification() {
		try {
			List<BrokerSubscriptionSummaryOutputDto> subscriptions = subscriptionBridge.getSubscriptionByAttribute(Constant.INTEGRATED_AT);
			if (subscriptions == null) {
				createSubscription();
				return;
			}
			
			Optional<BrokerSubscriptionSummaryOutputDto> integrationSubscription = subscriptions.stream()
							.filter(subscription -> (SubscriptionStatus.ACTIVE.getStatus().equals(subscription.getStatus()) 
													&& subscription.getAttributes().contains(Constant.INTEGRATED_AT)
													&& subscription.getNotificationUrl().contains(APPLICATION)))
							.findFirst();
			if (integrationSubscription.isPresent()) {
				log.info("[SEEDING] - Integration subscription already exists and is active: {}", integrationSubscription.get().getId());
				return;
			}
			
			createSubscription();
		} catch (JsonProcessingException e) {
			log.error("[SEEDING] - Error creating retrieving subscription", e);
		}
	}

	private void createSubscription() {
		BrokerSubscriptionInputDto request = new BrokerSubscriptionInputDto();

        BrokerSubscriptionEntityInputDto entity = new BrokerSubscriptionEntityInputDto();
        entity.setIdPattern(".*");
        entity.setType(EntityType.WORK_ORDER.getType());
        List<BrokerSubscriptionEntityInputDto> entities = List.of(entity);
        request.setEntities(entities);
        
        request.setNotificationAttributes(List.of(Constant.ID, Constant.INTEGRATED_AT));
        request.setAttributes(List.of(Constant.INTEGRATED_AT));
        request.setNotificationUrl(new StringBuilder(subscriptionUrl).append(BrokerApiPath.WORK_ORDER_NOTIFICATION_INTEGRATE_FIBREW.getPath()).toString());

        try {
			subscriptionBridge.createSubscription(request);
			log.info("[SEEDING] - Created integration subscription");
		} catch (JsonProcessingException e) {
			log.error("Error creating integration subscription", e);
		}
	}
}
