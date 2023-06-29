package org.akkodis.test.infrastructure.repository.h2.springdata;

import org.akkodis.test.infrastructure.repository.h2.dbo.BrandDbo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandSpringDataRepository extends JpaRepository<BrandDbo, Long> {
}
