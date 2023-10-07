package chris.postman.converter.postmanconverter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.apache.commons.io.IOUtils;
import org.cschoell.postman.model.PostmanCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

class ConverterTest {

    private final JsonMapper objectMapper = JsonMapper.builder()
            .enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS)
            .enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_VALUES).build();

    @BeforeEach
    void setUp() {
    }

    @Test
    void name() throws IOException {
        final URL resource = ConverterTest.class.getResource("/TestCollection1.json");
        final String collectionString = IOUtils.toString(resource, StandardCharsets.UTF_8);
        final PostmanCollection postmanCollection = objectMapper.readValue(resource, PostmanCollection.class);
        System.out.println(postmanCollection);
    }
}
