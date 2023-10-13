package br.com.marcosmelo.todolistjava.tasks.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marcosmelo.todolistjava.tasks.models.TaskModel;

public interface ITasksRepository extends JpaRepository<TaskModel, UUID> {

}
