package com.example.controller;

import com.example.dto.playlist.PlaylistDTO;
import com.example.service.PlaylistService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/create")
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;

    @PostMapping("/user/create")
    public ResponseEntity<Integer> create(@RequestBody @Valid PlaylistDTO dto) {
        return ResponseEntity.ok(playlistService.create(dto));
    }
    @PutMapping("/user/update/{id}")
    public ResponseEntity<Boolean> update(@Valid @PathVariable("id") Integer id,
                                          @RequestBody PlaylistDTO dto) {
        return ResponseEntity.ok(playlistService.update(id, dto));
    }
}
