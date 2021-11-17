package Model;

import Controller.GameController;

import java.util.HashMap;


public class Pawn extends Piece {

    private GameController gameController;
    public Pawn(char color, int x, int y) {
        super('P', color, x, y);
        gameController = new GameController();
    }

    @Override
    public HashMap<Integer, Integer> possibleMoves(){
        HashMap<Integer, Integer> possibleMoves = new HashMap<>();
        Piece piece;
        if (this.getColor() == 'w'){
            if (this.getY() == 2){
                possibleMoves.put(this.getX(), this.getY()+2);
            }

            if (this.getY() < 8){
                possibleMoves.put(this.getX(), this.getY()+1);
            }

            piece = gameController.checkForPiece(this.getX()+1, this.getY()+1);
            if (piece != null && piece.getColor() != this.getColor()){
                possibleMoves.put(this.getX()+1, this.getY()+1);
            }

            piece = gameController.checkForPiece(this.getX()-1, this.getY()+1);
            if (piece != null && piece.getColor() != this.getColor()){
                possibleMoves.put(this.getX()-1, this.getY()+1);
            }
        } else if (this.getColor() == 'b'){
            if (this.getY() == 7){
                possibleMoves.put(this.getX(), this.getY()-2);
            }

            if (this.getY() < 1){
                possibleMoves.put(this.getX(), this.getY()-1);
            }

            piece = gameController.checkForPiece(this.getX()+1, this.getY()-1);
            if (piece != null && piece.getColor() != this.getColor()){
                possibleMoves.put(this.getX()+1, this.getY()-1);
            }

            piece = gameController.checkForPiece(this.getX()-1, this.getY()-1);
            if (piece != null && piece.getColor() != this.getColor()){
                possibleMoves.put(this.getX()-1, this.getY()-1);
            }
        }


        return possibleMoves;
    }
}
