package rikkei.academy.controller;

import rikkei.academy.dto.request.SignUpDTO;
import rikkei.academy.dto.response.ResponseMessage;
import rikkei.academy.model.Role;
import rikkei.academy.model.RoleName;
import rikkei.academy.model.User;
import rikkei.academy.service.IRoleService;
import rikkei.academy.service.IUserService;
import rikkei.academy.service.RoleServiceIMPL;
import rikkei.academy.service.UserServiceIMPL;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserController {
    private IUserService userService = new UserServiceIMPL();
    private IRoleService roleService = new RoleServiceIMPL();
    public ResponseMessage register(SignUpDTO sign){
        if(userService.existedByUsername(sign.getUsername())){
            return new ResponseMessage("user_existed");
        }
        if(userService.existedByEmail(sign.getEmail())){
            return new ResponseMessage("email_existed");
        }
        Set<String> strRole = sign.getStrRole();
        Set<Role> roleSet = new HashSet<>();
        strRole.forEach(role->{
            switch (role){
                case "admin":
                    roleSet.add(roleService.findByName(RoleName.ADMIN));
                    break;
                case "pm":
                    roleSet.add(roleService.findByName(RoleName.PM));
                    break;
                default:
                    roleSet.add(roleService.findByName(RoleName.USER));
            }
        });
        User user = new User(sign.getId(), sign.getName(), sign.getUsername(), sign.getEmail(), sign.getPassword(), roleSet);
        userService.save(user);
        return new ResponseMessage("create_success");
    }
    public List<User> getListUser(){
        return userService.findAll();
    }
}
