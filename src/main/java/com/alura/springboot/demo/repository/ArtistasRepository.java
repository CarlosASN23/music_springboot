package com.alura.springboot.demo.repository;

import com.alura.springboot.demo.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistasRepository extends JpaRepository<Artista, Long> {

}
