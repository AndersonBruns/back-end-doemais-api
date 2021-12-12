package main.controller;
import main.model.*;
import main.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @GetMapping("/login")
    public Optional<Usuario> loginValidatorUser(@RequestParam(required = true) String email,
                                                @RequestParam(required = true) String senha) {
        return usuarioRepository.loginValidator(email, senha);
    }

    @GetMapping("/userbycat/{id}")
    public Optional<List<Usuario>> userByCat(@PathVariable("id") Long id) {
        return usuarioRepository.userByCategoria(id);
    }

    @GetMapping("/allusuario")
    public List<Usuario> getAllUser(@RequestParam(required = false, defaultValue = "nome") String orderField,
                                      @RequestParam(required = false) String filter) {

        Sort user = Sort.by(Sort.Direction.ASC, "nome");
        return usuarioRepository.findAll(user);

    }

    @PostMapping("/newusuario")
    public ResponseEntity<Usuario> save(@RequestBody @Valid Usuario user) {

        Usuario userLocal = usuarioRepository.save(user);

        List<Foto> fotos = userLocal.getUserfoto();

        boolean needResave = false;

        for (Foto fot : fotos){
            if(fot.getUsuario() == null){
                needResave = true;
                fot.setUsuario(new Usuario(userLocal.getId()));
            }
        }
        if(needResave)
            userLocal = usuarioRepository.save(userLocal);

        System.out.print(userLocal.getId());
        return ResponseEntity.ok(userLocal);
    }

    @PutMapping("/alter/{id}")
    public ResponseEntity<Usuario> update(@PathVariable("id") Long id,
                                          @RequestBody @Valid Usuario user) {

        Optional<Usuario> userData = usuarioRepository.findById(id);

        if (userData.isPresent()) {
            usuarioRepository.save(user);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Usuario> delete(@PathVariable("id") Long id) {
        usuarioRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable("id") Long id) {
        Optional<Usuario> u = usuarioRepository.findById(id);
        if (u.isPresent()) {
            return ResponseEntity.ok(u.get());
        }
        return ResponseEntity.badRequest().build();
    }

}
