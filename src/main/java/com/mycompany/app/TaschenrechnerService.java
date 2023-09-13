package com.mycompany.app;

import org.springframework.stereotype.Service;

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
        String[] result = input.split("\\+|\\*|-|:");
        return result;
    }

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
}
