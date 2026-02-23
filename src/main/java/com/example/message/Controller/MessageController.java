package com.example.message.Controller;

import com.example.message.Model.Message;
import com.example.message.Service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("message")
public class MessageController {

    private final MessageService service;

    public MessageController(MessageService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Message>> getMessages() {
        return new ResponseEntity<>(service.getMessages(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Message> getMessageById(
            @PathVariable int id,
            @RequestParam(required = false) String caps) {

        Message message = service.findMessageById(id, caps);

        if (message == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
