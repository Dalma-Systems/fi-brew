package com.dalma.contract.dto.subscription;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class BrokerSubscriptionEntityInputDto {
    private String id;
    private String idPattern;

    @NotBlank
    private String type;
}
