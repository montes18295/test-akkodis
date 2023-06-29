package org.akkodis.test.infrastructure.repository.h2.dbo;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "prices")
@Data
public class PriceDbo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @ManyToOne
    BrandDbo brand;
    @ManyToOne
    ProductDbo product;
    LocalDateTime startDate;
    LocalDateTime endDate;
    long priceList;
    long priority;
    BigDecimal price;
    String curr;

}
