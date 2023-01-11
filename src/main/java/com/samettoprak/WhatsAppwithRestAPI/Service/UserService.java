package com.samettoprak.WhatsAppwithRestAPI.Service;

import com.samettoprak.WhatsAppwithRestAPI.DAO.ChannelRepository;
import com.samettoprak.WhatsAppwithRestAPI.DAO.ContactRepository;
import com.samettoprak.WhatsAppwithRestAPI.DAO.UserRepository;
import com.samettoprak.WhatsAppwithRestAPI.Entity.Response;
import com.samettoprak.WhatsAppwithRestAPI.Entity.User;
import com.samettoprak.WhatsAppwithRestAPI.ServiceInterfaces.IUserService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class UserService implements IUserService {
    UserRepository userRepository;
    private final ChannelRepository channelRepository;
    private final ContactRepository contactRepository;

    public UserService(UserRepository userRepository,
                       ChannelRepository channelRepository,
                       ContactRepository contactRepository) {
        this.userRepository = userRepository;
        this.channelRepository = channelRepository;
        this.contactRepository = contactRepository;
    }

    @Override
    public Response<List<User>> getUsers() {
        try {
            return Response.Succsess(userRepository.findAll());
        }catch (Exception ex){
            return Response.Fail(ex.getMessage());
        }
    }

    @Override
    public Response<User> getUser(String userId) {
        try {
            var user = userRepository.findById(userId).orElse(null);
            if (user != null) {
                return Response.Succsess(user);
            }else return Response.Fail("User Not Found.");
        }catch (Exception ex){
            return Response.Fail(ex.getMessage());
        }
    }

    @Override
    public Response<User> createUser(User user) {
        try {
            return Response.Succsess(userRepository.save(user));
        }catch (Exception ex){
            return Response.Fail(ex.getMessage());
        }
    }

    @Override
    public Response<Boolean> deleteUser(String userId) {
        try {
            var user = userRepository.findById(userId).orElse(null);
            if (user != null) {
                userRepository.delete(user);
                return Response.Succsess(true);
            }else return Response.Fail("User Not Found.");

        }catch (Exception ex){
            return Response.Fail(ex.getMessage());
        }
    }

    @Override
    public Response<User> updateUser(User user) {
        try {
            var result = userRepository.findById(user.getId()).orElse(null);
            if (result != null) {
                return Response.Succsess(userRepository.save(user));
            }
            else return Response.Fail("User Not Found.");
        }catch (Exception ex){
            return Response.Fail(ex.getMessage());
        }
    }

    @Override
    public Response<User> addChannelToUser(String userId, String channelId) {
        try {
            var result = userRepository.findById(userId).orElse(null);
            if (result!=null){
                var list = result.getChannels();
                var channel = channelRepository.findById(channelId).orElse(null);
                if (channel != null) {
                    if (list!=null){
                        list.add(channel);
                        result.setChannels(list);
                        userRepository.save(result);
                    }
                    else //yeni liste oluştur falan filan
                }
            }
        }catch (Exception ex){
            return Response.Fail(ex.getMessage());
        }
    }

    @Override
    public Response<Boolean> deleteChannelFromUser(String userId, String channelId) {
        return null;
    }

    @Override
    public Response<User> addContactToUser(String contactId, String userId) {
        try {
            var result = userRepository.findById(userId).orElse(null);
            if (result != null) {
                var list = result.getContacts();
                list.add();
                //burası body olarak almalı contactı id olarak değil!
            }

        }catch (Exception ex){
            return Response.Fail(ex.getMessage());
        }
    }

    @Override
    public Response<Boolean> deleteContactFromUser(String contactId, String userId) {
        try {
            var result = userRepository.findById(userId).orElse(null);
            if (result!=null){
                var contacts = result.getContacts();
                if (contacts.contains(contactRepository.findById(contactId))) {
                    return Response.Succsess(true);
                }else return Response.Fail("Contact Not Found.");
            }else return Response.Fail("User Not Found.");

        }catch (Exception ex){
            return Response.Fail(ex.getMessage());
        }
    }
}
