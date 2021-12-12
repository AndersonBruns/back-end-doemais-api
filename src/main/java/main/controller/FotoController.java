package main.controller;

import main.model.Foto;
import main.repository.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foto")
public class FotoController {

    @Autowired
    FotoRepository fotoRepository;

    @PostMapping("/newfoto")
    public ResponseEntity<Foto> save(@RequestBody Foto foto) {
        Foto fo = fotoRepository.save(foto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/allfoto")
    public List<Foto> findAll() {
        return fotoRepository.findAll();
    }
}
