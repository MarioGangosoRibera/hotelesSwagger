package com.example.hotelesswagger.repositorio;

import com.example.hotelesswagger.entidades.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    List<Hotel> findByLocalidadAndCategoria(String localidad, String categoria);
}
