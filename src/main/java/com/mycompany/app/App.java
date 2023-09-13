package com.mycompany.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
@SpringBootApplication
public class App{
        public static void main(String[] args) {
            SpringApplication.run(App.class, args);
        }
    public static void nico()   {
        Scanner sc=new Scanner(System.in);

        String input;
        input = sc.nextLine();


        List<String> ziffern = Arrays.asList(input.split("[+|\\-|*|:]"));
        ArrayList<String> operator =  new ArrayList<>(Arrays.asList(input.split("\\d")));
        operator.remove(0);
        if (operator.get(0).equals("+")) {
            System.out.println(Integer.parseInt(ziffern.get(0)) + Integer.parseInt(ziffern.get(1)));
        }
        if (operator.get(0).equals("-")) {
            System.out.println(Integer.parseInt(ziffern.get(0)) * Integer.parseInt(ziffern.get(1)));
        }
        if (operator.get(0).equals("*")) {
            System.out.println(Integer.parseInt(ziffern.get(0)) * Integer.parseInt(ziffern.get(1)));
        }
        if (operator.get(0).equals("/")) {
            System.out.println(Integer.parseInt(ziffern.get(0)) * Integer.parseInt(ziffern.get(1)));
        }
    }
}

