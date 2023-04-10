package org.example;

import java.awt.*;


public class Ship {
    private int size;
    private Point start;
    private Point end;
    private int hits;
    private CardinalPoint direction;
    public Ship(int size, Point start,Point end, CardinalPoint direction) {
        if (size < 1 || size > 5) {
            throw new IllegalArgumentException("Invalid ship size");
        }
        if (start == end){
            this.size = size;
            this.start = start;
            this.end = end;
            this.hits = 0;
            this.direction = direction;
        } else if (start.x == end.x && start.y <= end.y) {
            if ((start.y - end.y) > size){
                throw new IllegalArgumentException("Invalid ship");
            }else {
                this.size = size;
                this.start = start;
                this.end = end;
                this.hits = 0;
                this.direction = direction;
            }

        } else if (start.y == end.y && start.x <= end.x) {
            if ((start.x - end.x) > size){
                throw new IllegalArgumentException("Invalid ship");
            }else {
                this.size = size;
                this.start = start;
                this.end = end;
                this.hits = 0;
                this.direction = direction;
            }
        } else {
            throw new IllegalArgumentException("Invalid ship");
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
