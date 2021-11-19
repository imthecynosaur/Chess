package Controller;
import Controller.Controller;

import Model.*;

import java.util.ArrayList;
import java.util.HashMap;

public class GameController {
    private static final ArrayList<Piece> pieces = new ArrayList<>();
    private static Boolean isWhiteTurn = true;
    private static Piece selectedPiece;
    private Controller controller = new Controller();

    public GameController(){
    }

    public void showTurn(){
        if(isWhiteTurn){
            System.out.println("its white's turn now.");
        } else {
            System.out.println("its black's turn now.");
        }
    }

    public void setPieces() {
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

    }

    public void forfeit(){
        if (isWhiteTurn){
            controller.updateResults(Controller.whitePlayer, "lost");
            controller.updateResults(Controller.blackPlayer, "win");
        } else {
            controller.updateResults(Controller.whitePlayer, "win");
            controller.updateResults(Controller.blackPlayer, "lost");
        }
        pieces.clear();
    }

    public Piece checkForPiece(int x, int y){
        for (Piece piece : pieces) {
            if (piece.getX() == x) {
                if (piece.getY() == y) {
                    return piece;
                }
            }
        }
        return null;
    }

    public Boolean isEnemy(Piece piece){
        if (isWhiteTurn && piece.getColor()=='b'){
            return true;
        } else if (isWhiteTurn && piece.getColor()=='w') {
            return false;
        } else if (!isWhiteTurn && piece.getColor()=='b') {
            return false;
        } else if (!isWhiteTurn && piece.getColor()=='w') {
            return true;
        } else {
            System.out.println("something's wrong with enemycheck process!");
            return null;
        }
    }

    public Piece selectPiece(int x, int y) {
        Piece piece = checkForPiece(x, y);
        if (piece != null){
            if (!isEnemy(piece)){
                selectedPiece = piece;
                System.out.println("piece selected.");
                return piece;
            } else {
                System.out.println("the chosen piece belongs to enemy.");
                return null;
            }
        }
        System.out.println("no piece found with the given positions");
        return null;
    }

    public void unselectPiece(){
        System.out.println("deselected.");
        selectedPiece = null;
    }

    public void changeTurn(){
        System.out.println("turn finished.");
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

    public void move(int x, int y){
        if (selectedPiece != null) {
            HashMap<Integer, Integer> possibleMoves;
            possibleMoves = selectedPiece.possibleMoves();
            for (Integer i : possibleMoves.keySet()) {
                if (i == x){
                    if (possibleMoves.get(i) == y){
                        selectedPiece.setX(x);
                        selectedPiece.setY(y);
                        unselectPiece();
                        changeTurn();
                    }
                }
            }
        }

    }
}
