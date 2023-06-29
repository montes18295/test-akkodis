package org.akkodis.test.infrastructure.repository.h2.springdata;

import org.akkodis.test.infrastructure.repository.h2.dbo.PriceDbo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceSpringDataRepository extends JpaRepository<PriceDbo, Long> {
}
