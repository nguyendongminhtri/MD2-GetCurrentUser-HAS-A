package com.company.service.user_principal;

import com.company.config.ConfigReadAndWriteFile;
import com.company.model.User;
import com.company.model.UserPrincipal;
import com.company.service.user.UserServiceIMPL;

import java.util.List;

public class UserPrincipalServiceIMPL implements IUserPrincipalService{
    public static String PATH_USER_PRINCIPAL = ConfigReadAndWriteFile.PATH + "user_principal.txt";
    public static List<UserPrincipal> userPrincipalList = new ConfigReadAndWriteFile<UserPrincipal>().readFromFile(PATH_USER_PRINCIPAL);
    UserServiceIMPL userServiceIMPL = new UserServiceIMPL();
    private static UserPrincipalServiceIMPL instance;
    public static UserPrincipalServiceIMPL getInstance(){
        if (instance==null){
            instance = new UserPrincipalServiceIMPL();
        }
        return instance;
    }
    @Override
    public List<UserPrincipal> findAll() {
        new ConfigReadAndWriteFile<UserPrincipal>().writeToFile(PATH_USER_PRINCIPAL,userPrincipalList);
        return userPrincipalList;
    }

    @Override
    public void save(UserPrincipal userPrincipal) {
        userPrincipalList.clear();
        userPrincipalList.add(userPrincipal);
    }

    @Override
    public UserPrincipal findById(int id) {
        return null;
    }

    @Override
    public User getCurrentUser() {
        if(userPrincipalList.size()!=0){
            User user = userServiceIMPL.findByUsername(userPrincipalList.get(0).getUsername());
            return user;
        }
        return null;
    }
}
