package br.com.marcosmelo.todolistjava.users.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.marcosmelo.todolistjava.users.models.UserModel;
import br.com.marcosmelo.todolistjava.users.repositories.IUsersRepository;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private IUsersRepository usersRepository;

  @PostMapping("/")
  public ResponseEntity<String> createUser(@RequestBody UserModel userModel) {
    var user = this.usersRepository.findByUsername(userModel.getUsername());

    if (user != null) {
      return ResponseEntity.badRequest().body("Username já está sendo usado na aplicação");
    }

    String passwordHashed = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());

    userModel.setPassword(passwordHashed);

    this.usersRepository.save(userModel);
    return ResponseEntity.ok().build();
  }
}
