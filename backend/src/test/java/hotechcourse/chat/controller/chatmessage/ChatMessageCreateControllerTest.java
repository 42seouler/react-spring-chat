package hotechcourse.chat.controller.chatmessage;

import com.fasterxml.jackson.databind.ObjectMapper;
import hotechcourse.chat.dto.chatmessage.ChatMessageCreateDto;
import hotechcourse.chat.service.chatMessage.ChatMessageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.*;
import static org.mockito.ArgumentMatchers.any;
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

        ChatMessageCreateController.Request test_chat = ChatMessageCreateController.Request.builder()
                .chatId(5L)
                .authorId(1L)
                .content("TEST CHAT")
                .build();

        given(chatMessageService.createChatMessage(any(ChatMessageCreateDto.class))).willReturn(10L);

        mockMvc.perform(post("/api/v1/chatmessage")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(test_chat)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.chatMessageId", is(10)));
    }
}