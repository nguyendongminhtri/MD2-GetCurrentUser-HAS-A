package com.company.service.role;

import com.company.config.ConfigReadAndWriteFile;
import com.company.model.Role;
import com.company.model.RoleName;

import java.util.List;

public class RoleServiceIMPL implements IRoleService{
    private static RoleServiceIMPL instance;
    public static RoleServiceIMPL getInstance(){
        if(instance==null){
            instance = new RoleServiceIMPL();
        }
        return instance;
    }
    public static String PATH_ROLE = ConfigReadAndWriteFile.PATH+"role.txt";
    public static List<Role> roleList = new ConfigReadAndWriteFile<Role>().readFromFile(PATH_ROLE);
    @Override
    public List<Role> findAll() {
        if(roleList.size()>=2){
            return roleList;
        } else {
            roleList.add(new Role(1,RoleName.USER));
            roleList.add(new Role(2,RoleName.MANAGE));
        }
        new ConfigReadAndWriteFile<Role>().writeToFile(PATH_ROLE,roleList);
        return roleList;
    }

    @Override
    public void save(Role role) {
            roleList.add(role);
    }

    @Override
    public Role findById(int id) {
        return null;
    }

    @Override
    public Role findByName(RoleName name) {
        for (int i = 0; i < roleList.size(); i++) {
            if(name==roleList.get(i).getName()){
                return roleList.get(i);
            }
        }
        return null;
    }
}
