package br.com.brunoneves.todolist.User;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

// @Repository | Não é necessário colocar a anotação @Repository, pois o 
// JpaRepository já é um componente do Spring e será automaticamente detectado e 
// registrado como um bean no contexto da aplicação.
public interface IUserRepository extends JpaRepository<UserModel, UUID> {
    UserModel findByUsername(String username);
    UserModel findByEmail(String email);
}
