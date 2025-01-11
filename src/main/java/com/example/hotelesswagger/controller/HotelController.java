package com.example.hotelesswagger.controller;

import com.example.hotelesswagger.entidades.Habitacion;
import com.example.hotelesswagger.entidades.Hotel;
import com.example.hotelesswagger.servicio.HotelServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/hoteles")
public class HotelController {
    private final HotelServices hotelServices;

    public HotelController(HotelServices hotelServices) {
        this.hotelServices = hotelServices;
    }

    @GetMapping("/")
    public List<Hotel> getAllHoteles() {
        try {
            return hotelServices.findAllHoteles();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al obtener todos los hoteles", e);
        }
    }

    @GetMapping("{idHotel}")
    public ResponseEntity<?> getHotel(@PathVariable int idHotel){
        return ResponseEntity.of(hotelServices.findHotelById(idHotel));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Hotel>> buscarHoteles(@RequestParam String localidad, @RequestParam String categoria){
        List<Hotel> hoteles = hotelServices.buscarHotelPorLocalidadOCategoria(localidad, categoria);
        return ResponseEntity.ok(hoteles);
    }

    @PostMapping("/save")
    public ResponseEntity<?> createHotel(@RequestBody Hotel hotel){
        hotelServices.saveHotel(hotel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/{hotelId}/habitaciones")
    public ResponseEntity<?> agregarHabitacion(@PathVariable int hotelId, @RequestBody Habitacion habitacion){
        Habitacion nuevaHabitacion = hotelServices.addHabitacionToHotel(hotelId, habitacion);
        return nuevaHabitacion != null ? ResponseEntity.status(HttpStatus.CREATED).body(nuevaHabitacion) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{hotelId}/habitaciones/{habitacionId}")
    public ResponseEntity<?> eliminarHabitacion(@PathVariable int hotelId, @PathVariable int habitacionId){
        hotelServices.deleteHabitacionById(hotelId, habitacionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{hotelId}/habitaciones/{habitacionId}/ocupar")
    public ResponseEntity<?> ocuparHabitacion(@PathVariable int hotelId, @PathVariable int habitacionId){
        Habitacion habitacionOcupada = hotelServices.ocuparHabitacion(hotelId, habitacionId);
        return habitacionOcupada != null ? ResponseEntity.ok(habitacionOcupada) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{hotelId}/habitaciones/libres")
    public ResponseEntity<List<Habitacion>> buscarHabitacionesLibres(@PathVariable int hotelId, @RequestParam int tamano, @RequestParam double precioMin, @RequestParam double precioMax){
        List<Habitacion> habitacionesLibres = hotelServices.buscarHabitacionesLibres(hotelId, tamano, precioMin, precioMax);
        return ResponseEntity.ok(habitacionesLibres);
    }
}
