package Model;

import java.util.ArrayList;

public class Knight extends Piece {
    public Knight(char color, int x, int y) {
        super('N', color, x, y);
    }

    public void possibleMoves(int x, int y){

    }

    @Override
    public ArrayList<ArrayList<Integer>> possibleMoves() {
        return null;
    }
}
