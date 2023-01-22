package com.samettoprak.WhatsAppwithRestAPI.Entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class Channel {
    @Id
    String id;
    @NotNull @Min(2) @Max(20)
    String channelName;
    LocalDateTime creationTime;
    List<User> channelAdmin;
    List<User> users;
    List<Message> messages;
}
