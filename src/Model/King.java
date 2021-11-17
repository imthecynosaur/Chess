package Model;

import java.util.HashMap;

public class King extends Piece {
    public King(char color, int x, int y) {
        super('K', color, x, y);
    }

    public void possibleMoves(int x, int y){

    }

    @Override
    public HashMap<Integer, Integer> possibleMoves() {
        return null;
    }
}
