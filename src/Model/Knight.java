package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Knight extends Piece {
    public Knight(char color, int x, int y) {
        super('N', color, x, y);
    }


    private ArrayList<Integer> addToPossibleMove(int x, int y){
        if (x >= 1 && x <= 8){
            if (y >= 1 && y <= 8) {
                Piece piece = gameController.checkForPiece(x, y);
                if (piece == null) {
                    return new ArrayList<>(Arrays.asList(x, y));
                } else if (gameController.isEnemy(piece)) {
                    return new ArrayList<>(Arrays.asList(x, y));
                }
            }
        }
        return null;
    }

    @Override
    public ArrayList<ArrayList<Integer>> possibleMoves() {
        ArrayList<ArrayList<Integer>> possibleMoves = new ArrayList<>();
        possibleMoves.add(addToPossibleMove(this.getX()+1, this.getY()-2));
        possibleMoves.add(addToPossibleMove(this.getX()-1, this.getY()-2));
        possibleMoves.add(addToPossibleMove(this.getX()-1, this.getY()+2));
        possibleMoves.add(addToPossibleMove(this.getX()+1, this.getY()+2));
        possibleMoves.add(addToPossibleMove(this.getX()+2, this.getY()-1));
        possibleMoves.add(addToPossibleMove(this.getX()-2, this.getY()-1));
        possibleMoves.add(addToPossibleMove(this.getX()-2, this.getY()+1));
        possibleMoves.add(addToPossibleMove(this.getX()+2, this.getY()+1));

        possibleMoves.removeIf(Objects::isNull);
        return possibleMoves;
    }
}
