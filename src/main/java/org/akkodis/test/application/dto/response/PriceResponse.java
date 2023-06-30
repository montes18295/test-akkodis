package org.akkodis.test.application.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PriceResponse {
    long productId;
    long brandId;
    long priceList;
    LocalDateTime startDate;
    LocalDateTime endDate;
    BigDecimal price;
}
