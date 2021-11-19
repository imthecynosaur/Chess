package Model;

import java.util.ArrayList;

public class Queen extends Piece{
    public Queen(char color, int x, int y) {
    super('Q', color, x, y);
    }

    public void possibleMoves(int x, int y){

    }

    @Override
    public ArrayList<ArrayList<Integer>> possibleMoves() {
        return null;
    }
}
