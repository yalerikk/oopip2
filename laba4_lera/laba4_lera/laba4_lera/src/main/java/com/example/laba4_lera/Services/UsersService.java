package com.example.laba4_lera.Services;

import com.example.laba4_lera.Models.Train;
import com.example.laba4_lera.Models.User;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsersService {
    private static List<User> users = new ArrayList<>(Arrays.asList(new User("admin", "admin")));

    Command delete;
    Command add;

    public UsersService(Command add, Command delete){
        this.add = add;
        this.delete = delete;
    }

    public static boolean checkUsers(String password, String login) {
      for (User u: users) {
            if(u.getLoginU().equals(login) && u.getPasswordU().equals(password)){
                return true;
            }
        }
        return false;
    }

    public static User getUser(String password, String login) {
        User user = null;
        for (User u: users) {
            if(u.getLoginU().equals(login) && u.getPasswordU().equals(password)){
                user = u;
            }
        }
        return user;
    }

    public static boolean checkRightRegistration(String password, String password2) {
        return password.equals(password2);
    }

    public static void registration(String password, String login) {
        users.add(new User(login, password));
    }


    public void deleteRecord(Train product, ObservableList<Train> observableList){
        delete.execute(product,observableList);
    }

    public void addRecord(Train product, ObservableList<Train> observableList){
        add.execute(product, observableList);
    }
}
