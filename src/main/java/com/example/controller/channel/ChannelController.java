package com.example.controller.channel;

import com.example.dto.channel.ChannelDTO;
import com.example.service.chanel.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/channel")
public class ChannelController {
    @Autowired
    private ChannelService channelService;
    @PostMapping("/public/create")
    public ResponseEntity<ChannelDTO> create(@RequestBody ChannelDTO dto) {
        return ResponseEntity.ok(channelService.createChannel(dto));
    }

    @PutMapping("/public/update-channel")
    public ResponseEntity<Boolean> update(@RequestBody ChannelDTO dto){
        return ResponseEntity.ok(channelService.update_profile(dto));
    }

    @PutMapping("/public/update-photo")
    public ResponseEntity<Boolean> update_photo(@RequestBody ChannelDTO dto){
        return ResponseEntity.ok(channelService.update_photo(dto));
    }

    @PutMapping("/public/update-banner")
    public ResponseEntity<Boolean> update_banner(@RequestBody ChannelDTO dto){
        return ResponseEntity.ok(channelService.update_banner(dto));
    }

    @GetMapping("/public/get-by-channel-id/{id}")
    public ResponseEntity<ChannelDTO> getByChannelId(@PathVariable String id) {
        return ResponseEntity.ok(channelService.getByChannelId(id));
    }

    @PutMapping("/public/update-status")
    public ResponseEntity<Boolean> update_status(@RequestBody ChannelDTO dto){
        return ResponseEntity.ok(channelService.update_status(dto));
    }
}
