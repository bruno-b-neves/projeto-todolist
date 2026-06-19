package br.com.brunoneves.todolist.Task;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepository extends JpaRepository<TaskModel, UUID> {
    TaskModel findByTitle(String title);
    TaskModel findByTitleAndCompleted(String title, boolean completed);
}
