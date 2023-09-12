package com.mycompany.app;

import java.util.Scanner;
import java.lang.String;
import java.text.DecimalFormat;


public class App {

    //Funktion zur berechnung von + - * /
    public static float berechnen(float a, float b, int art) {

        float ergebnis = 0;
        if (art == 1) {
            ergebnis = a + b;
        }
        if (art == 2) {
            ergebnis = a - b;
        }
        if (art == 3) {
            ergebnis = a * b;
        }
        if (art == 4) {
            ergebnis = a / b;
        }

        return ergebnis;
    }


    public static void main(String[] args) {
        //Anlegen Objekte für Einlesen und Formatierung des Erebnisses
        DecimalFormat df = new DecimalFormat("0.00");
        Scanner sc = new Scanner(System.in);

        //Soll das Programm beendet werden?
        boolean beenden = false;

        while (beenden == false) {
            int eingabe = 0;
            String zahlen = "";

            System.out.println("Werte mit operator eingaben:");
            zahlen = sc.next();
            if (zahlen.contains("+")) {
                eingabe = 1;
            } else if (zahlen.contains("-")) {
                eingabe = 2;
            } else if (zahlen.contains("*")) {
                eingabe = 3;
            } else if (zahlen.contains(":")) {
                eingabe = 4;
            } else {
                continue;
            }

            String[] result = zahlen.split("\\+|\\*|-|:");


            System.out.println(berechnen(Integer.valueOf(result[0]), Integer.valueOf(result[1]), eingabe));
            // }

            //Programm Beenden

            //Wenn eine Fehlerhafte Auswahl getroffen wurde
        }
    }
}