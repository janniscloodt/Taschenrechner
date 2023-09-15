package com.mycompany.app;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Controller()
public class TaschenrechnerConrtoller {
    private final TaschenrechnerService taschenrechnerService;
    @Autowired
    public TaschenrechnerConrtoller(TaschenrechnerService taschenrechnerService) {
        this.taschenrechnerService = taschenrechnerService;
    }

    @GetMapping("/")
    public String getNumber(ValidMath validMath)
    {
        return "index.html";

    }
    List <String> history = new ArrayList<String>();
    @PostMapping(value = "/")
    public String ergebnis(@Valid ValidMath validMath, Model model)
    {
            String math = validMath.getMathValue();
            float ergebnis = 0;
            int calcLog = taschenrechnerService.calc(validMath.getMathValue());
            String[] result = taschenrechnerService.cutstr(validMath.getMathValue());
            ergebnis = taschenrechnerService.berechnen(result, calcLog);

            history.add(0,math + " = " + String.valueOf(ergebnis));
            if(history.size() > 7)
                history.remove(history.size() - 1);

        //connect history
        model.addAttribute("history", history);
        return "index.html";
    }
}
