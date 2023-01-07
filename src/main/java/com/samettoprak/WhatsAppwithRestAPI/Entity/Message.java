package com.samettoprak.WhatsAppwithRestAPI.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor

public class Message {
    @Id
    String id;
    String ownerId;
    String ownerName;
    String content;
    LocalDateTime dateTime;

}
