package rikkei.academy.service;

import rikkei.academy.config.Config;
import rikkei.academy.model.User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class UserServiceIMPL implements IUserService{
    List<User> userList = new Config<User>().readFromFile(Config.PATH_USER);
    @Override
    public List<User> findAll() {
        return userList;
    }

    @Override
    public void save(User user) {
        userList.add(user);
        new Config<User>().writeToFile(Config.PATH_USER, userList);
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public boolean existedByUsername(String username) {
        for (int i = 0; i < userList.size(); i++) {
            if(userList.get(i).getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existedByEmail(String email) {
        for (int i = 0; i < userList.size(); i++) {
            if(userList.get(i).getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }
    public boolean checkLogin(String username,String password){
        List<User> list = new Config<User>().readFromFile(Config.PATH_USER_LOGIN);
        for (User user:userList
             ) {
            if (user.getUsername().equals(username)&& user.getPassword().equals(password)){
                list.add(user);
             new Config().writeToFile(Config.PATH_USER_LOGIN,list);
             return true;
            }
        }
        return false;

    }
}
