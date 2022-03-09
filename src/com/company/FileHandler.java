package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    //Creating the table (ddl.sql)
    public String tableHeaders() {
        File file = new File("data/imdb-data.csv");
        String tableString = "CREATE TABLE imdb\n";

        try {
            Scanner sc = new Scanner(file);
            String line = sc.nextLine();
            String[] info = line.split(";");

            //Adding 'varchar (255)' to the header in the table on seperate lines
            for (int i = 0; i < info.length; i++) {
                if (i == info.length-1){
                    tableString += info[i] + " varchar (255)";
                } else {
                    tableString += info[i] + " varchar (255),\n";
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return tableString;
    }

    public void writeToDDL(String ts){
        try{
            FileWriter fw = new FileWriter("data/ddl.sql");
            fw.write(ts);
            fw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    //Info inside the table (dml.sql)
    public String tableFilling() {
        File file = new File("data/imdb-data.csv");
        String fillString = "INSERT INTO imdb\n";

        try {
            Scanner sc = new Scanner(file);
            sc.nextLine();
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] info = line.split(";");

                for (String s : info) {
                    fillString += s + ",\n";
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fillString.substring(0, fillString.length()-2);
    }

    public void writeToDML(String fs){
        try{
            FileWriter fw = new FileWriter("data/dml.sql");
            fw.write(fs);
            fw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
