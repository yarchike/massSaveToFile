package com.company;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        ArrayList<Bankomat> bank = new ArrayList<>();

        Bankomat sberbank = new Bankomat(123,100500,1111);
        Bankomat alfa = new Bankomat(250,100,1114);
        Bankomat vtb = new Bankomat(1254,500,1222);

        bank.add(sberbank);
        bank.add(alfa);
        bank.add(vtb);
        FileWork.write(bank);






    }



}
