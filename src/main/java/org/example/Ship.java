package org.example;

import java.awt.*;

public class Ship {
    private int size;
    private Point start;
    private Point end;
    private int hits;

    private CardinalPoints direction;

    public Ship(int size, Point start, Point end, CardinalPoints direction) {
        this.size = size;
        this.start = start;
        this.end = end;
        this.hits = 0;
        this.direction = direction;
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

    public CardinalPoints getDirection() {
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
        if (shotPoint.equals(start) || shotPoint.equals(end)) {
            hits++;
            return true;
        } else {
            return false;
        }
    }
}
