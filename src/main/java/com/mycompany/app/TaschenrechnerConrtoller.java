package com.mycompany.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller()
public class TaschenrechnerConrtoller {
    private final TaschenrechnerService taschenrechnerService;
    @Autowired
    public TaschenrechnerConrtoller(TaschenrechnerService taschenrechnerService) {
        this.taschenrechnerService = taschenrechnerService;
    }

    @GetMapping("/home")
    public String getNumber(Model model)
    {

        String a = "1";
        String b = "1";
        int ergebnis = 2;
        model.addAttribute("key", a);
        model.addAttribute("key1", b);

        ergebnis = Integer.valueOf(a) + Integer.valueOf(b);

        return "index.html";

    }

    @RequestMapping(value = "/berechnen")
    public String ergebnis(@RequestParam("value") String value, Model model)
    {
        float ergebnis = 0;
        int calcLog = taschenrechnerService.calc(value);
        String[] result = taschenrechnerService.cutstr(value);
        ergebnis = taschenrechnerService.berechnen(Float.valueOf(result[0]), Float.valueOf(result[1]), calcLog);

        model.addAttribute("ergebnis", String.valueOf(ergebnis));
        return "index.html";
    }



}
