package com.samettoprak.WhatsAppwithRestAPI.DAO;

import com.samettoprak.WhatsAppwithRestAPI.Entity.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message,String> {
}
