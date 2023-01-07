package com.samettoprak.WhatsAppwithRestAPI.Service;

import com.samettoprak.WhatsAppwithRestAPI.Entity.Contact;
import com.samettoprak.WhatsAppwithRestAPI.Entity.Message;
import com.samettoprak.WhatsAppwithRestAPI.Entity.Response;

import java.util.List;

public interface IContactService {
    Response<List<Contact>> getContacts();
    Response<List<Contact>> getUserContacts(String userId);
    Response<Contact> getContact(String contactId);
    Response<Contact> createContact(Contact contact);
    Response<Boolean> deleteContact(String contactId);
    Response<Contact> addMessageToContact(String contactId,Message message);
    Response<Boolean> deleteMessageFromContact(String contactId, String messageId);
    //updateye ihtiyaç yok ?

}
