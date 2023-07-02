package org.akkodis.test.infrastructure.repository.h2.springdata;

import org.akkodis.test.infrastructure.repository.h2.dbo.PriceDbo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PriceSpringDataRepository extends JpaRepository<PriceDbo, Long> {

    Optional<PriceDbo> findFirstByStartDateBeforeAndEndDateAfterAndProductIdAndBrandIdOrderByPriorityDesc(
            LocalDateTime beforeStartDate, LocalDateTime afterEndDate, long productId, long brandId);

}
