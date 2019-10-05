package com.synisys.data.bulkData;

import com.synisys.data.UserData;
import com.synisys.entities.User;

public class BulkUserData implements UserData {
    private User[] users;

    public BulkUserData(String[] names, String[] surnames, String[] emails, String password[] ) {
        users = new User[emails.length];
        for (int i = 0; i < emails.length; i++) {
            User newUser = new User(names[i], surnames[i], emails[i], password[i]);
            users[i]= newUser;
        }
    }

    public User[] getUsers() {
        return users;
    }
}
