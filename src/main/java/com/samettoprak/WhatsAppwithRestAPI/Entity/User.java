package com.samettoprak.WhatsAppwithRestAPI.Entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@AllArgsConstructor
public class User {
    @Id
    String id;
    @NotNull @Min(2) @Max(20)
    String userName;
    @NotNull @Min(2) @Max(20)
    String surName;
    String phoneNumber;
    @Email String email;
    List<Channel> channels;
    List<Message> messages;

}
