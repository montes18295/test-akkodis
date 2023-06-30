package org.akkodis.test.domain.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class SearchPrice {

    LocalDateTime applicationDate;
    long productId;
    long brandId;

    public SearchPrice() {}

}
