package seouler.chatting.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import seouler.chatting.entity.User;

import javax.persistence.AttributeConverter;
import javax.print.attribute.Attribute;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseListConverter<T> extends BaseJsonConverter implements AttributeConverter<List<T>, String> {

    @Override
    public String convertToDatabaseColumn(List<T> attribute) {
        final ObjectMapper mapper = getMapper();
        if (attribute == null || attribute.isEmpty()) {
            return "";
        }
        try {
            return mapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    @Override
    public List<T> convertToEntityAttribute(String dbData) {
        final ObjectMapper mapper = getMapper();
        try {
            return mapper.readValue(dbData, List.class);
        } catch (IOException e) {
            return null;
        }
    }
}
