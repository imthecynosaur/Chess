package Menus;

import Controller.Controller;
import Controller.GameController;

import java.util.HashMap;
import java.util.Scanner;

public class Menu {
    private final String name;
    protected Menu parentMenu;
    protected Menu subMenu;
    protected Scanner scanner;
    protected static Controller controller = new Controller();
    protected static GameController gameController = new GameController();

    Menu(String name, Menu parentMenu){
        this.name = name;
        this.parentMenu = parentMenu;
        scanner = new Scanner(System.in);
    }

    public void setSubMenu(Menu subMenu) {
        this.subMenu = subMenu;
    }

    public void show(){

    }

    public void execute(){

    }
}
