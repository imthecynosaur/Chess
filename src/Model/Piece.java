package Model;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Piece {
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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public abstract ArrayList<ArrayList<Integer>> possibleMoves();
}
