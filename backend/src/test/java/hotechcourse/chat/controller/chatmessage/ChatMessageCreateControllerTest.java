package hotechcourse.chat.controller.chatmessage;

import com.fasterxml.jackson.databind.ObjectMapper;
import hotechcourse.chat.service.chatMessage.ChatMessageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@WebMvcTest(ChatMessageCreateController.class)
class ChatMessageCreateControllerTest {

    @MockBean
    ChatMessageServiceImpl chatMessageService;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {

    }

    @Test
    void createChatMessage() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();

        given(chatMessageService.createChatMessage()).willReturn(1L);

        mockMvc.perform(post("/api/v1/chatmessage")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}