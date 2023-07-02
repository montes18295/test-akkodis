package org.akkodis.test.infrastructure.configuration;

import org.akkodis.test.Application;
import org.akkodis.test.domain.repository.PriceRepository;
import org.akkodis.test.domain.service.PriceService;
import org.akkodis.test.domain.service.impl.PriceServiceDomain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Application.class)
public class BeanConfiguration {

    @Bean
    PriceService priceService(PriceRepository priceRepository) {
        return new PriceServiceDomain(priceRepository);
    }

}
