package com.example.message.Repository;

import com.example.message.Model.Message;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepository {

    private final List<Message> messages = new ArrayList<>();

    public MessageRepository() {
        messages.add(new Message(1, "Velkommen til 1. semester"));
        messages.add(new Message(2, "Velkommen til 2. semester"));
        messages.add(new Message(3, "Velkommen til 3. semester"));
    }

    public List<Message> getAllMessage() {
        return messages;
    }

    public Message findMessageById(int id) {
        for (Message message : messages) {
            if (message.getId() == id) {
                return message;
            }
        }
        return null;
    }
}
