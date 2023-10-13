package br.com.marcosmelo.todolistjava.tasks.models;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity(name = "tb_tasks")
public class TaskModel {

  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

  @NotBlank(message = "A descrição é obrigatória")
  private String description;

  @NotBlank(message = "O título é obrigatório")
  @Size(max = 50, message = "O título deve ter no máximo 50 caracteres")
  private String title;

  private LocalDateTime start_at;

  private LocalDateTime end_at;

  @NotBlank(message = "A prioridade é obrigatória")
  private String priority;

  @CreationTimestamp
  private LocalDateTime created_at;

  private UUID userId;
}
