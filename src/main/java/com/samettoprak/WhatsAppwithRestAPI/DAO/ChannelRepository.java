package com.samettoprak.WhatsAppwithRestAPI.DAO;

import com.samettoprak.WhatsAppwithRestAPI.Entity.Channel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChannelRepository extends MongoRepository<Channel,String> {

}
