package org.example;

import java.awt.*;
import java.util.*;

public class Menu {
    public void jugar() {

        boolean filtro1 = true;
        boolean filtro2 = true;
        boolean filtro3 = true;
        boolean filtro4 = true;
        boolean filtro5 = true;
        boolean filtro6 = true;
        boolean jugador1 = true;
        boolean jugador2 = true;
        boolean turno = true;
        boolean juego = true;

        while (jugador1) {
            try {

                User user1 = new User(new ArrayList<>());
                User user2 = new User(new ArrayList<>());
                System.out.println("Cree los barcos del jugador 1");
                System.out.println("¿Cuantos barcos desea crear?");
                Scanner sc = new Scanner(System.in);
                int numBarcos = sc.nextInt();
                if (numBarcos > 3 || numBarcos <= 0) {
                    throw new IllegalArgumentException("El número de barcos no puede ser superior a 3 o inferior a 1");
                }
                for (int i = 0; i < numBarcos; i++) {
                    while (filtro1) {
                        try {
                            System.out.println("Introduzca el tamaño del barco (Debera ser 1 para una canoa, 3 para una frigata o 5 para un barco de combate)");
                            int size = sc.nextInt();
                            if (!(size == 1 || size == 3 || size == 5)) {
                                throw new IllegalArgumentException("Tamaño de barco no valido");
                            }
                            filtro1 = false;
                            while (filtro2) {
                                System.out.println("Introduzca la coordenada x del punto de inicio");
                                int x = sc.nextInt();
                                System.out.println("Introduzca la coordenada y del punto de inicio");
                                int y = sc.nextInt();
                                System.out.println("Introduzca la coordenada x del punto de fin");
                                int x2 = sc.nextInt();
                                System.out.println("Introduzca la coordenada y del punto de fin");
                                int y2 = sc.nextInt();

                                try {
                                    System.out.println("Introduzca el numero que representa la orientación del barco");
                                    System.out.println("1. NORTH");
                                    System.out.println("2. SOUTH");
                                    System.out.println("3. EAST");
                                    System.out.println("4. WEST");
                                    int direccion = sc.nextInt();
                                    String direccion2 = "";
                                    switch (direccion) {
                                        case 1:
                                            direccion2 = "NORTH";
                                            break;
                                        case 2:
                                            direccion2 = "SOUTH";
                                            break;
                                        case 3:
                                            direccion2 = "EAST";
                                            break;
                                        case 4:
                                            direccion2 = "WEST";
                                            break;
                                        default:
                                            throw new IllegalArgumentException("Orientación no valida");
                                    }

                                    if (size == 1) {
                                        user1.setShip(new Canoe(size, new Point(x, y), new Point(x2, y2), CardinalPoint.valueOf(direccion2)));
                                    } else if (size == 3) {
                                        user1.setShip(new Frigate(size, new Point(x, y), new Point(x2, y2), CardinalPoint.valueOf(direccion2)));
                                    } else if (size == 5) {
                                        user1.setShip(new Battleship(size, new Point(x, y), new Point(x2, y2), CardinalPoint.valueOf(direccion2)));
                                    }
                                    filtro2 = false;
                                } catch (InputMismatchException e) {
                                    System.out.println("Introduzca un número");
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            if (!filtro2) {
                                filtro2 = true;
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    if (!filtro1) {
                        filtro1 = true;
                    }

                }
                while (jugador2) {
                    try {
                        System.out.println("Cree los barcos del jugador 2");
                        System.out.println("¿Cuantos barcos desea crear?");
                        int numBarcos2 = sc.nextInt();
                        if (numBarcos2 > 3 || numBarcos2 <= 0) {
                            throw new IllegalArgumentException("El número de barcos no puede ser superior a 3 o inferior a 1");
                        }
                        for (int i = 0; i < numBarcos2; i++) {
                            while (filtro3) {
                                try {
                                    System.out.println("Introduzca el tamaño del barco (Debera ser 1 para una canoa, 3 para una frigata o 5 para un barco de combate)");
                                    int size = sc.nextInt();
                                    if (!(size == 1 || size == 3 || size == 5)) {
                                        throw new IllegalArgumentException("Tamaño de barco no valido");
                                    }
                                    filtro3 = false;
                                    while (filtro4) {
                                        System.out.println("Introduzca la coordenada x del punto de inicio");
                                        int x = sc.nextInt();
                                        System.out.println("Introduzca la coordenada y del punto de inicio");
                                        int y = sc.nextInt();
                                        System.out.println("Introduzca la coordenada x del punto de fin");
                                        int x2 = sc.nextInt();
                                        System.out.println("Introduzca la coordenada y del punto de fin");
                                        int y2 = sc.nextInt();

                                        try {
                                            System.out.println("Introduzca el numero que representa la orientación del barco");
                                            System.out.println("1. NORTH");
                                            System.out.println("2. SOUTH");
                                            System.out.println("3. EAST");
                                            System.out.println("4. WEST");
                                            int direccion = sc.nextInt();
                                            String direccion2 = "";
                                            switch (direccion) {
                                                case 1:
                                                    direccion2 = "NORTH";
                                                    break;
                                                case 2:
                                                    direccion2 = "SOUTH";
                                                    break;
                                                case 3:
                                                    direccion2 = "EAST";
                                                    break;
                                                case 4:
                                                    direccion2 = "WEST";
                                                    break;
                                            }

                                            if (size == 1) {
                                                user2.setShip(new Canoe(size, new Point(x, y), new Point(x2, y2), CardinalPoint.valueOf(direccion2)));
                                            } else if (size == 3) {
                                                user2.setShip(new Frigate(size, new Point(x, y), new Point(x2, y2), CardinalPoint.valueOf(direccion2)));
                                            } else if (size == 5) {
                                                user2.setShip(new Battleship(size, new Point(x, y), new Point(x2, y2), CardinalPoint.valueOf(direccion2)));
                                            }
                                            filtro4 = false;
                                        } catch (InputMismatchException e) {
                                            System.out.println("Introduzca un número");
                                        } catch (IllegalArgumentException e) {
                                            System.out.println(e.getMessage());
                                        }

                                    }
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            filtro3 = true;
                            filtro4 = true;
                        }


                        while (turno) {
                            if (user1.isAlive() && user2.isAlive()) {
                                System.out.println("Turno del jugador 1");
                                System.out.println("Introduzca la coordenada x del punto donde quiere atacar");
                                int x = sc.nextInt();
                                System.out.println("Introduzca la coordenada y del punto donde quiere atacar");
                                int y = sc.nextInt();
                                user1.attack(new Point(x, y), user2);
                                user2.getShot(new Point(x, y));
                                System.out.println("Turno del jugador 2");
                                System.out.println("Introduzca la coordenada x del punto de inicio");
                                int x2 = sc.nextInt();
                                System.out.println("Introduzca la coordenada y del punto de inicio");
                                int y2 = sc.nextInt();
                                user2.attack(new Point(x2, y2), user1);
                                user1.getShot(new Point(x2, y2));
                                if (user1.isAlive() && !user2.isAlive()) {
                                    System.out.println("El jugador 1 ha ganado");
                                    break;
                                } else if (!user1.isAlive() && user2.isAlive()) {
                                    System.out.println("El jugador 2 ha ganado");
                                    break;
                                } else if (!user1.isAlive() && !user2.isAlive()) {
                                    System.out.println("Los dos jugadores han perdido");
                                    break;
                                }

                            }
                        }
                        jugador2 = false;
                    } catch (InputMismatchException e) {
                        System.out.println("Introduzca un número");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    }
                jugador1 = false;
            } catch (InputMismatchException e) {
                System.out.println("Introduzca un número");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
