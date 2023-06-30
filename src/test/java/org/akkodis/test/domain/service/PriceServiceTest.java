package org.akkodis.test.domain.service;

import org.akkodis.test.domain.exception.ArgumentNullException;
import org.akkodis.test.domain.exception.ResourceNotFoundException;
import org.akkodis.test.domain.model.Brand;
import org.akkodis.test.domain.model.Price;
import org.akkodis.test.domain.model.Product;
import org.akkodis.test.domain.repository.PriceRepository;
import org.akkodis.test.domain.repository.dto.SearchPrice;
import org.akkodis.test.domain.service.impl.PriceServiceDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.JavaTimeConversionPattern;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PriceServiceTest {


    private PriceService priceService;

    @Mock
    private PriceRepository priceRepository;

    @BeforeEach
    void setup() {
        this.priceService = new PriceServiceDomain(priceRepository);
    }


    @ParameterizedTest
    @CsvSource(value = {"2020-06-14 10.00.00,35455,1",
            "2020-06-14 16.00.00,35455,1",
            "2020-06-14 21.00.00,35455,1",
            "2020-06-14 18.30.00,35455,1",
            "2020-06-15 10.00.00,35455,1",
            "2020-06-16 21.00.00,35455,1"
    })
    void searchPrice_whenCallExistWithData_thenSuccess(@JavaTimeConversionPattern("yyyy-MM-dd HH.mm.ss")
                                                       LocalDateTime apptime, long productId, long brandId) {

        SearchPrice searchPrice = new SearchPrice(apptime, productId, brandId);

        Price price = this.mockPrice();

        when(priceRepository.getPriceByFilterWithMaxPriority(searchPrice)).thenReturn(Optional.of(price));

        Assertions.assertNotNull(priceService.searchPrice(searchPrice));
        Assertions.assertDoesNotThrow(() -> priceService.searchPrice(searchPrice));
    }

    @ParameterizedTest
    @CsvSource(value = {"2020-06-14 10.00.00,35455,1",
            "2020-06-14 16.00.00,35455,1",
            "2020-06-14 21.00.00,35455,1",
            "2020-06-14 18.30.00,35455,1",
            "2020-06-15 10.00.00,35455,1",
            "2020-06-16 21.00.00,35455,1"
    })
    void searchPrice_whenCallNotExistWithData_thenResourceNotFoundException(@JavaTimeConversionPattern("yyyy-MM-dd HH.mm.ss")
                                                       LocalDateTime apptime, long productId, long brandId) {

        SearchPrice searchPrice = new SearchPrice(apptime, productId, brandId);

        when(priceRepository.getPriceByFilterWithMaxPriority(searchPrice)).thenReturn(Optional.empty());

        Assertions.assertThrows(ResourceNotFoundException.class, () -> priceService.searchPrice(searchPrice));
    }

    @Test
    void searchPrice_whenCallNotExistWithData_thenArgumentNullException() {

        SearchPrice searchPrice = new SearchPrice();

        Assertions.assertThrows(ArgumentNullException.class, () -> priceService.searchPrice(null));
        Assertions.assertThrows(ArgumentNullException.class, () -> priceService.searchPrice(searchPrice));
    }


    private Price mockPrice() {
        Product product = new Product();
        product.setId(1L);

        Brand brand = new Brand();
        brand.setId(1L);

        Price price = new Price();
        price.setPriceList(1);
        price.setBrand(brand);
        price.setProduct(product);
        price.setStartDate(LocalDateTime.MIN);
        price.setStartDate(LocalDateTime.MAX);
        price.setPriority(1L);
        return price;
    }
}
