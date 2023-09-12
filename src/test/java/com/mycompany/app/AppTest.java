package com.mycompany.app;

import static com.mycompany.app.App.berechnen;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class AppTest 
{
    @Test
    public void shouldAnswerWith20()
    {
        assertEquals(20, berechnen(40,2, 4),(0));
    }
    @Test
    public void Multiplikation()
    {
        assertEquals(4, App.berechnen(2, 2, 3), 0);
    }
    @Test
    public void Addition()
    {
        assertEquals(3, App.berechnen(1, 2, 1), 0);
    }
    @Test
    public void Division()
    {
        assertEquals(5, App.berechnen(10, 2, 4), 0);
    }
    @Test
    public void Subtraktion()
    {
        assertEquals(5, App.berechnen(9, 4, 2), 0);
    }
}
