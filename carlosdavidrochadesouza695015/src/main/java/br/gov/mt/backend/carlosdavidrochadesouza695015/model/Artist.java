package br.gov.mt.backend.carlosdavidrochadesouza695015.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "artists")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type; // CANTOR ou BANDA (Requisito 395)

    @ManyToMany(mappedBy = "artists")
    private Set<Album> albums = new HashSet<>();
}