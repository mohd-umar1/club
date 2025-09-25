package org.example;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.example.util.authentication1;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.StreamSupport;

import static org.example.util.authentication1.verify;


public class user_get_club {

    public static void main(String[] args) throws IOException {


        Scanner sc = new Scanner(System.in);
        ObjectMapper mapper2 = new ObjectMapper();

        List<user> users;
        File user_data1 = new File("D:\\json\\app\\src\\main\\java\\org\\example\\users.json");
        users = mapper2.readValue(user_data1, new TypeReference<List<user>>() {
        });


        System.out.println("| Student Login |");

        System.out.println("Enter Name");
        String login_name = sc.nextLine();

        System.out.println("Enter password: ");
        String login_pass = sc.nextLine();

        Optional<user> logged_in_user = users.stream().filter(e -> e.getName().equalsIgnoreCase(login_name) && authentication1.verify(login_pass, e.getHash_pass())).findFirst();

        if(logged_in_user.isPresent()) {

            File data = new File("D:\\json\\app\\src\\main\\java\\org\\example\\clubs.json");
            List<club> clubs = new ArrayList<>();

            {
                try {
                    try {
                        clubs = mapper2.readValue(data, new TypeReference<List<club>>() {
                            @Override
                            public Type getType() {
                                return super.getType();
                            }
                        });
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } catch (RuntimeException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Information About Clubs");
            clubs.forEach(e -> {
                System.out.println("club name : " + e.getClubname() + "| Department:" + e.getDepartment() + "| Interview Date:" + e.getDate() + "| Google Form link: " + e.getForm());
            });

            System.out.println("please enter the name of club you want to join");
            String chosen_club = sc.nextLine();

            for (club match : clubs) {
                if (match.getClubname().equalsIgnoreCase(chosen_club)) {

                    String student_data = "D:\\json\\app\\src\\main\\java\\org\\example\\" + match.getClubname() + ".csv";

                    FileWriter student_info = new FileWriter(student_data, true);

                    CSVPrinter printer = new CSVPrinter(student_info, CSVFormat.EXCEL);

                    String name = logged_in_user.get().getName();
                    String department = logged_in_user.get().getDepartment();
                    String year = logged_in_user.get().getYear();
                    String email = logged_in_user.get().getEmail();
                    Long phone = logged_in_user.get().getPhone_num();

                    printer.printRecord(name, department, year, email, phone);
                    printer.close();
                }

                System.out.println("Applied successfully");
            }
        }
        else{
                System.out.println("Incorrect credentials");
            }

//        File user_data = new File("D:\\json\\app\\src\\main\\java\\org\\example\\users.json");
//        JsonNode node = null;
//        try {
//            node = mapper2.readTree(user_data);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//        ArrayNode arraynode = (ArrayNode) node;
//
//
//
//        for(club match: clubs){
//            if(match.getClubname().equalsIgnoreCase(chosen_club)){
//
//                String student_data= "D:\\json\\app\\src\\main\\java\\org\\example\\"+match.getClubname()+".csv";
//                FileWriter student_info = new FileWriter(student_data,true);
//                CSVPrinter printer= new CSVPrinter(student_info, CSVFormat.EXCEL);
//
//
//                for(JsonNode elements :arraynode){
//
//                    String name = elements.get("name").asText();
//                    String department = elements.get("department").asText();
//                    String year = elements.get("year").asText();
//                    String email = elements.get("email").asText();
//                    Long phone =elements.get("phone_num").asLong();
//
//                    printer.printRecord(name,department,year,email,phone);
//                }
//                printer.close();
//
//                System.out.println("Applied sucessfully");
//            }
//        }


    }
}
