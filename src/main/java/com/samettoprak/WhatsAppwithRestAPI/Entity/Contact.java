package com.samettoprak.WhatsAppwithRestAPI.Entity;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@AllArgsConstructor
public class Contact {
    @Id
    String id;
    String contactId;
    String contactName;
    List<Message> messages;
    //datetime lazım mı ?
}
