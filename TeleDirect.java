package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
//Добавить функции: 1) Добавление номера, 2) Вывод всего

public class TeleDirect {
    private HashMap<String, ArrayList> contact = new HashMap<>();
    private HashMap<String, ArrayList> temp;

    private int menu() throws IOException {
        System.out.println("Выберите одно из следующих действий:\n" +
                "1) Добавление номера\n" +
                "2) Вывод всего");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int value;
        value = Integer.parseInt(reader.readLine());

        if(value == 1) return value;
        else if(value == 2) return value;
        else return 0;
    }

    public void controller() throws IOException {
        int n = 0;

        do {
             n = menu();
            if (n == 1){
                temp = addNumber(contact);
                contact = temp;

            }
            else if(n == 2){
                showAll(contact);
            }
        }while (n != 0);

        System.out.println("Command not found");
    }

    private HashMap addNumber(HashMap<String, ArrayList> contact) throws IOException {
        this.contact = contact;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key, value;

        System.out.print("\nВведите имя: ");
        key = reader.readLine();
        System.out.print("\nВведите номер телефона: ");
        value = reader.readLine();

         if (contact.isEmpty()){
            contact.put(key, new ArrayList<String>(Arrays.asList(value)));
        }else if (contact.containsKey(key)){
            addSecondPhoneForContact(key, value);
        }
        else{
             addContact(key, value);
        }
        return contact;
    }

    private synchronized void addSecondPhoneForContact(String key, String value) {
        ArrayList<String> itemsList = contact.get(key);
            // add if item is not already in list
            if(!itemsList.contains(value)){
                itemsList.add(value);
                contact.put(key, itemsList);
            }
    }

    private void addContact(String key, String value){
        ArrayList<String> list = new ArrayList<>(Arrays.asList(value));
        contact.put(key, list);
    }

    private void showAll(HashMap contact){
        this.contact = contact;
        System.out.println(contact + "\n");
    }

}

