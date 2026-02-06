-- Tabela de Artistas
CREATE TABLE artists (
    id SERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    type VARCHAR(50) NOT NULL -- 'CANTOR' ou 'BANDA' (requisito 395)
);

-- Tabela de Álbuns
CREATE TABLE albums (
    id SERIAL PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    release_year INTEGER,
    cover_url TEXT -- Link MinIO (requisito 397)
);

-- Tabela de Relacionamento N:N (requisito 421)
CREATE TABLE artist_album (
    artist_id INTEGER NOT NULL,
    album_id INTEGER NOT NULL,
    PRIMARY KEY (artist_id, album_id),
    CONSTRAINT fk_artist FOREIGN KEY (artist_id) REFERENCES artists(id) ON DELETE CASCADE,
    CONSTRAINT fk_album FOREIGN KEY (album_id) REFERENCES albums(id) ON DELETE CASCADE
);

-- Carga inicial exata do edital (págs 9 e 12)
INSERT INTO artists (id, name, type) VALUES 
(1, 'Serj Tankian', 'CANTOR'),
(2, 'Mike Shinoda', 'CANTOR'),
(3, 'Michel Teló', 'CANTOR'),
(4, 'Guns N'' Roses', 'BANDA');

INSERT INTO albums (id, title) VALUES 
(1, 'Harakiri'), (2, 'Black Blooms'), (3, 'The Rough Dog'), -- Álbuns Serj [cite: 377]
(4, 'The Rising Tied'), (5, 'Post Traumatic'), (6, 'Post Traumatic EP'), (7, 'Where''d You Go'), -- Álbuns Mike [cite: 378]
(8, 'Bem Sertanejo'), (9, 'Bem Sertanejo - O Show (Ao Vivo)'), (10, 'Bem Sertanejo - (1ª Temporada) - EP'), -- Álbuns Teló [cite: 379]
(11, 'Use Your Illusion I'), (12, 'Use Your Illusion II'), (13, 'Greatest Hits'); -- Álbuns Guns [cite: 380]

-- Relacionamentos N:N conforme os exemplos
INSERT INTO artist_album (artist_id, album_id) VALUES 
(1,1), (1,2), (1,3), -- Serj
(2,4), (2,5), (2,6), (2,7), -- Mike
(3,8), (3,9), (3,10), -- Teló
(4,11), (4,12), (4,13); -- Guns