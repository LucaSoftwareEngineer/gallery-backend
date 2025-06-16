package gallery.luca.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gallery.luca.backend.models.Foto;

public interface FotoRepository extends JpaRepository<Foto, Long> {

}
