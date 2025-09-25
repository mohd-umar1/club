package org.example;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class registration {
    public static void main(String[] args) {


        ObjectMapper mapper1 = new ObjectMapper();
        List<user> users = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("|      User Registration     |");

        System.out.println("Enter your name");
        String user_name = sc.nextLine();

        System.out.println("please enter your password");
        String user_pass = sc.nextLine();

        System.out.println("Enter your department");
        String user_dpt = sc.nextLine();

        System.out.println("Enter your year");
        String user_year = sc.nextLine();

        System.out.println("Enter your Email");
        String user_email = sc.nextLine();

        System.out.println("Enter your phone number");
        Long user_phone = sc.nextLong();
        sc.nextLine();
        try {
            File user_list = new File("D:\\json\\app\\src\\main\\java\\org\\example\\users.json");
            if (user_list.length()==0) {
                try {
                    users.add(new user(user_name,user_pass,user_dpt, user_year, user_email, user_phone));
                    mapper1.writerWithDefaultPrettyPrinter().writeValue(user_list, users);
                    {
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
            else{
                users = mapper1.readValue(user_list,new TypeReference<List<user>>() {
                });
                users.add(new user(user_name,user_pass,user_dpt, user_year, user_email, user_phone));
                mapper1.writerWithDefaultPrettyPrinter().writeValue(user_list,users);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

