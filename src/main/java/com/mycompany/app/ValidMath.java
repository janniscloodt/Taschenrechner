package com.mycompany.app;

import org.springframework.ui.Model;

import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

public class ValidMath {
    @Pattern(regexp = "[0-9][0-9]*",
            message = "Please enter al least one number!")
    private String mathValue;
    List<String> history = new ArrayList<String>();

    public String ergebnis(String value, Model model, TaschenrechnerService taschenrechnerService)
    {
        String math = value;
        float ergebnis = 0;
        int calcLog = taschenrechnerService.calc(value);
        String[] result = taschenrechnerService.cutstr(value);
        ergebnis = taschenrechnerService.berechnen(result, calcLog);

        history.add(0,math + " = " + String.valueOf(ergebnis));
        if(history.size() > 7)
            history.remove(history.size() - 1);

        //connect history
        model.addAttribute("history", history);
        return "index.html";
    }
    public String getMathValue()
    {
        return mathValue;
    }

    public void setMathValue(String mathValue)
    {
        this.mathValue = mathValue;
    }

}
