package org.akkodis.test.application.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SearchPriceRequest {

    @NotNull
    LocalDateTime applicationDate;

    @NotNull
    @Min(1)
    long productId;

    @NotNull
    @Min(1)
    long brandId;

}
