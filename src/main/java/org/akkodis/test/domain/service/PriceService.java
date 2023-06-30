package org.akkodis.test.domain.service;

import org.akkodis.test.domain.model.Price;
import org.akkodis.test.domain.repository.dto.SearchPrice;

public interface PriceService {

    /**
     * <p>Obtiene un precio por los filtros obtenidos por parámetros.</p>
     *
     * @param searchPrice <p>Objeto con los campos para filtrar el precio</p>
     * @return <p>Precio obtenido.</p>
     */
    Price searchPrice(SearchPrice searchPrice);

}
