package org.akkodis.test.infrastructure.repository.h2.dbo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "product")
@Data
public class ProductDbo {

    @Id
    long id;

    @Column(name = "product_name")
    String product;

}
