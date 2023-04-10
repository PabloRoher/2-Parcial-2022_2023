package org.example;

import java.awt.*;
import java.util.List;

public class User {
    private List<Ship> ships;
    private boolean alive;

    public User(List<Ship> ships) {
        if (ships == null || ships.isEmpty()) {
            throw new IllegalArgumentException("Invalid ship list");
        }

        this.ships = ships;
        this.alive = true;
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

    public boolean attack(Point shotPoint, User user) {
        for (Ship ship : user.getShips()) {
            if (!ship.isSunk() && ship.getShot(shotPoint)) {
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
