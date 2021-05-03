package com.dalma.contract.dto.work.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@AllArgsConstructor
@NoArgsConstructor
public class BrokerWorkOrderIntegrateOutputDto extends BrokerWorkOrderOutputDto {

    private boolean success;
}
