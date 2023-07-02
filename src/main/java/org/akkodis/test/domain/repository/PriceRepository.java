package org.akkodis.test.domain.repository;

import org.akkodis.test.domain.model.Price;
import org.akkodis.test.domain.repository.dto.SearchPrice;

import java.util.Optional;

public interface PriceRepository {

    /**
     * <p>Busca en la fuente de datos implementada un precio por los filtros pasados por parametros.</p>
     *
     * @param searchPrice <p>Objeto con los campos para filtrar el precio</p>
     * @return <p>Optional con posible precio encontrado</p>
     */
    Optional<Price> getPriceByFilterWithMaxPriority(SearchPrice searchPrice);

}
