package org.akkodis.test.application;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.akkodis.test.application.dto.request.SearchPriceRequest;
import org.akkodis.test.application.dto.response.PriceResponse;
import org.akkodis.test.domain.model.Price;
import org.akkodis.test.domain.repository.dto.SearchPrice;
import org.akkodis.test.domain.service.PriceService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("prices")
public class PriceController {

    private final PriceService priceService;

    private final ModelMapper modelMapper;

    public PriceController(PriceService priceService, ModelMapper modelMapper) {
        this.priceService = priceService;
        this.modelMapper = modelMapper;
    }

    @Operation(summary = "Obtiene un precio por los filtros proporcionados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Precio encontrado",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PriceResponse.class)) }),
            @ApiResponse(responseCode = "400", description = "Datos de entrada no válidos.",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Precio no encontrado",
                    content = @Content) })
    @GetMapping("/filter")
    public PriceResponse getPriceByFilter(@Valid SearchPriceRequest searchPriceRequest) {

        Price price = priceService.searchPrice(modelMapper.map(searchPriceRequest, SearchPrice.class));
        return modelMapper.map(price, PriceResponse.class);
    }

}
