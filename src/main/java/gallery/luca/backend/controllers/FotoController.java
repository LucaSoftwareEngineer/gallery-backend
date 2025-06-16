package gallery.luca.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import gallery.luca.backend.models.Foto;
import gallery.luca.backend.services.FotoService;

@RestController
@CrossOrigin(origins = "*")
public class FotoController {

    @Autowired
    FotoService fotoService;

    @GetMapping("api/foto")
    public List<Foto> getFoto() {
        return fotoService.getFoto();
    }

    @PostMapping("api/foto/upload")
    public Boolean uploadFoto(@RequestParam("nome") String nome, @RequestPart("file") MultipartFile file) {
        return fotoService.uploadFoto(nome, file);
    }

    @DeleteMapping("api/foto/elimina")
    public Boolean eliminaFoto(@RequestParam("idFoto") Long idFoto) {
        return fotoService.eliminaFoto(idFoto);
    }

}
