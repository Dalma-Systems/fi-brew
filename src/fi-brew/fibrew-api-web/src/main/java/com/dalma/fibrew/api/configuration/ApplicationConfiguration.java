package com.dalma.fibrew.api.configuration;

import com.bybright.logging.annotation.EnableRequestLogFilter;
import com.dalma.fibrew.base.config.ModelMapperConfiguration;
import com.dalma.fibrew.base.controller.RestErrorController;
import com.dalma.fibrew.base.controller.advice.ErrorHandlingControllerAdvice;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@Import({ModelMapperConfiguration.class, ErrorHandlingControllerAdvice.class, RestErrorController.class,
        SentryConfiguration.class})
@EnableAsync
@EnableCaching
@EnableScheduling
@EnableRequestLogFilter
public class ApplicationConfiguration {

}