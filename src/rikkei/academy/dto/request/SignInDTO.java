package rikkei.academy.dto.request;

import rikkei.academy.model.Role;

import java.util.Set;

public class SignInDTO {
    private String userName;
    private String password;


    public SignInDTO() {
    }

    public SignInDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }





    @Override
    public String toString() {
        return "SignInDTO{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
