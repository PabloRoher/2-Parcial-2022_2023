package org.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Ship> ships = new ArrayList<>();
    private boolean alive;

    public User(List<Ship> ships) {
        try {
            if (ships == null) {
                throw new IllegalArgumentException("Lista de barcos no valida");
            } else if (ships.size() > 3) {
                throw new IllegalArgumentException("No puedes crear mas de 3 barcos");
            }
            this.ships = ships;
            this.alive = true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean died() {
        return alive = false;
    }
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }

    public void setShip(Ship ship) {
        this.ships.add(ship);
    }

    public boolean attack(Point shotPoint, User user) {
        for (Ship ship : user.getShips()) {
            if (!ship.isSunk() && ship.getShot(shotPoint)) {
                ship.addHit();
                if (ship.isSunk()) {
                    System.out.println("Tocado y hundido");
                } else {
                    System.out.println("Tocado");
                }
                return true;
            }
        }
        return false;
    }

    public boolean getShot(Point shotPoint) {
        for (Ship ship : ships) {
            if (ship.getShot(shotPoint)) {
                if (ships.stream().allMatch(Ship::isSunk)) {
                    died();
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "ships=" + ships +
                '}';
    }
}
