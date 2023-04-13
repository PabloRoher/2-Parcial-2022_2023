package org.example;

import java.awt.*;

public class Canoe extends Ship{
    public Canoe(int size, Point start, Point end, CardinalPoint direction) {
        super(size, start, end, direction);
        System.out.println("Canoa creada");
    }
}
