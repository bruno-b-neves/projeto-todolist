package br.com.brunoneves.todolist.Task;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepository extends JpaRepository<TaskModel, UUID> {
    TaskModel findByTitle(String title);

    // Busca todas as tarefas filtrando pelo ID do usuário logado
    List<TaskModel> findByUserId(UUID userId);

    // Busca uma tarefa específica filtrando pelo título, status de conclusão e ID do usuário logado
    TaskModel findByTitleAndCompletedAndUserId(String title, boolean completed, UUID userId);
}
