package com.example.taskManager.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "tasks")
public class TaskModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(length = 65)
    private String title;

    @Column(length = 16384)
    private String description;

    private String priority;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
