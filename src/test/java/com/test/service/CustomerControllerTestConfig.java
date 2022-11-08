package com.test.service;

import com.test.service.CustomerServiceImpl;
import com.test.service.ICustomerService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.test")
public class CustomerControllerTestConfig {
    @Bean
    public ICustomerService customerService() {
        return Mockito.mock(CustomerServiceImpl.class);
    }
}
