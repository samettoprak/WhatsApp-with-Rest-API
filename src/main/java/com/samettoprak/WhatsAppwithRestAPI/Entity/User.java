package com.samettoprak.WhatsAppwithRestAPI.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@AllArgsConstructor
public class User {
    @Id
    String id;
    String userName;
    String surName;
    String phoneNumber;
    List<Channel> channels;
    List<Message> messages;

}
