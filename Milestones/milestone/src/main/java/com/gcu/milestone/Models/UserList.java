package com.gcu.milestone.Models;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private List<UserModel> Users = new ArrayList<UserModel>();

   //XmlElement(name="User")
    public List<UserModel> getUsers(){
        return this.Users;
    }

    public void setUsers(List<UserModel> Users){
        this.Users = Users;
    }
}
