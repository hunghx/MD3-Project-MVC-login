package rikkei.academy.view;

import rikkei.academy.config.Config;


public class Navbar {
    public Navbar() {
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. ShowList User");
        int chooseMenu = Config.scanner().nextInt();
        switch (chooseMenu) {
            case 1:
                new UserView().formRegister();
                break;
            case 2:
                new UserView().formLogin();
                break;
            case 3:
                new UserView().showListUser();
                break;
        }
    }

    public static void main(String[] args) {
        new Navbar();

    }
}