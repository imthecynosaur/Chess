package Model;

import java.util.HashMap;

public class Queen extends Piece{
    public Queen(char color, int x, int y) {
    super('Q', color, x, y);
    }

    public void possibleMoves(int x, int y){

    }

    @Override
    public HashMap<Integer, Integer> possibleMoves() {
        return null;
    }
}
