package Model;

import java.util.ArrayList;
import java.util.Arrays;

public class Bishop extends Piece {
    public Bishop(char color, int x, int y) {
        super('B', color, x, y);
    }

    public void possibleMoves(int x, int y){

    }

    @Override
    public ArrayList<ArrayList<Integer>> possibleMoves() {
        ArrayList<ArrayList<Integer>> possibleMoves = new ArrayList<>();
        Piece piece;
        for (int i = this.getX()+1; i <= 8 ; i++) {
            int posY = this.getY()+this.getX()-i;
            if (posY >= 1){
                piece = gameController.checkForPiece(i, posY);
                if(piece == null){
                    possibleMoves.add(new ArrayList<>(Arrays.asList(i, posY)));
                } else if(gameController.isEnemy(piece)){
                    possibleMoves.add(new ArrayList<>(Arrays.asList(i, posY)));
                    break;
                } else if(!gameController.isEnemy(piece)){
                    break;
                }
            }
        }

        for (int i = this.getX()-1; i >= 1 ; i--) {
            int posY = this.getY()- (this.getX()-i);
            if (posY >= 1){
                piece = gameController.checkForPiece(i, posY);
                if(piece == null){
                    possibleMoves.add(new ArrayList<>(Arrays.asList(i, posY)));
                } else if(gameController.isEnemy(piece)){
                    possibleMoves.add(new ArrayList<>(Arrays.asList(i, posY)));
                    break;
                } else if(!gameController.isEnemy(piece)){
                    break;
                }
            }
        }

        for (int i = this.getX()-1; i >= 1 ; i--) {
            int posY = this.getY() + (this.getX()-i);
            if (posY <= 8){
                piece = gameController.checkForPiece(i, posY);
                if(piece == null){
                    possibleMoves.add(new ArrayList<>(Arrays.asList(i, posY)));
                } else if(gameController.isEnemy(piece)){
                    possibleMoves.add(new ArrayList<>(Arrays.asList(i, posY)));
                    break;
                } else if(!gameController.isEnemy(piece)){
                    break;
                }
            }
        }

        for (int i = this.getX()+1; i <= 8 ; i++) {
            int posY = this.getY()+ (i - this.getX());
            if (posY <= 8){
                piece = gameController.checkForPiece(i, posY);
                if(piece == null){
                    possibleMoves.add(new ArrayList<>(Arrays.asList(i, posY)));
                } else if(gameController.isEnemy(piece)){
                    possibleMoves.add(new ArrayList<>(Arrays.asList(i, posY)));
                    break;
                } else if(!gameController.isEnemy(piece)){
                    break;
                }
            }
        }

        return possibleMoves;
    }
}
