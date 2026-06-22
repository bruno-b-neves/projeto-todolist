package br.com.brunoneves.todolist.Task;

import org.springframework.web.bind.annotation.RestController;

import br.com.brunoneves.todolist.User.UserModel;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(
    origins = "http://localhost:3000", 
    allowedHeaders = "*", 
    methods = {
        RequestMethod.GET, 
        RequestMethod.POST, 
        RequestMethod.PUT, 
        RequestMethod.DELETE, 
        RequestMethod.PATCH, // <--- ADICIONE ESTA LINHA!
        RequestMethod.OPTIONS
    }
)
public class TaskController {

    @Autowired 
    private ITaskRepository taskRepository;


    @GetMapping("/")
    public ResponseEntity<List<TaskModel>> listTasks(HttpServletRequest request) {
        UUID idDoUsuarioLogado = UUID.fromString(request.getHeader("idUser"));
        
        var tasks = this.taskRepository.findByUserId(idDoUsuarioLogado);
        return ResponseEntity.status(HttpStatus.OK).body(tasks);
    }

    @PostMapping("/")
    public ResponseEntity<Object> createTask(@RequestBody TaskModel taskModel, HttpServletRequest request) {
        UUID idDoUsuarioLogado = UUID.fromString(request.getHeader("idUser"));

        UserModel usuarioDono = new UserModel();
        usuarioDono.setId(idDoUsuarioLogado);

        taskModel.setUser(usuarioDono);

        var taskPendente = this.taskRepository.findByTitleAndCompletedAndUserId(
                taskModel.getTitle(), 
                false, 
                idDoUsuarioLogado
        );

        if (taskPendente != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Você já possui uma tarefa pendente com este mesmo título!");
        }

        taskModel.setCreatedAt(java.time.LocalDateTime.now());
        taskModel.setCompleted(false);

        var taskCreated = this.taskRepository.save(taskModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskCreated);
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<Object> completeTask(@PathVariable @NonNull UUID id) {
        var task = this.taskRepository.findById(id);
        if (task.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada!");
        }
        
        var taskToUpdate = task.get();
        taskToUpdate.setCompleted(true);
        

        var taskUpdated = this.taskRepository.save(taskToUpdate);
        return ResponseEntity.status(HttpStatus.OK).body(taskUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTask(@PathVariable @NonNull UUID id) {
        if (!this.taskRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada!");
        }

        this.taskRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
