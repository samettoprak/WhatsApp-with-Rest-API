package com.samettoprak.WhatsAppwithRestAPI.ServiceInterfaces;

import com.samettoprak.WhatsAppwithRestAPI.Entity.Channel;
import com.samettoprak.WhatsAppwithRestAPI.Entity.Message;
import com.samettoprak.WhatsAppwithRestAPI.Entity.Response;
import com.samettoprak.WhatsAppwithRestAPI.Entity.User;

import java.util.List;

public interface IChannelService {
    Response<Channel> createChannel(Channel channel);
    Response<Channel> getChannel (String channelId);
    Response<List<Channel>> getAllChannels();
    Response<Channel> updateChannel(Channel channel);
    Response<Boolean> deleteChannel(String channelId);
    Response<Channel> addMessageToChannel(String channelId, Message message);
    Response<Boolean> deleteMessageFromChannel(String channelId,String messageId);
    Response<Channel> addUserToChannel(String channelId, User user);
    Response<Channel> removeUserFromChannel(String channelId,String userId);




}
