package hotechcourse.chat.converter;

import hotechcourse.chat.entity.User;
import javax.persistence.Converter;

@Converter
public class ChatListConverter extends BaseListConverter<User> {
}
