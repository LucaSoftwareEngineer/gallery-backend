package gallery.luca.backend.services;

import java.io.File;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import gallery.luca.backend.models.Foto;
import gallery.luca.backend.repositories.FotoRepository;

@Service
public class FotoService {

    @Autowired
    FotoRepository fotoRepository;

    final String PUBLIC_DIRECTORY = "/home/luca/Scrivania/WWW/gallery-backend/src/main/resources/public/";

    public List<Foto> getFoto() {
        return fotoRepository.findAll();
    }

    public Boolean uploadFoto(String nome, MultipartFile file) {

        String percorso = PUBLIC_DIRECTORY.concat(nome);

        if (nome == null) {
            return false;
        }

        if (file.isEmpty()) {
            return false;
        }

        try {
            file.transferTo(new File(percorso));
        } catch (Exception e) {
            return false;
        }

        Foto foto = new Foto(null, percorso);
        fotoRepository.save(foto);

        return true;
    }

}
