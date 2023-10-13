package br.com.marcosmelo.todolistjava.tasks.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marcosmelo.todolistjava.tasks.models.TaskModel;
import java.util.List;

public interface ITasksRepository extends JpaRepository<TaskModel, UUID> {
  public List<TaskModel> findByUserId(UUID userId);
}
