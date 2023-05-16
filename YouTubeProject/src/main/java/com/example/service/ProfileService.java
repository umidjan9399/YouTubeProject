package com.example.service;

import com.example.dto.profile.ProfileDto;
import com.example.entity.ProfileEntity;
import com.example.enums.GeneralStatus;
import com.example.exps.ItemNotFoundException;
import com.example.repository.ProfileRepository;
import com.example.util.MD5Util;
import com.example.util.SpringSecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public Integer create(ProfileDto dto) {
        ProfileEntity entity = new ProfileEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setEmail(dto.getEmail());
        entity.setRole(dto.getRole());
        entity.setPassword(MD5Util.getMd5Hash(dto.getPassword())); // MD5 ?
        entity.setCreatedDate(LocalDateTime.now());
        entity.setVisible(true);
        entity.setPrtId(SpringSecurityUtil.getProfileId());
        entity.setStatus(GeneralStatus.ACTIVE);
        profileRepository.save(entity); // save profile

        dto.setPassword(null);
        dto.setId(entity.getId());
        return entity.getId();
    }
    public Page<ProfileDto> getProfileDetail(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable paging = PageRequest.of(page - 1, size, sort);
        Page<ProfileEntity> pageObj = profileRepository.findAll(paging);

        Long totalCount = pageObj.getTotalElements();

        List<ProfileEntity> entityList = pageObj.getContent();
        List<ProfileDto> dtoList = new LinkedList<>();
        if (pageObj != null) {
            for (ProfileEntity entity : entityList) {
                ProfileDto dto = new ProfileDto();
                dto.setId(entity.getId());
                dto.setName(entity.getName());
                dto.setSurname(entity.getSurname());
                dto.setPhoto(entity.getPhoto());
                dto.setEmail(entity.getEmail());
                dto.setPhoto(entity.getPhoto());
                dtoList.add(dto);
            }
            Page<ProfileDto> response = new PageImpl<ProfileDto>(dtoList, paging, totalCount);
            return response;
        }
        throw new ItemNotFoundException("List id empty");
    }
    public ProfileDto changePassword(Integer id) {
        ProfileEntity entity = get(id);
        if (entity == null) {
            throw new ItemNotFoundException("Such id not" + id);
        }
        ProfileDto dto = new ProfileDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setPhoto(entity.getPhoto());
        dto.setEmail(entity.getEmail());
        dto.setRole(entity.getRole());

        return dto;
    }
    public ProfileEntity get(Integer id) {
        Optional<ProfileEntity> optional = profileRepository.findById(id);
        if (optional.isEmpty()) {
            throw new ItemNotFoundException("Profile not found: " + id);
        }
        return optional.get();
    }
    private List<ProfileDto> toDto(List<ProfileEntity> list) {
        List<ProfileDto> dtoList = new LinkedList<>();
        for (ProfileEntity entity : list) {
            ProfileDto dto = new ProfileDto();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setSurname(entity.getSurname());
            dto.setPhoto(entity.getPhoto());
            dto.setEmail(entity.getEmail());
            dto.setRole(entity.getRole());

            dtoList.add(dto);
        }
        return dtoList;
    }
    public Boolean updateEmail(Integer id) {
        ProfileEntity entity = get(id);
        if (entity == null) {
            throw new ItemNotFoundException("Profile not found.");
        }
        entity.setVisible(false);
        entity.setPrtId(SpringSecurityUtil.getProfileId());
        profileRepository.save(entity);
        return true;
    }
    /*public Boolean updateAttach(Integer id, AttachDto attachDto) {
        ProfileEntity entity = get(id);
        if (entity == null) {
            throw new ItemNotFoundException("Profile not found");
        }
        entity.setName(profileDto.getName());
        entity.setSurname(profileDto.getSurname());
        entity.setPhoto(profileDto.getPhoto());
        entity.setPassword(profileDto.getPassword());
        entity.setEmail(profileDto.getEmail());
        entity.setRole(profileDto.getRole());
        entity.setStatus(profileDto.getStatus());

        profileRepository.save(entity);
        return true;
    }*/
    public Boolean updateDetail(Integer id, ProfileDto profileDto) {
        ProfileEntity entity = get(id);
        if (entity == null) {
            throw new ItemNotFoundException("Profile not found");
        }

        if (Optional.ofNullable(profileDto.getName()).isPresent()){
            entity.setName(profileDto.getName());
        }

        entity.setSurname(profileDto.getSurname());

        profileRepository.save(entity);
        return true;

    }
}
