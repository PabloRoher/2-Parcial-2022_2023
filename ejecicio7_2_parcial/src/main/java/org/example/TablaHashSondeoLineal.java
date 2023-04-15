package org.example;

import java.util.HashMap;

public class TablaHashSondeoLineal {

    private final int TAMANO_INICIAL = 10;
    private int tamano;
    private int ocupados;
    private HashMap<String, Ship> tablaHash;

    public TablaHashSondeoLineal() {
        this.tamano = TAMANO_INICIAL;
        this.ocupados = 0;
        this.tablaHash = new HashMap<>();
    }

    public void put(String clave, Ship valor) {
        if (this.ocupados >= this.tamano * 0.7) {
            // Si la tabla hash está demasiado llena, aumentamos su tamaño
            this.tamano *= 2;
            this.tablaHash = new HashMap<>(this.tablaHash);
        }

        int posicion = this.obtenerPosicion(clave);
        while (this.tablaHash.containsKey(clave) && !this.tablaHash.get(clave).equals(valor)) {
            // Si la posición está ocupada y la clave no es igual, seguimos buscando
            posicion = (posicion + 1) % this.tamano;
        }

        this.tablaHash.put(clave, valor);
        this.ocupados++;
    }

    public Ship get(String clave) {
        int posicion = this.obtenerPosicion(clave);
        while (this.tablaHash.containsKey(clave) && !this.tablaHash.get(clave).equals(clave)) {
            // Si la posición está ocupada y la clave no es igual, seguimos buscando
            posicion = (posicion + 1) % this.tamano;
        }

        if (!this.tablaHash.containsKey(clave)) {
            // Si no encontramos la clave, devolvemos null
            return null;
        } else {
            return this.tablaHash.get(clave);
        }
    }

    private int obtenerPosicion(String clave) {
        // Función de sondeo: simplemente se calcula el hash y se reduce módulo el tamaño
        return Math.abs(clave.hashCode()) % this.tamano;
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