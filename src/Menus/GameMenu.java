package Menus;


import Controller.GameController;

public class GameMenu extends Menu {
    GameMenu(Menu parentMenu) {
        super("Game Menu", parentMenu);
    }



    @Override
    public void show() {
        System.out.println("help");
        System.out.println("forfeit");
        System.out.println("show board");
        System.out.println("[show] turn");
        /*
        * end turn is not implemented
        */
        System.out.println("end turn");
        System.out.println("select [x] [y]");
        System.out.println("unselect");
        System.out.println("possible moves");
        System.out.println("move [x] [y]");

    }

    @Override
    public void execute() {
        String input = scanner.nextLine();
        if (input.trim().toLowerCase().startsWith("help")) {
            this.show();


        } else if (input.trim().toLowerCase().startsWith("show")){
            gameController.showBoard();


        } else if (input.trim().toLowerCase().startsWith("turn")){
            gameController.showTurn();


        } else if (input.trim().toLowerCase().startsWith("forfeit")) {
            gameController.forfeit();
            this.parentMenu.execute();


        } else if (input.trim().toLowerCase().startsWith("end")){
            gameController.changeTurn();


        } else if (input.trim().toLowerCase().startsWith("select")){
            try {
                gameController.selectPiece(Integer.parseInt(input.split("\\s+")[1]), Integer.parseInt(input.split("\\s+")[2]));
            } catch (Exception e){
                System.out.println("missing an argument");
                this.execute();
            }



        } else if (input.trim().toLowerCase().startsWith("unselect")){
            try {
                gameController.unselectPiece();
            } catch (Exception e){
                System.out.println("missing an argument");
                this.execute();
            }


        } else if (input.trim().toLowerCase().startsWith("move")){
            try {
                gameController.move(Integer.parseInt(input.split("\\s+")[1]), Integer.parseInt(input.split("\\s+")[2]));
                if(!gameController.getIsKingAlive()){
                    System.out.println("game ended.");
                    this.parentMenu.execute();
                }
            } catch (Exception e){
                System.out.println("missing an argument");
                this.execute();
            }


        } else if(input.trim().toLowerCase().startsWith("possible")){
            gameController.showPossibleMoves();


        } else {
            System.out.println("invalid command");
        }


        this.execute();
    }
}
