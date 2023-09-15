package com.mycompany.app;

import org.hibernate.validator.constraints.NotEmpty;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@Service
public class TaschenrechnerService {

    public static int calc(String line) {
        if (line.contains("+")) {
            return 1;
        } else if (line.contains("-")) {
            return 2;
        } else if (line.contains("*")) {
            return 3;
        } else if (line.contains(":")) {
            return 4;
        }
        return 1;
    }

    public static String[] cutstr(String input) {
        @NotNull
        String[] result;
        result = input.split("\\+|\\*|-|:");
        return result;
    }

    public static float berechnen(String zahlen[], int art) {

        for(int i = 0; i<zahlen.length; i++)
        {
            if(zahlen[i].equals(""))
            {
                zahlen[i] = "0";
            }
        }



        float ergebnis = Float.valueOf(zahlen[0]);
        if (art == 1) {
            for(int i = 1; i < zahlen.length; i++)
            {
                ergebnis += Float.valueOf(zahlen[i]);
            }
        }
        if (art == 2) {
            for(int i = 1; i < zahlen.length; i++)
            {
                ergebnis -= Float.valueOf(zahlen[i]);
            }
        }
        if (art == 3) {
            for(int i = 1; i < zahlen.length; i++)
            {
                ergebnis *= Float.valueOf(zahlen[i]);
            }
        }
        if (art == 4) {
            for(int i = 1; i < zahlen.length; i++)
            {
                ergebnis -= Float.valueOf(zahlen[i]);
            }
        }

        return ergebnis;
    }
}
