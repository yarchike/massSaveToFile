package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] mass = new String[]{"Молока", "Коффе", "Картошка"};
        Integer[] mass2 = new Integer[]{25, 27, 30};
        String[] newMass = new String[mass.length];
        Integer[] newMass2 = new Integer[mass2.length];
        write(mass, mass2);
        read(newMass, newMass2);
        System.out.println(Arrays.toString(newMass));
        System.out.println(Arrays.toString(newMass2));

    }

    private static void read(String[] newMass, Integer[] newMass2) {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\resurs\\utf.csv"))) {
            Scanner scan = new Scanner(reader);
            scan.nextLine();
            int i = 0;
            while (scan.hasNextLine()) {
                String scanner = scan.nextLine();
                String[] temStringArray = scanner.split(";");
                newMass[i] = temStringArray[0];
                newMass2[i] = Integer.parseInt(temStringArray[1]);
                i++;
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void write(String[] mass, Integer[] mass2) {
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\resurs\\utf.csv"), "cp1251"));) {
            out.write("Наименование;цена\n");
            for (int i = 0; i < mass.length; i++) {

                out.write(mass[i]);
                out.write(";");
                out.write(mass2[i].toString());
                out.write('\n');
            }
            out.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}
