package com.samettoprak.WhatsAppwithRestAPI.Service;

import com.samettoprak.WhatsAppwithRestAPI.Entity.Message;
import com.samettoprak.WhatsAppwithRestAPI.Entity.Response;

import java.util.List;

public interface IMessageService {
    Response<Message> getMessage(String messageId);
    Response<List<Message>> getMessagesFromChannel(String channelId);
}
