package com.alura.springboot.demo.repository;

import com.alura.springboot.demo.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicaRepository  extends JpaRepository<Musica, Long> {

}
