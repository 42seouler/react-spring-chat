package hotechcourse.chat.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;

@Slf4j
public class ObjectConverter extends BaseJsonConverter implements AttributeConverter<Object, String> {

    @Override
    public String convertToDatabaseColumn(Object attribute) {
        final ObjectMapper mapper = getMapper();
        if (attribute == null) {
            return "";
        }
        try {
            return mapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            log.error("Exception while converting to database column", e);
            return null;
        }
    }

    @Override
    public Object convertToEntityAttribute(String dbData) {
        final ObjectMapper mapper = getMapper();
        try {
            if (dbData.isBlank()) {
                return null;
            }
            final String[] parts = dbData.split("\\|", 2);
            return mapper.readValue(parts[1], Class.forName(parts[0]));
        } catch (Exception e) {
            log.error("Exception while converting to entity attribute", e);
            return null;
        }
    }
}
