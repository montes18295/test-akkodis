package org.akkodis.test.infrastructure.repository.h2;

import org.akkodis.test.domain.repository.PriceRepository;
import org.akkodis.test.infrastructure.repository.h2.springdata.PriceSpringDataRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PriceH2Repository implements PriceRepository {

    private final PriceSpringDataRepository priceSpringDataRepository;

    public PriceH2Repository(PriceSpringDataRepository priceSpringDataRepository) {
        this.priceSpringDataRepository = priceSpringDataRepository;
    }
}
