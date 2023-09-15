package com.mycompany.app;

import javax.validation.constraints.Min;


import javax.validation.constraints.Size;


import jakarta.validation.constraints.NotEmpty;
import org.springframework.ui.Model;

import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

public class ValidMath {
    @NotEmpty
    private String mathValue;

    public String getMathValue()
    {
        return mathValue;
    }

    public void setMathValue(String mathValue)
    {
        this.mathValue = mathValue;
    }

}
