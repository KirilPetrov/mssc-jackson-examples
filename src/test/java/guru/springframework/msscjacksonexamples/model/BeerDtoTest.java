package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("kebab")
@JsonTest
class BeerDtoTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void testSerialization() throws JsonProcessingException {
        BeerDto dto = getBeer();

        String json = objectMapper.writeValueAsString(dto);

        System.out.println(json);
    }

    private BeerDto getBeer() {
        return BeerDto.builder()
                .beerName("Glarus")
                .id(UUID.randomUUID())
                .beerStyle("Ale")
                .lastUpdatedDate(OffsetDateTime.now())
                .createdDate(OffsetDateTime.now())
                .price(new BigDecimal("2.55"))
                .upc(2134456754374L)
                .build();
    }
}