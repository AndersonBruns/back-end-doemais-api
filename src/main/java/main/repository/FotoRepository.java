package main.repository;

import main.model.Foto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FotoRepository extends JpaRepository<Foto, Long> {
}
