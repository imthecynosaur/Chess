package Menus;

import java.util.HashMap;
import java.util.Scanner;

public class Menu {
    private String name;
    private Menu parentMenu;
    private Menu subMenu;
    protected Scanner scanner;

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
