package rikkei.academy.view;

import rikkei.academy.config.Config;
import rikkei.academy.controller.UserController;
import rikkei.academy.dto.request.SignUpDTO;
import rikkei.academy.dto.response.ResponseMessage;
import rikkei.academy.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserView {
    UserController userController = new UserController();
    List<User> userList = userController.getListUser();
    public void formRegister() {
        System.out.println("size -->"+userList.size());
        int id = 0;
        if (userList.size() == 0) {
            id = 1;
        } else {
           id = userList.get(userList.size()-1).getId()+1;
        }
        System.out.println("id =---"+id);
        System.out.println("Enter the name: ");
        String name = Config.scanner().nextLine();
        System.out.println("Enter the username: ");
        String username = Config.scanner().nextLine();

        System.out.println("Enter the email: ");
        String email = Config.scanner().nextLine();
//        while (true){
//            SignUpDTO sign = new SignUpDTO();
//            sign.setUsername(email);
//            if(userController.register(sign).getMessage().equals("email_existed")){
//                System.err.println("username is existed! Please try again!");
//                email = Config.scanner().nextLine();
//            } else {
//                break;
//            }
//        }

        System.out.println("Enter the password: ");
        String password = Config.scanner().nextLine();
        System.out.println("Enter the role: ");
        String role = Config.scanner().nextLine();
        Set<String> strRole = new HashSet<>();
        strRole.add(role);
        SignUpDTO sign = new SignUpDTO(id,name,username,email,password,strRole);
        while (true){
            ResponseMessage responseMessage = userController.register(sign);
          if(responseMessage.getMessage().equals("user_existed")){
              System.err.println("user name existed!");
              username = Config.scanner().nextLine();
              sign.setUsername(username);
              System.out.println("duoi lenh nhap");
          } else if(responseMessage.getMessage().equals("email_existed")){
              System.err.println("email name existed!");
              email = Config.scanner().nextLine();
              sign = new SignUpDTO(id,name,username,email,password,strRole);
          } else if(responseMessage.getMessage().equals("create_success")){
              formLogin();
              break;
          }
        }


    }
    public  void formLogin(){
        System.out.println("Hàm Login!");
        System.out.println("Enter back to return Navbar: ");
        String back = Config.scanner().nextLine();
        if(back.equalsIgnoreCase("back")){
            new Navbar();
        }
    }
    public void showListUser(){
        System.out.println(userController.getListUser());
        System.out.println("Enter back to return Navbar: ");
        String back = Config.scanner().nextLine();
        if(back.equalsIgnoreCase("back")){
            new Navbar();
        }
    }
}
