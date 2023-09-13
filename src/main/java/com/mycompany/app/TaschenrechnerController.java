package com.mycompany.app;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Controller()
public class TaschenrechnerController {

    @GetMapping("/hello")
    public String getnumber(Model model){
        return "main";


    }
}
