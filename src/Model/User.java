package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private String userName;
    private String passWord;
    private int score;
    private HashMap<String, Integer> results;

    public User(String userName, String passWord){
        this.userName = userName;
        this.passWord = passWord;
        this.score = 0;
        results = new HashMap<>();
        results.put("Wins", 0);
        results.put("Draws", 0);
        results.put("Losses", 0);
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public HashMap<String, Integer> getResults() {
        return results;
    }

    public int getScore() {
        return score;
    }

    public void setScore() {
        for (String result : results.keySet()) {
            switch (result){
                case "Wins":
                    this.score =+ 3;
                    break;
                case "Draws":
                    this.score =+ 1;
            }
        }
    }
}
