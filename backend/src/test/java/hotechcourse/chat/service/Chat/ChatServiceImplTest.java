package hotechcourse.chat.service.chat;

import hotechcourse.chat.dto.chat.ChatReadDto;
import hotechcourse.chat.entity.Chat;
import hotechcourse.chat.entity.User;
import hotechcourse.chat.repository.ChatRepository;
import hotechcourse.chat.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class ChatServiceImplTest {

    @Mock
    UserRepository userRepository;

    @Mock
    ChatRepository chatRepository;

    @InjectMocks
    ChatServiceImpl chatService;

    @Test
    void createChat() {
        //given
        ArrayList<Long> userList = new ArrayList<>();
        userList.add(1L);
        userList.add(2L);
        Chat chat = Chat.builder().name("test").participant(userList).build();
        ReflectionTestUtils.setField(chat, "id", 10L);
        given(userRepository.findById(any(Long.class))).willReturn(Optional.of(User.builder().build()));
        given(chatRepository.save(any(Chat.class))).willReturn(chat);
        //when
        Long chatId = chatService.createChat(userList);
        //then
        assertThat(10L).isEqualTo(chatId);
    }

    @Test
    void readChat() {
        //given
        ArrayList<Long> userList = new ArrayList<>();
        userList.add(1L);
        userList.add(2L);
        Chat chat = Chat.builder().name("test").participant(userList).build();
        ReflectionTestUtils.setField(chat, "id", 10L);
        List<Chat> chats = new ArrayList<>();
        chats.add(chat);
        given(chatRepository.findChatList(any(String.class))).willReturn(chats);
        //when
        List<ChatReadDto> chatReadDtos = chatService.readChat(1L);
        //then
        assertThat(10L).isEqualTo(chatReadDtos.get(0).getId());
    }
}