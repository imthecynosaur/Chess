package Menus;



public class MainMenu extends Menu {
    MainMenu(Menu parentMenu) {
        super("Main Menu", parentMenu);

    }

    @Override
    public void show() {
        System.out.println("new_game [username] [limit]");
        System.out.println("scoreboard");
        System.out.println("list_users");
        System.out.println("help");
        System.out.println("logout");
    }

    @Override
    public void execute() {
        String input = scanner.nextLine();
        if (input.trim().toLowerCase().startsWith("logout")) {
            controller.setCurrentUser(null);
            System.out.println("logged out successfully.");
            this.parentMenu.execute();

        } else if (input.trim().toLowerCase().startsWith("help")) {
            this.show();


        } else if (input.trim().toLowerCase().startsWith("list")){
            controller.getUserslist();


        }else if (input.trim().toLowerCase().startsWith("score")){
            controller.getScore();


        } else if (input.trim().toLowerCase().startsWith("new")){
            try {
                if (controller.newGame(input.split("\\s+")[1], Integer.parseInt(input.split("\\s+")[2]))) {
                    System.out.println("game started");
                }
            } catch(Exception e) {
                System.out.println("missing an argument");
                this.execute();
            }


        } else {
            System.out.println("Invalid command!");
        }
        this.execute();
    }
}
