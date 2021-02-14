package ua.com.alevel.task3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class UserMethods {

    public static String  readCommand(){
        System.out.println("Enter the command");
        String info = "";
        Scanner scanner = new Scanner(System.in);
        info = scanner.nextLine();
        return info;
    }
    public static String readUserDate(){
        System.out.println("Enter user's info");
        String info = "";
        Scanner scanner = new Scanner(System.in);
        info = scanner.nextLine();
        return info;
    }

    User create (String info){
        //user=”User Name”

        String name = info.substring( 0, info.indexOf(","));
        String mail = info.substring(info.indexOf(",") + 1, info.lastIndexOf(","));
        String phone = info.substring(info.lastIndexOf(",")+1);


        name.replaceAll("", "_");
        name.toUpperCase(Locale.ROOT);
        String resultName = name.substring(info.indexOf('"')+1, info.lastIndexOf('"'));
        if(!mail.contains("@")){
            throw new RuntimeException("Mail's not correctly written");
        }
        User user = new User(resultName,mail,phone);
        System.out.println(user.toString());
        return user;
    }
    static void serialize(Object obj, File file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(obj);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Object deserialization(File file) throws IOException {
        Object currentUser = new Object();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            currentUser = ois.readObject();
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return currentUser;
    }



    public static File show(String name) throws IOException {
        String result = "USER".concat("_").concat(name.trim().toUpperCase(Locale.ROOT));
        File file = new File(result + ".dat");
        return file;
    }
    public static String getUserName(){
        System.out.println("Enter user's name");
        String info = "";
        Scanner scanner = new Scanner(System.in);
        info = scanner.nextLine();
        return info;
    }
}
