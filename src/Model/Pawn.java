package Model;

import Controller.GameController;

import java.util.ArrayList;
import java.util.Arrays;


public class Pawn extends Piece {

    private final GameController gameController;
    public Pawn(char color, int x, int y) {
        super('P', color, x, y);
        gameController = new GameController();
    }

    @Override
    public ArrayList<ArrayList<Integer>> possibleMoves() {
        ArrayList<ArrayList<Integer>> possibleMoves = new ArrayList<>();
        Piece piece;
        if (this.getColor() == 'w') {
            piece = gameController.checkForPiece(this.getX(), this.getY() + 1);
            if (piece == null){
                if (this.getY() < 8) {
                    possibleMoves.add(new ArrayList<>(Arrays.asList(this.getX(), this.getY() + 1)));
                }
                piece = gameController.checkForPiece(this.getX(), this.getY() + 2);
                if (this.getY() == 2 && piece == null) {
                    possibleMoves.add(new ArrayList<>(Arrays.asList(this.getX(), this.getY() + 2)));
                }
            }
            piece = gameController.checkForPiece(this.getX() + 1, this.getY() + 1);
            if (piece != null && gameController.isEnemy(piece)) {
                possibleMoves.add(new ArrayList<>(Arrays.asList(this.getX() + 1, this.getY() + 1)));
            }

            piece = gameController.checkForPiece(this.getX() - 1, this.getY() + 1);
            if (piece != null && gameController.isEnemy(piece)) {
                possibleMoves.add(new ArrayList<>(Arrays.asList(this.getX() - 1, this.getY() + 1)));
            }

        } else if (this.getColor() == 'b') {
            piece = gameController.checkForPiece(this.getX(), this.getY() - 1);
            if (piece == null){
                if (this.getY() > 1) {
                    possibleMoves.add(new ArrayList<>(Arrays.asList(this.getX(), this.getY() - 1)));
                }
                piece = gameController.checkForPiece(this.getX(), this.getY() - 2);
                if (this.getY() == 7 && piece == null) {
                    possibleMoves.add(new ArrayList<>(Arrays.asList(this.getX(), this.getY() - 2)));
                }
            }

            piece = gameController.checkForPiece(this.getX() + 1, this.getY() - 1);
            if (piece != null && gameController.isEnemy(piece)) {
                possibleMoves.add(new ArrayList<>(Arrays.asList(this.getX() + 1, this.getY() - 1)));
            }

            piece = gameController.checkForPiece(this.getX() - 1, this.getY() - 1);
            if (piece != null && gameController.isEnemy(piece)) {
                possibleMoves.add(new ArrayList<>(Arrays.asList(this.getX() - 1, this.getY() - 1)));
            }
        }

        return possibleMoves;
    }
}
