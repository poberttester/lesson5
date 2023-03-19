package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // 1
        TeleDirect directory = new TeleDirect();
        directory.controller();

        // 2
        ListOfEmployees list = new ListOfEmployees();
        list.m();

        //3.
        Chess ferz = new Chess();
        ferz.setFerz(0);

    }
}
