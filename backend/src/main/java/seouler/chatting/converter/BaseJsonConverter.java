package seouler.chatting.converter;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class BaseJsonConverter {

    private static final ObjectMapper MAPPER;

    static {
        MAPPER = new ObjectMapper();
    }

    public static ObjectMapper getMapper() {
        return MAPPER;
    }
}
