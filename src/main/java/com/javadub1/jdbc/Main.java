package com.javadub1.jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        StudentDao dao = new StudentDao();
        Scanner scanner = new Scanner(System.in);

        boolean isWorking = true;

        do {
            String komenda = scanner.nextLine();

            if (komenda.equalsIgnoreCase("dodaj")) {

                Student nowyStudent = new Student();

                System.out.printf("Podaj imię");
                nowyStudent.setName(scanner.nextLine());

                System.out.printf("Podaj indeks");
                nowyStudent.setIndeks(scanner.nextLine());

                System.out.printf("Podaj wiek");
                nowyStudent.setAge(Integer.parseInt(scanner.nextLine()));

                dao.insertStudent(nowyStudent);

                //umieszcza nowo stworzonego studenta w bazie



            } else if (komenda.equalsIgnoreCase("usun")) {

                System.out.printf("Podaj identyfikator do usunięcia");

                dao.deleteStudent(Long.parseLong(scanner.nextLine()));
                //1. stowryzc mkomende sql uwuajaca rekord po indeksie id, w miejsce id wstawiamy ?
                //2. metoda w dao
                //3. w metodzie prepred statement stworzony z zapytania (stalej finalnej stworzonej w pkt 1
                //4. ustawienie wartosci id  (wewnatrz try)
                //5. wykonanie
                //6. wzoruj sie na przykladzie INSERT



            } else if (komenda.equalsIgnoreCase("listuj")) {
                dao.getAllStudents().forEach(System.out::println);

            } else if (komenda.equalsIgnoreCase("quit")) {
                isWorking = false;
            }


        } while (isWorking);


    }
}

