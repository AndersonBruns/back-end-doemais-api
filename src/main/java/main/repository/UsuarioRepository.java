package main.repository;

import main.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("select u from Usuario u where u.email = :email and u.senha = :senha")
    Optional<Usuario> loginValidator(String email, String senha);


    @Query("select u from Usuario u join u.categoria cat where cat.id = :id")
    Optional<List<Usuario>> userByCategoria(Long id);
}
