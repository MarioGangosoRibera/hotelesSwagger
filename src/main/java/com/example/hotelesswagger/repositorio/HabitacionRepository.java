package com.example.hotelesswagger.repositorio;

import com.example.hotelesswagger.entidades.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {
    List<Habitacion> findByHotel_IdAndTamanoAndPrecioPorNocheBetween(int hotelId, int tamano, double precioMin, double precioMax);
}