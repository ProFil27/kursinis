package com.example.kursinis.consoleCourseWork;

import com.example.kursinis.model.User;

import java.io.*;

public class Utils {
    public static void writeUserToFile(User user) {
        ObjectOutputStream out = null;
        try(var file = new FileOutputStream("o.txt")) {
            out = new ObjectOutputStream(new BufferedOutputStream(file));
            out.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        }
//       ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(newFileInputStream("o.txt")));
//        Object o2 = in.readObject();
//        in.close();
    }

    public static Wolt getWoltFromFile() {
        ObjectInputStream in = null;
        Wolt wolt = null;
        try{
            in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("database.txt")));
            wolt = (Wolt) in.readObject();
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return wolt;
    }

    public static void writeWoltToFile(Wolt wolt){
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("database.txt")));
            out.writeObject(wolt);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
