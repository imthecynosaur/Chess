package Menus;


import java.util.Scanner;

public class Login extends Menu {


    public Login(Menu parentMenu) {
        super("Login", null);
        this.setSubMenu(new MainMenu(this));
    }

    @Override
    public void show() {
        System.out.println("register [username] [password]");
        System.out.println("login [username] [password]");
        System.out.println("remove [username] [password]");
        System.out.println("list_users");
        System.out.println("help");
        System.out.println("exit");
    }

    @Override
    public void execute() {
        String input = scanner.nextLine();
        if (input.trim().toLowerCase().startsWith("exit")){
            System.out.println("Program ended.");
            System.exit(1);

        } else if (input.trim().toLowerCase().startsWith("help")){
            this.show();


        } else if (input.trim().toLowerCase().startsWith("register")){
            try {
                controller.register(input.split("\\s+")[1], input.split("\\s+")[2]);
            } catch(Exception e) {
                System.out.println("missing an argument");
                this.execute();
            }



        } else if (input.trim().toLowerCase().startsWith("list")) {
            controller.getUserlist();


        } else if (input.trim().toLowerCase().startsWith("remove")){
            try {
                controller.removeUser(input.split("\\s+")[1], input.split("\\s+")[2]);
            } catch(Exception e) {
                System.out.println("missing an argument");
                this.execute();
            }


        } else if (input.trim().toLowerCase().startsWith("login")){
            try {
                controller.login(input.split("\\s+")[1], input.split("\\s+")[2]);
                this.subMenu.execute();
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
