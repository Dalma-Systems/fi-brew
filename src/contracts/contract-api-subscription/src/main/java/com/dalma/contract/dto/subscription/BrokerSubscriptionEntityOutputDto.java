package com.dalma.contract.dto.subscription;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BrokerSubscriptionEntityOutputDto {
    
	private String id;

    private String idPattern;
    
    @NotBlank
    private String type;
}
