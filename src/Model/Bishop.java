package Model;

import java.util.HashMap;

public class Bishop extends Piece {
    public Bishop(char color, int x, int y) {
        super('B', color, x, y);
    }

    public void possibleMoves(int x, int y){

    }

    @Override
    public HashMap<Integer, Integer> possibleMoves() {
        return null;
    }
}
