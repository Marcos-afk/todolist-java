package br.com.marcosmelo.todolistjava.tasks.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcosmelo.todolistjava.tasks.models.TaskModel;
import br.com.marcosmelo.todolistjava.tasks.repositories.ITasksRepository;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/tasks")
public class TaskController {

  @Autowired
  private ITasksRepository tasksRepository;

  @PostMapping("/")
  public ResponseEntity<String> createTask(@RequestBody TaskModel taskModel, HttpServletRequest request) {

    var user_id = request.getAttribute("user_id");

    taskModel.setUserId((UUID) user_id);

    var currentDate = LocalDateTime.now();
    if (currentDate.isAfter(taskModel.getStart_at()) || currentDate.isAfter(taskModel.getEnd_at())) {
      return ResponseEntity.badRequest().body("Data de inicio/Data de término deve ser maior que a data atual");
    }

    if (taskModel.getStart_at().isAfter(taskModel.getEnd_at())) {
      return ResponseEntity.badRequest().body("Data de inicio deve ser maior que a data de término");
    }

    this.tasksRepository.save(taskModel);

    return ResponseEntity.ok().build();
  }

  @GetMapping("/")
  public List<TaskModel> listTasks(HttpServletRequest request) {
    var user_id = request.getAttribute("user_id");
    var tasks = this.tasksRepository.findByUserId((UUID) user_id);
    return tasks;
  }

}
