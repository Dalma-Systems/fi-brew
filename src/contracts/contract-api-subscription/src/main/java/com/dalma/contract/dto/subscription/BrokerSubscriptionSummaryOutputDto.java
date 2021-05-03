package com.dalma.contract.dto.subscription;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

import java.util.List;

@Getter
@Setter
public class BrokerSubscriptionSummaryOutputDto {
    @NotBlank
	private String id;

    @NotBlank
	private String status;
    
    @NotBlank
    private List<BrokerSubscriptionEntityOutputDto> entities;

    @NotBlank
    private List<String> attributes;
    
    @NotBlank
    private String notificationUrl;
}
