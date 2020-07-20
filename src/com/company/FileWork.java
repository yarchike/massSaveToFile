package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileWork {

    public static ArrayList<Bankomat> read() {
        ArrayList<Bankomat> bank = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\resurs\\utf.csv"), "cp1251"))) {
            Scanner scan = new Scanner(reader);
            scan.nextLine();
            int i = 0;
            while (scan.hasNextLine()) {
                String scanner = scan.nextLine();
                String[] temStringArray = scanner.split(";");
                int schet = Integer.parseInt(temStringArray[0]);
                int nal = Integer.parseInt(temStringArray[1]);
                int pinCode = Integer.parseInt(temStringArray[2]);
                bank.add(new Bankomat(schet, nal, pinCode));
                i++;
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Успешно прочитано");
        return bank;
    }

    public static void write(ArrayList<Bankomat> mass ) {
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\resurs\\utf2.csv"), "cp1251"));) {
            out.write("Счет;Наличные;Пинкод\n");
            for (int i = 0; i < mass.size(); i++) {

                out.write(String.valueOf(mass.get(i).schet));
                out.write(";");
                out.write(String.valueOf(mass.get(i).nal));
                out.write(";");
                out.write(String.valueOf(mass.get(i).pinCode));

                out.write('\n');
            }
            out.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        System.out.println("Успешно записанно");
    }
}
