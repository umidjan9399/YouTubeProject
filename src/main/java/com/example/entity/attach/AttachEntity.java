package com.example.entity.attach;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "attach")
public class AttachEntity {
    @Id
    private String id;
    @Column(name = "original_name")
    private String originalName;
    @Column
    private String path;
    @Column
    private Long size;
    @Column
    private String extension;
    @Column(name = "created_date")
    private LocalDateTime createdData;

    @Override
    public String toString() {
        return  "AttachEntity{" +
                "id='" + id + '\'' +
                ", originalName='" + originalName + '\'' +
                ", path='" + path + '\'' +
                ", size=" + size +
                ", extension='" + extension + '\'' +
                ", createdData=" + createdData +
                "}";
    }
}
