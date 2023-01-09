package com.samettoprak.WhatsAppwithRestAPI.ServiceInterfaces;

import com.samettoprak.WhatsAppwithRestAPI.Entity.Response;
import com.samettoprak.WhatsAppwithRestAPI.Entity.User;

import java.util.List;

public interface IUserService {
    Response<List<User>> getUsers();
    Response<User> getUser(String userId);
    Response<User> createUser(User user);
    Response<Boolean> deleteUser(String userId);
    Response<User> updateUser(User user);
    //bunu direkt save diyerek update edip edemediğini kontrol et.
    Response<User> addChannelToUser(String userId,String channelId);
    Response<Boolean> deleteChannelFromUser(String userId,String channelId);

    Response<User> addContactToUser(String contactId,String userId);
    //bunu 2 kişi için aynı anda yapmak lazım.alttakini de
    Response<Boolean> deleteContactFromUser(String contactId,String userId);






}

