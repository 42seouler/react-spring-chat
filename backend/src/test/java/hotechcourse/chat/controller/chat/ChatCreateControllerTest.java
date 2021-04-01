package hotechcourse.chat.controller.chat;

import com.fasterxml.jackson.databind.ObjectMapper;
import hotechcourse.chat.controller.chat.ChatCreateController;
import hotechcourse.chat.service.chat.ChatServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@WebMvcTest(ChatCreateController.class)
class ChatCreateControllerTest {

    @MockBean
    ChatServiceImpl chatService;

    @Autowired
    MockMvc mockMvc;

    ArrayList<Long> users = new ArrayList<>();

    @BeforeEach
    void setup() {
        users = new ArrayList<>();
        users.add(1L);
        users.add(2L);
    }

    @Test
    void createChat() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();

        ChatCreateController.Request request = new ChatCreateController.Request(users);

        given(chatService.createChat(anyList())).willReturn(1L);

        mockMvc.perform(post("/api/v1/chat")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)));
    }
}