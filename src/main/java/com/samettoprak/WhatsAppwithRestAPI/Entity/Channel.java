package com.samettoprak.WhatsAppwithRestAPI.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@AllArgsConstructor
public class Channel {
    @Id
    String id;
    String channelName;
    User channelAdmin;
    List<User> users;
    List<Message> messages;
}
