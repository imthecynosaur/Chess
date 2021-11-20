package Model;

import java.util.ArrayList;
import java.util.Arrays;

public class Rook extends Piece {
    public Rook(char color, int x, int y) {
        super('R', color, x, y);
    }

    public void possibleMoves(int x, int y){

    }

    @Override
    public ArrayList<ArrayList<Integer>> possibleMoves() {
        ArrayList<ArrayList<Integer>> possibleMoves = new ArrayList<>();
        Piece piece;
        for (int i = this.getX()+1; i <= 8; i++) {
            piece = gameController.checkForPiece(i, this.getY());
            if(piece == null){
                possibleMoves.add(new ArrayList<>(Arrays.asList(i, this.getY())));
            } else if(gameController.isEnemy(piece)){
                possibleMoves.add(new ArrayList<>(Arrays.asList(i, this.getY())));
                break;
            } else if(!gameController.isEnemy(piece)){
                break;
            }
        }

        for (int i = this.getX()-1; i >= 1; i--) {
            piece = gameController.checkForPiece(i, this.getY());
            if(piece == null){
                possibleMoves.add(new ArrayList<>(Arrays.asList(i, this.getY())));
            } else if(gameController.isEnemy(piece)){
                possibleMoves.add(new ArrayList<>(Arrays.asList(i, this.getY())));
                break;
            } else if(!gameController.isEnemy(piece)){
                break;
            }
        }

        for (int j = this.getY()+1; j <= 8 ; j++) {
            piece = gameController.checkForPiece(this.getX(), j);
            if(piece == null){
                possibleMoves.add(new ArrayList<>(Arrays.asList(this.getX(), j)));
            } else if(gameController.isEnemy(piece)){
                possibleMoves.add(new ArrayList<>(Arrays.asList(this.getX(), j)));
                break;
            } else if(!gameController.isEnemy(piece)){
                break;
            }
        }

        for (int j = this.getY()-1; j >= 1 ; j--) {
            piece = gameController.checkForPiece(this.getX(), j);
            if(piece == null){
                possibleMoves.add(new ArrayList<>(Arrays.asList(this.getX(), j)));
            } else if(gameController.isEnemy(piece)){
                possibleMoves.add(new ArrayList<>(Arrays.asList(this.getX(), j)));
                break;
            } else if(!gameController.isEnemy(piece)){
                break;
            }
        }


        return possibleMoves;
    }
}
