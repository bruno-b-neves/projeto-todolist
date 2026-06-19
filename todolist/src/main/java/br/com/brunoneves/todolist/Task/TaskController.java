package br.com.brunoneves.todolist.Task;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired 
    private ITaskRepository taskRepository;

    
    @GetMapping("/")
    public String getTasks() {
        return "Fetching tasks...";
    }

    @PostMapping("/")
    public ResponseEntity<Object> createTask(@RequestBody TaskModel taskModel) {
        
        var taskTitle = this.taskRepository.findByTitle(taskModel.getTitle());
        if (taskTitle != null || taskModel.getTitle().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("O campo 'title' é obrigatório e não pode ser vazio!");
        }

        var taskPendenteComMesmoTitulo = this.taskRepository.findByTitleAndCompleted(taskModel.getTitle(), false);
        if (taskPendenteComMesmoTitulo != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Já existe uma tarefa pendente com o mesmo título!");
        }

        // Se não encontrou nenhuma pendente com esse nome, permite cadastrar!
        taskModel.setCreatedAt(java.time.LocalDateTime.now());
        
        // Garante que toda tarefa nova comece como pendente (false)
        taskModel.setCompleted(false);

        var taskCreated = this.taskRepository.save(taskModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskCreated);
    }
}
