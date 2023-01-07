package com.samettoprak.WhatsAppwithRestAPI.Service;

import com.samettoprak.WhatsAppwithRestAPI.DAO.ChannelRepository;
import com.samettoprak.WhatsAppwithRestAPI.DAO.MessageRepository;
import com.samettoprak.WhatsAppwithRestAPI.Entity.Channel;
import com.samettoprak.WhatsAppwithRestAPI.Entity.Message;
import com.samettoprak.WhatsAppwithRestAPI.Entity.Response;
import com.samettoprak.WhatsAppwithRestAPI.Entity.User;
import org.springframework.stereotype.Service;

import java.lang.reflect.Executable;
import java.util.List;

@Service
public class ChannelService implements IChannelService {
    ChannelRepository channelRepository;
    MessageRepository messageRepository;

    public ChannelService(ChannelRepository channelRepository, MessageRepository messageRepository) {
        this.channelRepository = channelRepository;
        this.messageRepository = messageRepository;
    }


    @Override
    public Response<Channel> createChannel(Channel channel) {
        try {
            return Response.Succsess(channelRepository.save(channel));
        } catch (Exception ex) {
            return Response.Fail(ex.getMessage());
        }
    }

    @Override
    public Response<Channel> getChannel(String channelId) {
        try {
            var result = channelRepository.findById(channelId).orElse(null);
            if (result != null) {
                return Response.Succsess(result);
            } else return Response.Fail("Channel Not Found.");
        } catch (Exception ex) {
            return Response.Fail(ex.getMessage());
        }
    }

    @Override
    public Response<List<Channel>> getAllChannels() {
        try {
            var result = channelRepository.findAll();
            return Response.Succsess(result);
        } catch (Exception ex) {
            return Response.Fail(ex.getMessage());
        }
    }

    @Override
    public Response<Channel> updateChannel(Channel channel) {
        try {
            var oldChannel = channelRepository.findById(channel.getId()).orElse(null);
            if (oldChannel != null) {
                var result = channelRepository.save(oldChannel);
                return Response.Succsess(result);
            } else return Response.Fail("Channel Not Found.");
        } catch (Exception ex) {
            return Response.Fail(ex.getMessage());
        }
    }

    @Override
    public Response<Boolean> deleteChannel(String channelId) {
        try {
            var result = channelRepository.findById(channelId).orElse(null);
            if (result != null) {
                channelRepository.delete(result);
                return Response.Succsess(true);
            } else return Response.Fail("Channel Not Found.");
        } catch (Exception ex) {
            return Response.Fail(ex.getMessage());
        }
    }

    @Override
    public Response<Channel> addMessageToChannel(String channelId, Message message) {
        try {
            var channel = channelRepository.findById(channelId).orElse(null);
            if (channel != null) {
                var messageList = channel.getMessages();
                messageList.add(message);
                channel.setMessages(messageList);
                channelRepository.save(channel);
                return Response.Succsess(channel);
            } else return Response.Fail("Channel Not Found.");
        } catch (Exception ex) {
            return Response.Fail(ex.getMessage());
        }

    }

    @Override
    public Response<Boolean> deleteMessageFromChannel(String channelId, String messageId) {
        try {
            var result = channelRepository.findById(channelId).orElse(null);
            if (result != null) {
                var list = result.getMessages();
                if (list != null) {
                    for (var message : list) {
                        if (message.getId().equals(messageId)) {
                            message.setContent("Message Deleted");
                        }
                    }
                    result.setMessages(list);
                    return Response.Succsess(true);
                } else return Response.Fail("Message Not Found");
            } else return Response.Fail("Channel Not Found.");
        } catch (Exception ex) {
            return Response.Fail(ex.getMessage());
        }
    }

    @Override
    public Response<Channel> addUserToChannel(String channelId, User user) {
        try {
            var result = channelRepository.findById(channelId).orElse(null);
            if (result != null) {
                var list = result.getUsers();
                list.add(user);
                result.setUsers(list);
                return Response.Succsess(channelRepository.save(result));
            } else return Response.Fail("Channel Not Found.");
        } catch (Exception ex) {
            return Response.Fail(ex.getMessage());
        }
    }

    @Override
    public Response<Channel> removeUserFromChannel(String channelId, String userId) {
        try {
            var result = channelRepository.findById(channelId).orElse(null);
            if (result != null) {
                var list = result.getUsers();
                if (list != null) {
                    for (var user : list) {
                        if (user.getId().equals(userId)) {
                            list.remove(user);
                        }
                    }
                    result.setUsers(list);
                    return Response.Succsess(channelRepository.save(result));
                }
                else return Response.Fail("No User Found in Channel");

            }
            else return Response.Fail("Channel Not Found.");
        } catch (Exception ex) {
            return Response.Fail(ex.getMessage());
        }
    }
}
