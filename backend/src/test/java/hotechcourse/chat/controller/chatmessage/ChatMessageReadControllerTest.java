package hotechcourse.chat.controller.chatmessage;

import hotechcourse.chat.dto.chatmessage.ChatMessageReadDto;
import hotechcourse.chat.service.chatMessage.ChatMessageServiceImpl;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.hamcrest.core.Is.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@WebMvcTest(ChatMessageReadController.class)
class ChatMessageReadControllerTest {

    @MockBean
    ChatMessageServiceImpl chatMessageService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void ReadChatMessage() throws Exception {

        given(chatMessageService.readChatMessage(anyLong())).willReturn(new ArrayList<ChatMessageReadDto>());

        mockMvc.perform(get("/api/v1/chatmessage")
                .param("chatid", "1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}