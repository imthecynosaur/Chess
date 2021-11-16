package Menus;

import Controller.GameController;

public class GameMenu extends Menu {
    GameController gameController;
    GameMenu(Menu parentMenu) {
        super("Game Menu", parentMenu);
        gameController = new GameController();
    }



    @Override
    public void show() {
        System.out.println("help");
        System.out.println("forfeit");
        System.out.println("show board");

    }

    @Override
    public void execute() {
        String input = scanner.nextLine();

         if (input.trim().toLowerCase().startsWith("help")) {
            this.show();


         } else if (input.trim().toLowerCase().startsWith("show")){
             gameController.showBoard();


         } else if (input.trim().toLowerCase().startsWith("forfeit")) {
             this.parentMenu.execute();
         }


         this.execute();
    }

}
