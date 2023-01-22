package com.samettoprak.WhatsAppwithRestAPI.REST;

import com.samettoprak.WhatsAppwithRestAPI.Entity.Contact;
import com.samettoprak.WhatsAppwithRestAPI.Entity.Message;
import com.samettoprak.WhatsAppwithRestAPI.Entity.Response;
import com.samettoprak.WhatsAppwithRestAPI.Service.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*var response =
        if(response.getIsSuccess())
            return ResponseEntity.ok(response);
        else return ResponseEntity.badRequest().body(response);*/
@RestController
@RequestMapping("/api/Contacts")
public class ContactRestController {
    private final ContactService contactService;
    public ContactRestController(ContactService contactService ){
        this.contactService = contactService;
    }
    @GetMapping("/")
    public ResponseEntity<Response<List<Contact>>> getContacts() {
        var response = contactService.getContacts();
        if(response.getIsSuccess())
            return ResponseEntity.ok(response);
        else return ResponseEntity.badRequest().body(response);
    }
    @GetMapping("/User/{userId}")
    public ResponseEntity<Response<List<Contact>>> getUserContacts(@PathVariable String userId) {
        var response = contactService.getUserContacts(userId);
        if(response.getIsSuccess())
            return ResponseEntity.ok(response);
        else return ResponseEntity.badRequest().body(response);
    }
    @GetMapping("/Contact/{contactId}")
    public ResponseEntity<Response<Contact>> getContact(@PathVariable String contactId) {
        var response = contactService.getContact(contactId);
        if(response.getIsSuccess())
            return ResponseEntity.ok(response);
        else return ResponseEntity.badRequest().body(response);
    }
    @PostMapping("/CreateContact")
    public ResponseEntity<Response<Contact>> createContact(@RequestBody Contact contact) {
        var response = contactService.createContact(contact);
        if(response.getIsSuccess())
            return ResponseEntity.ok(response);
        else return ResponseEntity.badRequest().body(response);
    }
    @DeleteMapping("/DeleteContact/{contactId}")
    public ResponseEntity<Response<Boolean>> deleteContact(@PathVariable String contactId) {
        var response = contactService.deleteContact(contactId);
        if(response.getIsSuccess())
            return ResponseEntity.ok(response);
        else return ResponseEntity.badRequest().body(response);
    }
    @PostMapping("/AddMessage/ToContact/{contactId}")
    public ResponseEntity<Response<Contact>> addMessageToContact(@PathVariable String contactId, @RequestBody Message message) {
        var response = contactService.addMessageToContact(contactId,message);
        if(response.getIsSuccess())
            return ResponseEntity.ok(response);
        else return ResponseEntity.badRequest().body(response);
    }
    @DeleteMapping("/DeleteMessage/{messageId}/FromContact/{contactId}")
    public ResponseEntity<Response<Boolean>> deleteMessageFromContact(String contactId, String messageId) {
        var response = contactService.deleteMessageFromContact(contactId,messageId);
        if(response.getIsSuccess())
            return ResponseEntity.ok(response);
        else return ResponseEntity.badRequest().body(response);
    }
}
