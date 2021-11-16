package Controller;

import Model.*;

import java.util.ArrayList;

public class GameController {
    private ArrayList<Piece> pieces;
    private Boolean isWhiteTurn;

    public GameController(){
        pieces = new ArrayList<>();
        for (int i = 1; i <= 8 ; i++) {
            pieces.add(new Pawn('w', i, 2));
        }
        pieces.add(new Rook('w', 1, 1));
        pieces.add(new Rook('w', 8, 1));
        pieces.add(new Knight('w', 2, 1));
        pieces.add(new Knight('w', 7, 1));
        pieces.add(new Bishop('w', 3, 1));
        pieces.add(new Bishop('w', 6, 1));
        pieces.add(new Queen('w', 4, 1));
        pieces.add(new King('w', 5, 1));


        for (int i = 1; i <= 8 ; i++) {
            pieces.add(new Pawn('b', i, 7));
        }
        pieces.add(new Rook('b', 1, 8));
        pieces.add(new Rook('b', 8, 8));
        pieces.add(new Knight('b', 2, 8));
        pieces.add(new Knight('b', 7, 8));
        pieces.add(new Bishop('b', 3, 8));
        pieces.add(new Bishop('b', 6, 8));
        pieces.add(new Queen('b', 4, 8));
        pieces.add(new King('b', 5, 8));


        isWhiteTurn = true;
    }

    public Piece selectPiece(int x, int y){
        for (Piece piece : pieces) {
            if (piece.getX() == x){
                if (piece.getY() == y){
                    if (piece.getColor() == 'w' && isWhiteTurn){
                        System.out.println("piece selected.");
                        return piece;
                    } else if (piece.getColor() == 'b' && !isWhiteTurn){
                        System.out.println("piece selected.");
                        return piece;
                    } else {
                        System.out.println("piece couldn't be selected.");
                        return null;
                    }
                }
            }
        }
        System.out.println("there were no piece with the given position.");
        return null;
    }

    public void changeTurn(){
        isWhiteTurn = !isWhiteTurn;
    }

    public void showBoard(){
        for (int j = 1; j <= 8 ; j++) {
            for (int i = 1; i <= 8 ; i++) {
                boolean pieceFound = false;
                for (Piece piece : pieces) {
                    if (piece.getX() == i && piece.getY() == j){
                        System.out.print("" + piece.getName() + piece.getColor() + " ");
                        if (i == 8) {
                            System.out.print('\n');
                        }
                        pieceFound = true;
                    }
                }
                if (!pieceFound){
                    System.out.print(" * ");
                    if (i == 8) {
                        System.out.print('\n');
                    }
                }
                pieceFound = false;
            }
        }
    }
}
