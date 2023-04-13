package org.example;

import java.awt.*;


public class Ship {
    private int size;
    private Point start;
    private Point end;
    private int hits;
    private CardinalPoint direction;
    public Ship(int size, Point start,Point end, CardinalPoint direction) {
        try {
            if (size < 1 || size > 5) {
                throw new IllegalArgumentException("Tamaño del barco no valido");
            }
            if (start == end && size == 1) {
                this.size = size;
                this.start = start;
                this.end = end;
                this.hits = 0;
                this.direction = direction;
            } else if (start.x == end.x && start.y <= end.y) {
                if ((end.y - start.y) > size || (end.y - start.y) < size) {
                    throw new IllegalArgumentException("El tamaño del barco no coincide con la distancia entre los puntos");
                } else {
                    this.size = size;
                    this.start = start;
                    this.end = end;
                    this.hits = 0;
                    this.direction = direction;
                }

            } else if (start.y == end.y && start.x <= end.x) {
                if ((end.x - start.x) > size || (end.x - start.x) < size) {
                    throw new IllegalArgumentException("El tamaño del barco no coincide con la distancia entre los puntos");
                } else {
                    this.size = size;
                    this.start = start;
                    this.end = end;
                    this.hits = 0;
                    this.direction = direction;
                }
            } else {
                throw new IllegalArgumentException("Barco no valido");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public Point getEndPoint() {
        return end;
    }


    public Point getStartingPoint() {
        return start;
    }

    public int getSize() {
        return size;
    }

    public CardinalPoint getDirection() {
        return direction;
    }

    public int getHits() {
        return hits;
    }

    public void addHit() {
        hits++;
    }

    public boolean isSunk() {
        return this.hits >= this.size;
    }

    public boolean getShot(Point shotPoint) {
        int startX = start.x;
        int startY = start.y;
        int endX = end.x;
        int endY = end.y;

        if (shotPoint.x == startX && shotPoint.x == endX && shotPoint.y >= startY && shotPoint.y <= endY) {
            return true;
        } else if (shotPoint.y == startY && shotPoint.y == endY && shotPoint.x >= startX && shotPoint.x <= endX) {
            return true;
        }
        return false;
    }
}