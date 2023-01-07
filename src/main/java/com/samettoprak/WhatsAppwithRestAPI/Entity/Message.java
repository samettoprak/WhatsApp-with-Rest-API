package com.samettoprak.WhatsAppwithRestAPI.Entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
    @NotNull @Min(2) @Max(20)
    String ownerName;
    @NotNull @Min(1) @Max(200)
    String content;
    LocalDateTime dateTime;
    //okundu bilgisi ?
}
