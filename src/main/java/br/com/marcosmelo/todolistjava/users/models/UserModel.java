
package br.com.marcosmelo.todolistjava.users.models;

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
@Entity(name = "tb_users")
public class UserModel {

  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

  @NotBlank(message = "O nome é obrigatório")
  private String name;

  @NotBlank(message = "A senha é obrigatória")
  @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
  private String password;

  @NotBlank(message = "O username é obrigatório")
  private String username;

  @CreationTimestamp
  private LocalDateTime created_at;

}