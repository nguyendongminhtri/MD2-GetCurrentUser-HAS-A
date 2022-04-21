package com.company.view;
import com.company.config.ConfigReadAndWriteFile;
import com.company.model.Role;
import com.company.model.RoleName;
import com.company.model.UserPrincipal;
import com.company.service.user_principal.UserPrincipalServiceIMPL;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    Scanner scanner = new Scanner(System.in);
    public Main() {
        System.out.println("===============================MY NAVBAR =======================================");
        List<UserPrincipal> userPrincipalList = UserPrincipalServiceIMPL.userPrincipalList;
        System.out.println("size == "+userPrincipalList.size());
        if(userPrincipalList.size() !=0){
            System.out.println("-------- CÓ LOGIN -----------");

            Set<Role> roleSet = userPrincipalList.get(0).getRoleSet();
            List<Role> roleList = new ArrayList<>(roleSet);
            if(roleList.get(0).getName()== RoleName.MANAGE){
                System.out.println("1. PROFILE");
                System.out.println("2. CATEGORY MANAGE");
                System.out.println("3. SHOW LIST USER");
                int chooseMenu2 = scanner.nextInt();
                switch (chooseMenu2){
                    case 1:
                        new ProfileView();
                        break;
                    case 2:
                        CategoryView.getInstance();
                        break;
                    case 3:
                        ListUserView.getInstance();
                        break;
                    default:
                        System.err.println("Không có chức năng này!");
                }
            } else {
                System.out.println("1. PROFILE");
                int chooseMenuUser = ConfigReadAndWriteFile.scanner().nextInt();
                switch (chooseMenuUser){
                    case 1:
                        new ProfileView();
                        break;
                    default:
                        System.err.println("Không có chức năng này");
                }
            }
        } else {
            System.out.println("1. REGISTER");
            System.out.println("2. LOGIN");
           int chooseMenu1 = scanner.nextInt();
            switch (chooseMenu1){
                case 1:
                        new RegisterView();
                        break;
                case 2:
                        new LoginView();
                        break;
                default:
                    System.err.println("Không có chức năng này!");
                    new Main();
            }
        }

     }

    public static void main(String[] args) {
        // write your code here
        new Main();
    }
}
