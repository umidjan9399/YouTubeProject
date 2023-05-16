package com.example.controller;

import com.example.dto.JwtDto;
import com.example.dto.auth.AuthDto;
import com.example.dto.auth.AuthResponseDto;
import com.example.dto.auth.RegistrationDto;
import com.example.dto.auth.RegistrationResponseDto;
import com.example.dto.profile.ProfileDto;
import com.example.enums.ProfileRole;
import com.example.service.AuthService;
import com.example.service.ProfileService;
import com.example.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/profile")
public class ProfileController {
    /*0. Auth
	1. Registration (with email verification)
	  id,name,surname,email,main_photo (url)
	2. Authorization

1. Profile (USER role)
	1. Change password
	2. Update Email (with email verification)
	3. Update Profile Detail(name,surname)
	4. Update Profile Attach (main_photo) (delete old attach)
	5. Get Profile Detail (id,name,surname,email,main_photo((url)))
    6. Create Profile (ADMIN)
        (id,name,surname,email,Role(ADMIN,MODERATOR))*/
    @Autowired
    private ProfileService profileService;

    @PostMapping({"/adm", "/adm/create"})
    public ResponseEntity<Integer> create(@RequestBody ProfileDto dto) {
        return ResponseEntity.ok(profileService.create(dto));
    }

    @GetMapping("/list-paging/get-detail")
    public ResponseEntity<Page<ProfileDto>> getProfileDetail(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "3") int size,
            @RequestHeader("Authorization") String authorization) {
        JwtDto jwtDTO = JwtUtil.getJwtDTO(authorization, ProfileRole.ADMIN);
        return ResponseEntity.ok(profileService.getProfileDetail(page, size));
    }

    @PutMapping("/{id}/change/password")
    public ResponseEntity<ProfileDto> changePassword(@PathVariable("id") Integer id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        System.out.println(currentPrincipalName);
        return ResponseEntity.ok(profileService.changePassword(id));
    }

    @PutMapping("/update-email")
    public ResponseEntity<Boolean> updateEmail(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(profileService.updateEmail(id));
    }

    @PutMapping("/updateAdmin-attach/{id}")
    public ResponseEntity<Boolean> updateAttach(@PathVariable ("id") Integer id,
                                               @RequestBody ProfileDto profileDto,
                                               @RequestHeader("Authorization") String authorization) {
        JwtDto jwtDTO = JwtUtil.getJwtDTO(authorization, ProfileRole.ADMIN);
        return ResponseEntity.ok(profileService.updateAttach(id, profileDto));
    }

    @PutMapping("/update-detail/{id}")
    public ResponseEntity<Boolean> updateDetail(@PathVariable ("id") Integer id,
                                          @RequestBody ProfileDto profileDto) {
        return ResponseEntity.ok(profileService.updateDetail(id, profileDto));
    }

}
