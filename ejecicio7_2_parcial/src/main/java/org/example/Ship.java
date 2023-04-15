package org.example;

public class Ship {
    int numero;
    String nombre;
    String tipo;
    int nivel;

    public Ship(int numero, String nombre, String tipo, int nivel) {
        this.numero = numero;
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "Barco{" +
                "numero=" + numero +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", nivel=" + nivel +
                '}';
    }
}
