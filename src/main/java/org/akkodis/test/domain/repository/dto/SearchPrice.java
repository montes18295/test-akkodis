package org.akkodis.test.domain.repository.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SearchPrice {

    LocalDateTime applicationDate;
    long productId;
    long brandId;

}
