package com.mycompany.app;
import java.util.Scanner;
import java.lang.String;
import java.text.DecimalFormat;


public class App 
{

    //Funktion zur berechnung von + - * /
    public static float berechnen(float a, float b, int art)
    {

        float ergebnis = 0;
        if(art == 1)
        {
            ergebnis = a+b;
        }
        if(art == 2)
        {
            ergebnis = a-b;
        }
        if(art == 3)
        {
            ergebnis = a*b;
        }
        if(art == 4)
        {
            ergebnis = a/b;
        }

        return ergebnis;
    }


    public static void main( String[] args )
    {
        //Anlegen Objekte für Einlesen und Formatierung des Erebnisses
        DecimalFormat df = new DecimalFormat("0.00");
        Scanner sc = new Scanner(System.in);

        //Soll das Programm beendet werden?
        boolean beenden = false;

        while(beenden == false)
        {
            int eingabe = 0;

            //Was soll Berechnet werden?
            System.out.println("Addition.................1");
            System.out.println("Subtraktion..............2");
            System.out.println("Miltiplikation...........3");
            System.out.println("Division.................4");
            System.out.println("Beenden..................5");
            System.out.println("Was wollen Sie berechnen?: ");
            eingabe = Integer.valueOf(sc.next());

            //Überprüfung auf korrekte Eingabe
            if(eingabe > 0 && eingabe < 6)
            {
                float a = 0;
                float b = 0;

                System.out.println("Geben Sie ihre erste Zahl ein!: ");
                a = Float.valueOf(sc.next());

                System.out.println("Geben Sie ihre zweite Zahl ein!: ");
                b = Float.valueOf(sc.next());

                System.out.println("Ergebnis: " + df.format(berechnen(a, b, eingabe)));
            }

            //Programm Beenden
            else if(eingabe == 5)
            {
                beenden = true;
            }

            //Wenn eine Fehlerhafte Auswahl getroffen wurde
            else {
                System.out.println("ERROR");
            }
        }
    }
}
