package br.gov.mt.backend.carlosdavidrochadesouza695015.repository;

import br.gov.mt.backend.carlosdavidrochadesouza695015.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
}