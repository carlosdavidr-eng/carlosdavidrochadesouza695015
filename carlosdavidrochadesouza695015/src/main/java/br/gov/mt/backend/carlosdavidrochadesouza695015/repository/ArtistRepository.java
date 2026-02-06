package br.gov.mt.backend.carlosdavidrochadesouza695015.repository;

import br.gov.mt.backend.carlosdavidrochadesouza695015.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
}