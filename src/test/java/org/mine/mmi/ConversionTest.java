package org.mine.mmi;

import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

public class ConversionTest {

    private Conversion conversion = new Conversion();

    @Test
    public void get_kilo_miles(){

        String result = conversion.convert(new Pair<>("Kilometers", "Miles"), new Double(40));
        Assert.assertEquals("24.854840", result);

        result = conversion.convert(new Pair<>("Miles", "Kilometers"), new Double("24.8548400"));
        Assert.assertEquals("39.999889", result);
    }

    @Test(expected = NoSuchElementException.class)
    public void get_meters_miles(){

        String result = conversion.convert(new Pair<>("Meters", "Miles"), new Double(40));
    }
}
