package com.samettoprak.WhatsAppwithRestAPI.DAO;

import com.samettoprak.WhatsAppwithRestAPI.Entity.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<Contact,String> {
}
