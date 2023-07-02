package org.akkodis.test.application;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.yml")
public class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @CsvSource(value = {"2020-06-14 10.00.00,35455,1",
            "2020-06-14 16.00.00,35455,1",
            "2020-06-14 21.00.00,35455,1",
            "2020-06-14 18.30.00,35455,1",
            "2020-06-15 10.00.00,35455,1",
            "2020-06-16 21.00.00,35455,1"
    })
    public void getPriceByFilter(String apptime,
                                 long productId, long brandId) throws Exception {

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mm.ss");
        String iso8601DateTime = LocalDateTime.parse(apptime, inputFormatter)
                .atZone(ZoneOffset.UTC)
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));

        mockMvc.perform(MockMvcRequestBuilders.get("/prices/filter")
                        .accept(MediaType.APPLICATION_JSON)
                        .param("applicationDate", iso8601DateTime)
                        .param("productId", String.valueOf(productId))
                        .param("brandId", String.valueOf(brandId)))
                .andDo(print())
                .andExpect(status().isOk());
    }


}
