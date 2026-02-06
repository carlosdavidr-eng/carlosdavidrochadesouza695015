package br.gov.mt.backend.carlosdavidrochadesouza695015.controller;

import br.gov.mt.backend.carlosdavidrochadesouza695015.model.Artist;
import br.gov.mt.backend.carlosdavidrochadesouza695015.repository.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/artists")
@RequiredArgsConstructor
public class ArtistController {

    private final ArtistRepository artistRepository;

    @PostMapping
    public ResponseEntity<Artist> create(@RequestBody Artist artist) {
        return ResponseEntity.ok(artistRepository.save(artist));
    }

    @GetMapping
    public ResponseEntity<List<Artist>> findAll() {
        return ResponseEntity.ok(artistRepository.findAll());
    }
}