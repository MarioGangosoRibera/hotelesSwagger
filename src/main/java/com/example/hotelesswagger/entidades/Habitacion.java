package com.example.hotelesswagger.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "habitacion")
public class Habitacion {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idhabitacion")
    private int idhabitacion;

    @Column(name = "tamano")
    private int tamano; // Tamaño en metros cuadrados

    @Column(name = "capacidad")
    private int capacidad; // 1 o 2 personas

    @Column(name = "precioPorNoche")
    private double precioPorNoche;

    @Column(name = "incluyeDesayuno")
    private boolean incluyeDesayuno;

    @Column(name = "ocupada")
    private boolean ocupada;

    @ManyToOne
    @JoinColumn(name = "idhotel")
    @JsonBackReference
    private Hotel hotel;

    public Habitacion() {
    }

    public Habitacion(int tamano, int capacidad, double precioPorNoche, boolean incluyeDesayuno, boolean ocupada, Hotel hotel) {
        this.tamano = tamano;
        this.capacidad = capacidad;
        this.precioPorNoche = precioPorNoche;
        this.incluyeDesayuno = incluyeDesayuno;
        this.ocupada = ocupada;
        this.hotel = hotel;
    }

    public int getIdhabitacion() {
        return idhabitacion;
    }

    public void setIdhabitacion(int idhabitacion) {
        this.idhabitacion = idhabitacion;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    public boolean isIncluyeDesayuno() {
        return incluyeDesayuno;
    }

    public void setIncluyeDesayuno(boolean incluyeDesayuno) {
        this.incluyeDesayuno = incluyeDesayuno;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "idhabitacion=" + idhabitacion +
                ", tamano=" + tamano +
                ", capacidad=" + capacidad +
                ", precioPorNoche=" + precioPorNoche +
                ", incluyeDesayuno=" + incluyeDesayuno +
                ", ocupada=" + ocupada +
                ", hotel=" + hotel +
                '}';
    }
}