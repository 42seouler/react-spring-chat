package hotechcourse.chat.controller.chat;

import hotechcourse.chat.dto.chat.ChatReadDto;
import hotechcourse.chat.service.chat.ChatServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@WebMvcTest(ChatReadController.class)
class ChatReadControllerTest {

    @MockBean
    ChatServiceImpl chatService;

    @Autowired
    MockMvc mockMvc;

    List<ChatReadDto> chatList = new ArrayList<>();

    @Test
    void ReadChat() throws Exception {

        given(chatService.readChat(any(Long.class))).willReturn(chatList);

        mockMvc.perform(get("/api/v1/chat")
                .param("id", "1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}