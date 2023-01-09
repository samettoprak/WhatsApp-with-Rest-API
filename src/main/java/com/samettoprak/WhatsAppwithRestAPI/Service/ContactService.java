package com.samettoprak.WhatsAppwithRestAPI.Service;

import com.samettoprak.WhatsAppwithRestAPI.DAO.ContactRepository;
import com.samettoprak.WhatsAppwithRestAPI.DAO.MessageRepository;
import com.samettoprak.WhatsAppwithRestAPI.DAO.UserRepository;
import com.samettoprak.WhatsAppwithRestAPI.Entity.Contact;
import com.samettoprak.WhatsAppwithRestAPI.Entity.Message;
import com.samettoprak.WhatsAppwithRestAPI.Entity.Response;
import com.samettoprak.WhatsAppwithRestAPI.ServiceInterfaces.IContactService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContactService implements IContactService {
    ContactRepository contactRepository;
    UserRepository userRepository;
    MessageRepository messageRepository;

    public ContactService(ContactRepository contactRepository, UserRepository userRepository, MessageRepository messageRepository) {
        this.contactRepository = contactRepository;
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }


    @Override
    public Response<List<Contact>> getContacts() {
        try {
            return Response.Succsess(contactRepository.findAll());
        } catch (Exception ex) {
            return Response.Fail(ex.getMessage());
        }
    }

    @Override
    public Response<List<Contact>> getUserContacts(String userId) {
        try {
            var user = userRepository.findById(userId).orElse(null);
            if (user != null) {
                var list = user.getContacts();
                return Response.Succsess(list);
            }
            else return Response.Fail("User Not Found.");
        } catch (Exception ex) {
            return Response.Fail(ex.getMessage());
        }
    }

    @Override
    public Response<Contact> getContact(String contactId) {
        try {
            var contact =contactRepository.findById(contactId).orElse(null);
            if (contact != null) {
                return Response.Succsess(contact);
            }
            else return Response.Fail("User Not Found.");
        } catch (Exception ex) {
            return Response.Fail(ex.getMessage());
        }
    }

    @Override
    public Response<Contact> createContact(Contact contact) {
        try {
            return Response.Succsess(contactRepository.save(contact));
        } catch (Exception ex) {
            return Response.Fail(ex.getMessage());
        }
    }

    @Override
    public Response<Boolean> deleteContact(String contactId) {
        try {
            var result = contactRepository.findById(contactId).orElse(null);
            if (result != null){
                contactRepository.deleteById(contactId);
                return Response.Succsess(true);
            }else return Response.Fail("Contact Not Found.");
        } catch (Exception ex) {
            return Response.Fail(ex.getMessage());
        }
    }

    @Override
    public Response<Contact> addMessageToContact(String contactId, Message message) {
        try {
            var result = contactRepository.findById(contactId).orElse(null);
            if (result!=null){
                var list = result.getMessages();
                list.add(message);
                result.setMessages(list);
                return Response.Succsess(contactRepository.save(result));
            }else return Response.Fail("Contact Not Found.");
        } catch (Exception ex) {
            return Response.Fail(ex.getMessage());
        }
    }

    @Override
    public Response<Boolean> deleteMessageFromContact(String contactId, String messageId) {
        try {
            var result = contactRepository.findById(contactId).orElse(null);
            if (result != null) {
                result.getMessages().removeIf(x->x.getId().equals(messageId));
                contactRepository.save(result);
                return Response.Succsess(true);
            }
            else return Response.Fail("Contact Not Found");
        } catch (Exception ex) {
            return Response.Fail(ex.getMessage());
        }
    }
}
