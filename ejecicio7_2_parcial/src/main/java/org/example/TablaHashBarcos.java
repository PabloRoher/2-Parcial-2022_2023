package org.example;

import java.util.HashMap;

public class TablaHashBarcos {
    public static void main(String[] args) {
        // Crear las tres tablas hash
        HashMap<String, HashMap<Integer, Ship>> tablaTipo = new HashMap<>(50);
        HashMap<Integer, Ship> tablaNumero = new HashMap<>(15);
        HashMap<String, Ship> tablaNombre = new HashMap<>(15);

        // Cargar algunos tipos de barcos en la primera tabla hash
        cargarTipoBarco(tablaTipo, "BattleShip");
        cargarTipoBarco(tablaTipo, "Fragata");
        cargarTipoBarco(tablaTipo, "Canoa");

        // Crear la segunda tabla hash para cada tipo de barco
        crearSegundaTabla(tablaTipo, tablaNumero);

        // Cargar algunos barcos en las tres tablas hash
        cargarBarco(tablaTipo, tablaNumero, tablaNombre, "BattleShip", 1, "Barco1", 80);
        cargarBarco(tablaTipo, tablaNumero, tablaNombre, "Fragata", 2, "Barco2", 60);
        cargarBarco(tablaTipo, tablaNumero, tablaNombre, "Canoa", 3, "Barco3", 100);
        cargarBarco(tablaTipo, tablaNumero, tablaNombre, "BattleShip", 4, "Barco4", 90);
        cargarBarco(tablaTipo, tablaNumero, tablaNombre, "Fragata", 5, "Barco5", 70);

        // Imprimir algunos barcos de las tres tablas hash
        System.out.println("Barco con número 3:");
        System.out.println(tablaNumero.get(3));
        System.out.println("Barco con nombre Barco4:");
        System.out.println(tablaNombre.get("Barco4"));
        System.out.println("Barcos del tipo BattleShip:");
        for (Ship barco : tablaTipo.get("BattleShip").values()) {
            System.out.println(barco);
        }
    }

    private static void cargarTipoBarco(HashMap<String, HashMap<Integer, Ship>> tablaTipo, String tipo) {
        if (!tablaTipo.containsKey(tipo)) {
            // Si el tipo de barco no existe en la primera tabla, lo añadimos
            tablaTipo.put(tipo, new HashMap<>());
        }
    }

    private static void crearSegundaTabla(HashMap<String, HashMap<Integer, Ship>> tablaTipo, HashMap<Integer, Ship> tablaNumero) {
        for (String tipo : tablaTipo.keySet()) {
            // Para cada tipo de barco, creamos una segunda tabla hash con un tamaño de 15
            tablaTipo.put(tipo, new HashMap<>(15));
        }
    }

    private static void cargarBarco(HashMap<String, HashMap<Integer, Ship>> tablaTipo, HashMap<Integer, Ship> tablaNumero, HashMap<String, Ship> tablaNombre, String tipo, int numero, String nombre, int nivel) {
        // Creamos un objeto Barco con los datos especificados
        Ship barco = new Ship(numero, nombre, tipo, nivel);

        // Añadimos el barco a la tabla hash de tipos de barco
        if (!tablaTipo.containsKey(tipo)) {
            // Si el tipo de barco no existe en la primera tabla, lo añadimos
            tablaTipo.put(tipo, new HashMap<>());
        }
        tablaTipo.get(tipo).put(numero, barco);

        // Añadimos el barco a la tabla hash de números de barco
        tablaNumero.put(numero, barco);

        // Añadimos el barco a la tabla hash de nombres de barco
        tablaNombre.put(nombre, barco);
    }

}
