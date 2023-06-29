package org.akkodis.test.domain.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Price {

    Brand brand;
    Product product;
    LocalDateTime startDate;
    LocalDateTime endDate;
    long priceList;
    long priority;
    BigDecimal price;

}
