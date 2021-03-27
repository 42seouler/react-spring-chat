package hotechcourse.chat.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import hotechcourse.chat.entity.User;
import hotechcourse.chat.service.Chat.ChatService;
import hotechcourse.chat.service.Chat.ChatServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@WebMvcTest(ChatController.class)
class ChatControllerTest {

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
    public void createChat() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();

        ChatController.CreateChatRequest createChatRequest = new ChatController.CreateChatRequest(users);

        given(chatService.createChat(anyList())).willReturn(1L);

        mockMvc.perform(post("/api/v1/chat")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createChatRequest)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)));
    }
}