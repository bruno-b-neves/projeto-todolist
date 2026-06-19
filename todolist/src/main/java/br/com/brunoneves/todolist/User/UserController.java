package br.com.brunoneves.todolist.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private IUserRepository userRepository;

    @GetMapping("/")
    public ResponseEntity<Object> getAll() {
        var users = this.userRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody UserModel userModel) {

        // Verificar se o usuário já existe no banco de dados usando o método findByUsername() do userRepository. Se um usuário com o mesmo nome de usuário já existir, ele retorna uma resposta HTTP 400 (Bad Request) com uma mensagem de erro indicando que o usuário já existe.
        var user = this.userRepository.findByUsername(userModel.getUsername());
        if (user != null) {
            System.out.println("Usuário já existe: " + userModel.getUsername());
            
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro: O usuário já existe!");
        }
        
        // Verificar se o email já existe no banco de dados usando o método findByEmail() do userRepository. Se um usuário com o mesmo email já existir, ele retorna uma resposta HTTP 400 (Bad Request) com uma mensagem de erro indicando que o email já existe.
        var userEmail = this.userRepository.findByEmail(userModel.getEmail());
        if (userEmail != null) {
            System.out.println("Email já existe: " + userModel.getEmail());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro: O email já existe!");
        }

        // BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray()): Este código utiliza a biblioteca BCrypt para hash da senha do usuário. O método hashToString() recebe dois parâmetros: o custo (neste caso, 12) e a senha convertida em um array de caracteres. O custo determina a complexidade do hash, onde um valor mais alto torna o processo de hashing mais lento, aumentando a segurança contra ataques de força bruta. O resultado é uma string que representa o hash da senha, que é então armazenada no banco de dados em vez da senha original.
        var passwordHash = BCrypt.withDefaults()
            .hashToString(12, userModel.getPassword().toCharArray());

        // userModel.setPassword(passwordHash): Este código define a senha do usuário para o hash gerado anteriormente. Em vez de armazenar a senha original em texto simples, ele armazena o hash da senha, o que é uma prática recomendada para segurança. Assim, mesmo que o banco de dados seja comprometido, os atacantes não terão acesso às senhas reais dos usuários, apenas aos hashes, que são difíceis de reverter para as senhas originais.
        userModel.setPassword(passwordHash);

        // userRepository.save(userModel): Salva o objeto userModel no banco de dados. O método save() é fornecido pelo JpaRepository e é usado para persistir entidades. Ele retorna a entidade salva, que pode incluir um ID gerado automaticamente, se aplicável.
        var userCreated = this.userRepository.save(userModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    };
}
