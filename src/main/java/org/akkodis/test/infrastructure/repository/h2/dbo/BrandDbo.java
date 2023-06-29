package org.akkodis.test.infrastructure.repository.h2.dbo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "brand")
@Data
public class BrandDbo {

    @Id
    long id;

    @Column(name = "brand_name")
    String brand;

}
