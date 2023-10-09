package br.com.marcosmelo.todolistjava.users.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcosmelo.todolistjava.users.models.UserModel;

@RestController
@RequestMapping("/users")
public class UserController {

  @PostMapping("/")
  public void createUser(@RequestBody UserModel userModel) {
    System.out.println("NOME: " + userModel.getName());
    System.out.println("SENHA: " + userModel.getPassword());
    System.out.println("USERNAME: " + userModel.getUsername());
  }
}
