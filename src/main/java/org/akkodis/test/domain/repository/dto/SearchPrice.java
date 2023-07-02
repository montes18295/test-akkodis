package org.akkodis.test.domain.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchPrice {

    LocalDateTime applicationDate;
    long productId;
    long brandId;

}
