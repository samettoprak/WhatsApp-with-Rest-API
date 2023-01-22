package com.samettoprak.WhatsAppwithRestAPI.REST;

import com.samettoprak.WhatsAppwithRestAPI.Entity.Channel;
import com.samettoprak.WhatsAppwithRestAPI.Entity.Message;
import com.samettoprak.WhatsAppwithRestAPI.Entity.Response;
import com.samettoprak.WhatsAppwithRestAPI.Entity.User;
import com.samettoprak.WhatsAppwithRestAPI.Service.ChannelService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/* var response =
        if(response.getIsSuccess())
            return ResponseEntity.ok(response);
        else return ResponseEntity.badRequest().body(response);*/

@RestController
@RequestMapping("/api/Channels")
public class ChannelRestController {
    private final ChannelService channelService;

    public ChannelRestController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @PostMapping("/CreateChannel")
    public ResponseEntity<Response<Channel>> createChannel(@RequestBody Channel channel) {
        var response = channelService.createChannel(channel);
        if (response.getIsSuccess())
            return ResponseEntity.ok(response);
        else return ResponseEntity.badRequest().body(response);
    }

    @GetMapping("/{channelId}")
    public ResponseEntity<Response<Channel>> getChannel(String channelId) {
        var response = channelService.getChannel(channelId);
        if (response.getIsSuccess())
            return ResponseEntity.ok(response);
        else return ResponseEntity.badRequest().body(response);
    }

    @GetMapping("/")
    public ResponseEntity<Response<List<Channel>>> getAllChannels() {
        var response = channelService.getAllChannels();
        if (response.getIsSuccess())
            return ResponseEntity.ok(response);
        else return ResponseEntity.badRequest().body(response);
    }

    @PutMapping("/UpdateChannel")
    public ResponseEntity<Response<Channel>> updateChannel(@RequestBody Channel channel) {
        var response = channelService.updateChannel(channel);
        if (response.getIsSuccess())
            return ResponseEntity.ok(response);
        else return ResponseEntity.badRequest().body(response);
    }

    @DeleteMapping("/DeleteChannel/{channelId}")
    public ResponseEntity<Response<Boolean>> deleteChannel(@PathVariable String channelId) {
        var response = channelService.deleteChannel(channelId);
        if (response.getIsSuccess())
            return ResponseEntity.ok(response);
        else return ResponseEntity.badRequest().body(response);
    }

    @PostMapping("/AddMessageToChannel/{channelId}")
    public ResponseEntity<Response<Channel>> addMessageToChannel(@PathVariable String channelId, @RequestBody Message message) {
        var response = channelService.addMessageToChannel(channelId, message);
        if (response.getIsSuccess())
            return ResponseEntity.ok(response);
        else return ResponseEntity.badRequest().body(response);
    }

    @DeleteMapping("/DeleteMessage/{messageId}/FromChannel/{channelId}")
    public Response<Boolean> deleteMessageFromChannel(@PathVariable String channelId, @PathVariable String messageId) {
        return channelService.deleteMessageFromChannel(channelId, messageId);
    }

    @PostMapping("/AddUser/{userId}/Channel/{channelId}")
    public ResponseEntity<Response<Channel>> addUserToChannel(@PathVariable String channelId, @PathVariable String userId) {
        var response = channelService.addUserToChannel(channelId, userId);
        if (response.getIsSuccess())
            return ResponseEntity.ok(response);
        else return ResponseEntity.badRequest().body(response);
    }
    @DeleteMapping("/RemoveUser/{userId}/FromChannel{channelId}")
    public ResponseEntity<Response<Channel>> removeUserFromChannel(@PathVariable String channelId,@PathVariable String userId) {
        var response = channelService.removeUserFromChannel(channelId,userId);
        if(response.getIsSuccess())
            return ResponseEntity.ok(response);
        else return ResponseEntity.badRequest().body(response);
    }
}
