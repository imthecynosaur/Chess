package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class User {
    private String userName;
    private String passWord;
    private int score;
    private ArrayList<Integer> results;

    public User(String userName, String passWord){
        this.userName = userName;
        this.passWord = passWord;
        this.score = 0;
        results = new ArrayList<>(Arrays.asList(0, 0, 0));
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public ArrayList getResults(){
        return results;
    }

    public int getScore() {
        return score;
    }

    public int setScore() {
        this.score = (results.get(0) * 3 + results.get(1));
        return this.score;
    }

    public void updateResults(String result){
        switch (result){
            case "win":
               results.set(0, results.get(0)+1);
               break;
            case "draw":
                results.set(1, results.get(1)+1);
                break;
            case "lost":
                results.set(2, results.get(2)+1);
                break;
        }
        setScore();
    }


}
