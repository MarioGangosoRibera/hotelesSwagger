package com.example.hotelesswagger.servicio;

import com.example.hotelesswagger.entidades.Habitacion;
import com.example.hotelesswagger.entidades.Hotel;
import com.example.hotelesswagger.repositorio.HabitacionRepository;
import com.example.hotelesswagger.repositorio.HotelRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class HotelServices {
    private final HotelRepository hotelRepository;
    private final HabitacionRepository habitacionRepository;


    public HotelServices(HotelRepository hotelRepository, HabitacionRepository habitacionRepository) {
        this.hotelRepository = hotelRepository;
        this.habitacionRepository = habitacionRepository;
    }

    //Registrar nuevo hotel
    public Hotel saveHotel(Hotel hotel){
        return hotelRepository.save(hotel);
    }

    //Buscar hotel por id
    public Optional<Hotel> findHotelById(int idHotel){
        return hotelRepository.findById(idHotel);
    }

    //Buscar hoteles por localidad o categoria
    public List<Hotel> buscarHotelPorLocalidadOCategoria(String localidad, String categoria){
        return hotelRepository.findByLocalidadAndCategoria(localidad, categoria);
    }

    //Registrar una habitacion en un hotel
    public Habitacion addHabitacionToHotel(int hotelId, Habitacion habitacion){
        Optional<Hotel> hotelOptional = hotelRepository.findById(hotelId);
        if(hotelOptional.isPresent()){
            Hotel hotel = hotelOptional.get();
            habitacion.setHotel(hotel); //Relacion
            return habitacionRepository.save(habitacion);
        }
        return null;
    }

    //Eliminar una habitacion
    public void deleteHabitacionById(int hotelId, int habitacionId){
        habitacionRepository.deleteById(habitacionId);
    }

    //Modificar habitacion para decir que esta ocupada
    public Habitacion ocuparHabitacion(int hotelId, int habitacionId){
        Optional<Habitacion> habitacionOptional = habitacionRepository.findById(habitacionId);
        if(habitacionOptional.isPresent()){
            Habitacion habitacion = habitacionOptional.get();
            habitacion.setOcupada(true); //Ocupada
            return habitacionRepository.save(habitacion);
        }
        return null;
    }

    //Habitaciones libres de un hotel
    public List<Habitacion> buscarHabitacionesLibres(int hotelId, int tamano, double precioMin, double precioMax){
        return habitacionRepository.findByHotelIdAndTamanoAndPrecioBetween(hotelId, tamano, precioMin, precioMax);
    }

    //Todos los hoteles
    public List<Hotel> findAllHoteles(){
        return hotelRepository.findAll();
    }
}
