package org.example;

import java.awt.*;

public class Frigate extends Ship{

    public Frigate(int size, Point start, Point end, CardinalPoint direction) {
        super(size, start, end, direction);
        System.out.println("Fragata creada");
    }

}
