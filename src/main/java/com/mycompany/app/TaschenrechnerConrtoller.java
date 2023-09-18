package com.mycompany.app;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;


@Controller()
public class TaschenrechnerConrtoller {
    private final TaschenrechnerService taschenrechnerService;
    @Autowired
    public TaschenrechnerConrtoller(TaschenrechnerService taschenrechnerService) {
        this.taschenrechnerService = taschenrechnerService;
    }


    @GetMapping("/")
    public String getNumber(Model model)
    {
      model.addAttribute("validMath", new ValidMath());
      return "index.html";
    }
    List<String> history = new ArrayList<String>();

    @PostMapping("/")
    public String ergebnis(@Valid ValidMath validMath, Model model, final BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            System.out.println("Validation errors: " + bindingResult.getAllErrors());
            return "index.html";
        }
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

    @RequestMapping("/guide")
    public String anleitung()
    {
        return "Anleitung.html";
    }
}