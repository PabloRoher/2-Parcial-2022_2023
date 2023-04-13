package org.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Battleship extends Ship{

    List<Point> points = new ArrayList<>();

    public Battleship(int size, Point start, Point end, CardinalPoint direction) {
        super(size, start, end, direction);
        System.out.println("Barco de combate creado");
    }

    public boolean getShot(Point shotPoint) {
        int startX = start.x;
        int startY = start.y;
        int endX = end.x;
        int endY = end.y;

        if (shotPoint.x == startX && shotPoint.x == endX && shotPoint.y >= startY && shotPoint.y <= endY) {
            if (points.contains(shotPoint)) {
                return true;
            } else {
                points.add(shotPoint);
                return true;
            }
        } else if (shotPoint.y == startY && shotPoint.y == endY && shotPoint.x >= startX && shotPoint.x <= endX) {
            if (points.contains(shotPoint)) {
                return true;
            } else {
                points.add(shotPoint);
                return true;
            }
        }
        return false;
    }

    public boolean isSunk() {
        if (start.x == end.x && start.y <= end.y) {
            for (int y = start.y; y <= end.y; y++) {
                if (!points.contains(new Point(start.x, y))) {
                    return false;
                }
            }
            return true;
        } else if (start.y == end.y && start.x <= end.x) {
            for (int x = start.x; x <= end.x; x++) {
                if (!points.contains(new Point(x, start.y))) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
