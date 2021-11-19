package Model;

import java.util.ArrayList;

public class King extends Piece {
    public King(char color, int x, int y) {
        super('K', color, x, y);
    }

    public void possibleMoves(int x, int y){

    }

    @Override
    public ArrayList<ArrayList<Integer>> possibleMoves() {
        return null;
    }
}
