package com.mycompany.app;

import static com.mycompany.app.App.berechnen;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class AppTest 
{
    @Test
    public void shouldAnswerWith20()
    {
        assertEquals(20, berechnen(40,2, 4),(0));
    }
}
