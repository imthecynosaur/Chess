package Controller;

import Model.User;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    private ArrayList<User> users;

    public Controller(){
        users = new ArrayList<>();
    }

    public Boolean checkFormat(String input){
        String patternString = "[^a-zA-Z0-9_]";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(input);
        Boolean isCorrectFormat = true;
        if (matcher.find()){
            isCorrectFormat = false;
            System.out.println("Username or password format is invalid!");
        }
        return isCorrectFormat;
    }

    public Boolean doesUserExists(String userName){
        Boolean userExists = false;
        for (User user : getUsers()) {
            if (user.getUserName().equals(userName)){
                userExists = true;
                break;
            }
        }
        return userExists;
    }


    public void register(String userName, String passWord){
        if (checkFormat(userName) && checkFormat(passWord)){
            if (!doesUserExists(userName)){
                for (User user : getUsers()) {
                    if (user.getUserName().equals(userName)){

                    }
                }
                users.add(new User(userName, passWord));
                System.out.println("register successful.");
            } else {
                System.out.println("User Already exists!");
            }
        }
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public Boolean checkPassWord(String userName, String passWord){
        for (User user : getUsers()) {
            if (user.getUserName().equals(userName)){
                if (user.getPassWord().equals(passWord)){
                    return true;
                }
            }
        }
        return false;
    }

    public void removeUser(String userName, String passWord) {
        outer:
        if (checkFormat(userName) && checkFormat(passWord)) {
            for (User user : users) {
                if (doesUserExists(userName)) {
                    if (checkPassWord(userName, passWord)) {
                        users.remove(user);
                        System.out.println("user successfully removed.");
                        break outer;
                    } else {
                        System.out.println("password incorrect.");
                    }
                }
            }
            if (!(doesUserExists(userName))) {
                System.out.println("no user found with this username.");
            }
        }
    }




}
