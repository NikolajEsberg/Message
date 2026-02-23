package com.example.message.Service;

import com.example.message.Model.Message;
import com.example.message.Repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public List<Message> getMessages() {
        return repository.getAllMessage();
    }

    public Message findMessageById(int id, String caps) {
        Message message = repository.findMessageById(id);

        if (message == null) {
            return null;
        }

        if (caps != null && caps.equalsIgnoreCase("yes")) {
            return new Message(
                    message.getId(),
                    message.getContent().toUpperCase()
            );
        }

        return message;
    }
}
 