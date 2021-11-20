package Model;

import java.util.ArrayList;
import java.util.Arrays;

public class King extends Piece {
    public King(char color, int x, int y) {
        super('K', color, x, y);
    }

    public void possibleMoves(int x, int y){

    }

    @Override
    public ArrayList<ArrayList<Integer>> possibleMoves() {
        ArrayList<ArrayList<Integer>> possibleMoves = new ArrayList<>();
        Piece piece;
        for (int j = this.getY()-1; j <= this.getY()+1 ; j++) {
            if(j >= 1 && j <= 8){
                for (int i = this.getX()-1; i <= this.getX()+1 ; i++) {
                    if(i >= 1 && i <= 8){
                        piece = gameController.checkForPiece(i, j);
                        if(piece == null){
                            possibleMoves.add(new ArrayList<>(Arrays.asList(i, j)));
                        } else if(gameController.isEnemy(piece)){
                            possibleMoves.add(new ArrayList<>(Arrays.asList(i, j)));
                        }
                    }
                }
            }

        }
        return possibleMoves;
    }
}
