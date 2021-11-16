package Model;

import java.util.HashMap;

public class Piece {
    private char name;
    private char color;
    private int x;
    private int y;

    public Piece(char name, char color, int x, int y){
        this.name = name;
        this.color = color;
        this.x = x;
        this.y = y;

    }

    public char getName() {
        return name;
    }

    public char getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
