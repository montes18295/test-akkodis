package org.akkodis.test.infrastructure.repository.h2.springdata;

import org.akkodis.test.infrastructure.repository.h2.dbo.PriceDbo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PriceSpringDataRepository extends JpaRepository<PriceDbo, Long> {

    @Query("FROM PriceDbo " +
            "WHERE startDate <= :date " +
            "AND endDate >= :date " +
            "AND product.id = :productId " +
            "AND brand.id = :brandId " +
            "ORDER BY priority DESC " +
            "LIMIT 1")
    Optional<PriceDbo> findMaxPriorityByApplicationDateAndProductIdAndBrandId(
            @Param("date") LocalDateTime date,
            @Param("productId") long productId,
            @Param("brandId") long brandId);

}
