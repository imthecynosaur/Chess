package Menus;

import Controller.Controller;

import java.util.HashMap;
import java.util.Scanner;

public class Menu {
    private String name;
    protected Menu parentMenu;
    protected Menu subMenu;
    protected Scanner scanner;
    protected static Controller controller = new Controller();

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
