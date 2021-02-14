package ua.com.alevel.task3;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class App implements Serializable {
    public static void main(String[] args) throws IOException {
        UserMethods userMethods = new UserMethods();

        String userCommand = userMethods.readCommand();
        String userInfo = userMethods.readUserDate();
         if(userCommand.equals("create")){
             userMethods.serialize(userMethods.create(userInfo),
                     new File(userMethods.create(userInfo).getUserName().replace(" ", "_") + ".dat"));
         }
         else if(userCommand.equals("show")){
             System.out.println(userMethods.deserialization(userMethods.show(UserMethods.getUserName())));
         }
    }
}
