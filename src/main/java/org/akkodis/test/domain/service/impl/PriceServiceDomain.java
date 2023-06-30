package org.akkodis.test.domain.service.impl;

import org.akkodis.test.domain.exception.ArgumentNullException;
import org.akkodis.test.domain.exception.ResourceNotFoundException;
import org.akkodis.test.domain.model.Price;
import org.akkodis.test.domain.repository.PriceRepository;
import org.akkodis.test.domain.repository.dto.SearchPrice;
import org.akkodis.test.domain.service.PriceService;

import java.util.Optional;

public class PriceServiceDomain implements PriceService {

    private final PriceRepository priceRepository;

    public PriceServiceDomain(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    /**
     * {@inheritDoc}
     *
     * @throws org.akkodis.test.domain.exception.ResourceNotFoundException <p>En caso de no encontrar ningún precio.</p>
     * @throws org.akkodis.test.domain.exception.ArgumentNullException <p>En caso de obtener null en el parámetro.</p>
     * @throws org.akkodis.test.domain.exception.MultipleResultException <p>En el caso de obtener mas de un resultado</p>
     */
    @Override
    public Price searchPrice(SearchPrice searchPrice) {

        if (searchPrice == null || searchPrice.getApplicationDate() == null) {
            throw new ArgumentNullException();
        }

        Optional<Price> optionalPrice = priceRepository.getPriceByFilterWithMaxPriority(searchPrice);

        return optionalPrice.orElseThrow(ResourceNotFoundException::new);
    }
}
