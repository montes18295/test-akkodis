package org.akkodis.test.domain.service.impl;

import org.akkodis.test.domain.repository.PriceRepository;
import org.akkodis.test.domain.service.PriceService;

public class PriceServiceDomain implements PriceService {

    private final PriceRepository priceRepository;

    public PriceServiceDomain(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }
}
