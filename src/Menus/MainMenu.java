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

        } else {
            System.out.println("Invalid command!");
        }
        this.execute();
    }
}
