package com.dalma.fibrew.service.exception;

import com.dalma.fibrew.base.error.exception.RestResponseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import static com.dalma.fibrew.service.error.BrokerBridgeExceptionError.ACCESS_ERROR;

@Slf4j
public class BrokerAccessException extends RestResponseException {

	private static final long serialVersionUID = -201655109519419136L;

	public BrokerAccessException(String error) {
		super(ACCESS_ERROR.message(error));
		log.error(ACCESS_ERROR.message(error));
	}

	@Override
	public HttpStatus getHttpStatus() {
		return HttpStatus.INTERNAL_SERVER_ERROR;
	}

	@Override
	public String getErrorCode() {
		return ACCESS_ERROR.code();
	}
}
