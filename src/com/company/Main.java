package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> mass = new ArrayList<>();
        ArrayList<Integer> mass2 = new ArrayList<>();

        read(mass, mass2);
        write(mass, mass2);
        //System.out.println(Arrays.toString(newMass));
        // System.out.println(Arrays.toString(newMass2));

    }

    private static void read(ArrayList<String> mass, ArrayList<Integer> mass2) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\resurs\\utf.csv"), "cp1251"))) {
            Scanner scan = new Scanner(reader);
            scan.nextLine();
            int i = 0;
            while (scan.hasNextLine()) {
                String scanner = scan.nextLine();
                String[] temStringArray = scanner.split(";");
                mass.add(i, temStringArray[0]);
                mass2.add(i, Integer.parseInt(temStringArray[1]));
                i++;
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Успешно прочитано");
    }

    private static void write(ArrayList<String> mass, ArrayList<Integer> mass2 ) {
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\resurs\\utf2.csv"), "cp1251"));) {
            out.write("Наименование;цена\n");
            for (int i = 0; i < mass.size(); i++) {

                out.write(mass.get(i));
                out.write(";");
                out.write(mass2.get(i).toString());
                out.write('\n');
            }
            out.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        System.out.println("Успешно записанно");
    }

}
