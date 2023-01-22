package com.samettoprak.WhatsAppwithRestAPI.REST;

import com.samettoprak.WhatsAppwithRestAPI.Entity.Contact;
import com.samettoprak.WhatsAppwithRestAPI.Entity.Response;
import com.samettoprak.WhatsAppwithRestAPI.Entity.User;
import com.samettoprak.WhatsAppwithRestAPI.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UserRestController {
    private final UserService userService;
    public UserRestController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/")
    public ResponseEntity<Response<List<User>>> getUsers() {
        var response = userService.getUsers();
        if(response.getIsSuccess())
            return ResponseEntity.ok(response);
        else return ResponseEntity.badRequest().body(response);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<Response<User>> getUser(@PathVariable String userId) {
        var response = userService.getUser(userId);
        if(response.getIsSuccess())
            return ResponseEntity.ok(response);
        else return ResponseEntity.badRequest().body(response);
    }
    @PostMapping("/CreateUser")
    public ResponseEntity<Response<User>> createUser(@RequestBody User user) {
        var response = userService.createUser(user);
        if(response.getIsSuccess())
            return ResponseEntity.ok(response);
        else return ResponseEntity.badRequest().body(response);
    }
    @DeleteMapping("/Delete/{userId}")
    public ResponseEntity<Response<Boolean>> deleteUser(@PathVariable String userId) {
        var response = userService.deleteUser(userId);
        if(response.getIsSuccess())
            return ResponseEntity.ok(response);
        else return ResponseEntity.badRequest().body(response);
    }
    @PutMapping("/UpdateUser")
    public ResponseEntity<Response<User>> updateUser(@RequestBody User user) {
        var response = userService.updateUser(user);
        if(response.getIsSuccess())
            return ResponseEntity.ok(response);
        else return ResponseEntity.badRequest().body(response);
    }
    @PostMapping("/AddChannel")
    public ResponseEntity<Response<User>> addChannelToUser(String userId, String channelId) {
        var response = userService.addChannelToUser(userId,channelId);
        if(response.getIsSuccess())
            return ResponseEntity.ok(response);
        else return ResponseEntity.badRequest().body(response);
    }

    public ResponseEntity<Response<Boolean>> deleteChannelFromUser(String userId, String channelId) {
        var response = userService.deleteChannelFromUser(userId,channelId);
        if(response.getIsSuccess())
            return ResponseEntity.ok(response);
        else return ResponseEntity.badRequest().body(response);
    }

    public ResponseEntity<Response<User>> addContactToUser(Contact contact, String userId) {
        var response = userService.addContactToUser(contact,userId);
        if(response.getIsSuccess())
            return ResponseEntity.ok(response);
        else return ResponseEntity.badRequest().body(response);
    }

    public ResponseEntity<Response<Boolean>> deleteContactFromUser(String contactId, String userId) {
        var response = userService.deleteContactFromUser(contactId,userId);
        if(response.getIsSuccess())
            return ResponseEntity.ok(response);
        else return ResponseEntity.badRequest().body(response);
    }
}
