package Model;

import java.util.HashMap;

public class Rook extends Piece {
    public Rook(char color, int x, int y) {
        super('R', color, x, y);
    }

    public void possibleMoves(int x, int y){

    }

    @Override
    public HashMap<Integer, Integer> possibleMoves() {
        return null;
    }
}
