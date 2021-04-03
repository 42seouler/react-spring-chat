package hotechcourse.chat.service.chatMessage;

import hotechcourse.chat.dto.chatmessage.ChatMessageCreateDto;
import hotechcourse.chat.entity.Chat;
import hotechcourse.chat.entity.ChatMessage;
import hotechcourse.chat.entity.User;
import hotechcourse.chat.repository.chatmessage.ChatMessageRepository;
import hotechcourse.chat.repository.chat.ChatRepository;
import hotechcourse.chat.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ChatMessageServiceImplTest {

    @Mock
    ChatRepository          chatRepository;

    @Mock
    UserRepository          userRepository;

    @Mock
    ChatMessageRepository   chatMessageRepository;

    @InjectMocks
    ChatMessageServiceImpl  chatMessageService;

    @Test
    void createChatMessage() {
       //given
        List<Long> participant = new ArrayList<>();
        participant.add(1L);
        participant.add(2L);
        User test_user = new User("Test User");
        Chat test_chat = new Chat("Test Chat", participant);
        ReflectionTestUtils.setField(test_user, "id", 3L);
        ReflectionTestUtils.setField(test_chat, "id", 1L);
        ChatMessageCreateDto dto = ChatMessageCreateDto.builder()
                .chatId(test_chat.getId())
                .authorId(test_user.getId())
                .content("TEST MESSAGE")
                .build();
        ChatMessage test_message = ChatMessage.builder()
                .author(test_user)
                .chat(test_chat)
                .content("TEST MESSAGE")
                .build();
        ReflectionTestUtils.setField(test_message, "id", 4L);
        given(userRepository.findById(anyLong())).willReturn(Optional.of(test_user));
        given(chatRepository.findById(anyLong())).willReturn(Optional.of(test_chat));
        given(chatMessageRepository.save(any(ChatMessage.class))).willReturn(test_message);
       //when
        Long chatMessageId = chatMessageService.createChatMessage(dto);
        //then
        assertThat(4L).isEqualTo(chatMessageId);
    }
}