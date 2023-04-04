package rikkei.academy.service;

import rikkei.academy.model.User;

public interface IUserService extends IGenericService<User>{
    boolean existedByUsername(String username);
    boolean existedByEmail(String email);
}
