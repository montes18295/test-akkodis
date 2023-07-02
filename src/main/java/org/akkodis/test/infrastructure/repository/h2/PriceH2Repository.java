package org.akkodis.test.infrastructure.repository.h2;

import org.akkodis.test.domain.model.Price;
import org.akkodis.test.domain.repository.PriceRepository;
import org.akkodis.test.domain.repository.dto.SearchPrice;
import org.akkodis.test.infrastructure.repository.h2.dbo.PriceDbo;
import org.akkodis.test.infrastructure.repository.h2.springdata.PriceSpringDataRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Primary
public class PriceH2Repository implements PriceRepository {

    private final PriceSpringDataRepository priceSpringDataRepository;

    private final ModelMapper modelMapper;

    public PriceH2Repository(PriceSpringDataRepository priceSpringDataRepository, ModelMapper modelMapper) {
        this.priceSpringDataRepository = priceSpringDataRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Price> getPriceByFilterWithMaxPriority(SearchPrice searchPrice) {

        Optional<PriceDbo> optionalPriceDbo = priceSpringDataRepository
                    .findMaxPriorityByApplicationDateAndProductIdAndBrandId(
                            searchPrice.getApplicationDate(),
                            searchPrice.getProductId(), searchPrice.getBrandId());

        return optionalPriceDbo.isEmpty() ?
                Optional.empty() :
                Optional.of(modelMapper.map(optionalPriceDbo.get(), Price.class));
    }
}
