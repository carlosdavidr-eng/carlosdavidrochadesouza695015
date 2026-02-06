package br.gov.mt.backend.carlosdavidrochadesouza695015.controller;

import br.gov.mt.backend.carlosdavidrochadesouza695015.model.Album;
import br.gov.mt.backend.carlosdavidrochadesouza695015.repository.AlbumRepository;
import br.gov.mt.backend.carlosdavidrochadesouza695015.service.MinioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/albums")
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumRepository albumRepository;
    private final MinioService minioService;

    @GetMapping
    public ResponseEntity<Page<Album>> listAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(albumRepository.findAll(PageRequest.of(page, size)));
    }

    // Endpoint para upload da capa (Requisito 397 do Edital)
    @PostMapping("/{id}/cover")
    public ResponseEntity<Album> uploadCover(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws Exception {
        Album album = albumRepository.findById(id).orElseThrow(() -> new RuntimeException("Álbum não encontrado"));
        
        // Faz o upload e recebe o link do MinIO
        String coverUrl = minioService.uploadFile(file);
        
        // Atualiza o álbum com a nova URL
        album.setCoverUrl(coverUrl);
        return ResponseEntity.ok(albumRepository.save(album));
    }
}