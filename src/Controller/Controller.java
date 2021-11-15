package Controller;

import Model.User;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    private ArrayList<User> users;
    private User currentUser;

    public Controller(){
        users = new ArrayList<>();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void getUserslist(){
        for (User user : users) {
            System.out.println(user.getUserName());
        }
    }

    public void getScore(){
        for (User user : users) {
            System.out.println(user.getUserName() + " : " + user.getScore());
        }
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public Boolean checkFormat(String input){
        String patternString = "[^a-zA-Z0-9_]";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(input);
        boolean isCorrectFormat = true;
        if (matcher.find()){
            isCorrectFormat = false;
            System.out.println("Username or password format is invalid!");
        }
        return isCorrectFormat;
    }

    public Boolean checkPassWord(User user, String passWord){
        return user.getPassWord().equals(passWord);
    }

    public User checkForUser(String userName){
        for (User user : getUsers()) {
            if (user.getUserName().equals(userName)){
                return user;
            }
        }
        return null;
    }



    public void register(String userName, String passWord){
        if (checkFormat(userName) && checkFormat(passWord)){
            if (checkForUser(userName) == null){
                this.users.add(new User(userName, passWord));
                System.out.println("register successful.");
            } else {
                System.out.println("User Already exists!");
            }
        }
    }

    public Boolean login(String userName, String passWord){
        if (checkFormat(userName) && checkFormat(passWord)){
            User user = checkForUser(userName);
            if (user != null){
                if (checkPassWord(user, passWord)){
                    setCurrentUser(user);
                    System.out.println("logged in successfully.");
                    return true;
                } else {
                    System.out.println("password is incorrect!");
                }
            } else {
                System.out.println("no user found with this username!");
            }
        }
        return false;
    }

    public void removeUser(String userName, String passWord) {
        if (checkFormat(userName) && checkFormat(passWord)) {
            User user = checkForUser(userName);
            if (user != null) {
                if (checkPassWord(user, passWord)) {
                    users.remove(user);
                    System.out.println("user successfully removed.");
                } else {
                    System.out.println("password incorrect.");
                }
            } else {
                System.out.println("no user found with this username.");
            }
        }
    }




}
