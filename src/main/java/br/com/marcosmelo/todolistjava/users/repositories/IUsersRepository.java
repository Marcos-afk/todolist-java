package br.com.marcosmelo.todolistjava.users.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marcosmelo.todolistjava.users.models.UserModel;

public interface IUsersRepository extends JpaRepository<UserModel, UUID> {
  public UserModel findByUsername(String username);
}
