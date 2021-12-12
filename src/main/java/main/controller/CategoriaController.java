package main.controller;
import main.model.Categoria;
import main.model.Usuario;
import main.repository.CategoriaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @GetMapping("/allcategoria")
    public List<Categoria> getAllCategoria(@RequestParam(required = false, defaultValue = "nome") String orderField,
                                                      @RequestParam(required = false) String filter) {

            Sort categoria = Sort.by(Sort.Direction.ASC, "nome");
            return categoriaRepository.findAll(categoria);

    }

    @PostMapping("/newcategoria")
    public ResponseEntity<Categoria> save(@RequestBody @Valid Categoria categoria){
        Categoria cat = categoriaRepository.save(categoria);
        return ResponseEntity.ok(cat);
    }
}
