package Controller;

import Model.*;

import java.util.ArrayList;

public class GameController {
    private static final ArrayList<Piece> pieces = new ArrayList<>();
    private final ArrayList<Piece> removedPieces = new ArrayList<>();
    private static Boolean isWhiteTurn = true;
    private static Piece selectedPiece;
//    private static Boolean isKingAlive = true;
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

    /*public Boolean getIsKingAlive(){
        if(!isKingAlive){
            forfeit();
            return false;
        } else {
            return true;
        }
    }*/

    public Boolean checkForWinner(){
        for (Piece removedPiece : removedPieces) {
            if (removedPiece.getName() == 'K'){
                if(removedPiece.getColor() == 'b'){
                    System.out.println("The White player has won!");
                    controller.updateResults(Controller.whitePlayer, "win");
                    controller.updateResults(Controller.blackPlayer, "lost");
                } else {
                    System.out.println("The Black player has won!");
                    controller.updateResults(Controller.whitePlayer, "lost");
                    controller.updateResults(Controller.blackPlayer, "win");
                }
                pieces.clear();
                return true;
            }
        }
        return false;
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

    public void collision(){
        for (Piece piece : pieces) {
            if (selectedPiece.getColor() != piece.getColor() && selectedPiece.getX() == piece.getX() && selectedPiece.getY() == piece.getY()){
                removedPieces.add(piece);
                pieces.remove(piece);
                break;
            }
        }
    }


    public void move(int x, int y){
        if (selectedPiece != null) {
            ArrayList<ArrayList<Integer>> possibleMoves;
            possibleMoves = selectedPiece.possibleMoves();
            boolean isMoveValid = false;
            for (ArrayList<Integer> possibleMove : possibleMoves) {
                if (possibleMove.get(0) == x && possibleMove.get(1) == y) {
                    selectedPiece.setX(x);
                    selectedPiece.setY(y);
                    collision();
                    unselectPiece();
                    isMoveValid = true;
                    changeTurn();
                    break;
                }

            }
            if (!isMoveValid) {
                System.out.println("you can't put your piece there.");
            }
        } else{
            System.out.println("you have to select a piece first.");
        }

    }

    public void showPossibleMoves(){
        if (selectedPiece != null){
            ArrayList<ArrayList<Integer>> possibleMoves;
            possibleMoves = selectedPiece.possibleMoves();
            System.out.println(possibleMoves);
        } else {
            System.out.println("you have to select a piece first.");
        }

    }

    public void showRemovedPieces(){
        for (Piece removedPiece : removedPieces) {
            System.out.print("" + removedPiece.getName() + removedPiece.getColor() + " \n");
        }
    }
}
