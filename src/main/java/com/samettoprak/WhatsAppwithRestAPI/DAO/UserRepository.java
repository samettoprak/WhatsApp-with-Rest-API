package com.samettoprak.WhatsAppwithRestAPI.DAO;

import com.samettoprak.WhatsAppwithRestAPI.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
