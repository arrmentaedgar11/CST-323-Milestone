package com.gcu.milestone.Models;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private List<UserModel> Users = new ArrayList<UserModel>();

   // Getter and Setter
    public List<UserModel> getUsers(){
        return this.Users;
    }

    public void setUsers(List<UserModel> Users){
        this.Users = Users;
    }
}
