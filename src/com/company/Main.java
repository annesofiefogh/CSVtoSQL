package com.company;

public class Main {

    public static void main(String[] args) {

        FileHandler fh = new FileHandler();
        System.out.println(fh.tableHeaders());

        fh.writeToDDL(fh.tableHeaders());
        fh.writeToDML(fh.tableFilling());
    }
}
