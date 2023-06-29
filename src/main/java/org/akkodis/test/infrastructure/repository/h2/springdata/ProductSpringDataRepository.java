package org.akkodis.test.infrastructure.repository.h2.springdata;

import org.akkodis.test.infrastructure.repository.h2.dbo.ProductDbo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSpringDataRepository extends JpaRepository<ProductDbo, Long> {
}
