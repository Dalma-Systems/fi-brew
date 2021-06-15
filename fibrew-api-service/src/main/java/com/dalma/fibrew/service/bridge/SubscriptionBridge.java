package com.dalma.fibrew.service.bridge;

import com.dalma.common.util.Constant;
import com.dalma.contract.dto.subscription.BrokerSubscriptionInputDto;
import com.dalma.contract.dto.subscription.BrokerSubscriptionSummaryOutputDto;
import com.dalma.fibrew.service.enums.BrokerApiPath;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubscriptionBridge {

    private final ObjectMapper objectMapper;
    private final BrokerBridge brokerBridge;

    public SubscriptionBridge(ObjectMapper objectMapper, BrokerBridge brokerBridge) {
        this.objectMapper = objectMapper;
        this.brokerBridge = brokerBridge;
    }

    public void createSubscription(BrokerSubscriptionInputDto brokerSubscription) throws JsonProcessingException {
        brokerBridge.postToBroker(objectMapper.writeValueAsString(brokerSubscription),
                BrokerApiPath.SUBSCRIPTION.getPath());
    }
    
    public List<BrokerSubscriptionSummaryOutputDto> getSubscriptionByAttribute(String attribute) throws JsonProcessingException {
    	String output = brokerBridge.getFromBroker(new StringBuilder(BrokerApiPath.SUBSCRIPTION.getPath())
    			.append(BrokerApiPath.CONDITION.getPath()).append(Constant.QUERY).append("attr").append(Constant.EQUAL)
    			.append(attribute).toString());
    	return objectMapper.readValue(output, new TypeReference<List<BrokerSubscriptionSummaryOutputDto>>() {
        });
    }
}
