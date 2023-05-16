package com.example.repository.attach;

import com.example.entity.attach.AttachEntity;
import org.springframework.data.repository.CrudRepository;

public interface AttachRepository extends CrudRepository<AttachEntity, String> {

    AttachEntity getById(String id);
}
