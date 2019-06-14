package org.mine.mmi;

import javafx.util.Pair;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class Conversion implements MetricImperialConversion{

    private Map<Pair<String, String>, Double> ratio = new HashMap<>();
    {
        ratio.put(new Pair<>("Kilometers", "Miles"), 0.621371);
        ratio.put(new Pair<>("Meters", "Feet"), 3.28);
        ratio.put(new Pair<>("Centimeters", "Inches"), 0.39);
        ratio.put(new Pair<>("Liters", "Gallons"), 0.264);
        ratio.put(new Pair<>("Grams", "Ounces"), 0.035);

        ratio.put(new Pair<>("Miles", "Kilometers"), 1.60934 );
        ratio.put(new Pair<>("Feet", "Meters" ), 0.30);
        ratio.put(new Pair<>("Inches", "Centimeters" ), 0.0254);
        ratio.put(new Pair<>("Gallons", "Liters" ), 3.785);
        ratio.put(new Pair<>("Ounces", "Grams" ), 28.35);

    }

    @Override
    public String convert(Pair<String, String> key, Double value){

        if(ratio.containsKey(key)) {
            return BigDecimal.valueOf(ratio.get(key))
                    .multiply(BigDecimal.valueOf(value))
                    .setScale(6, BigDecimal.ROUND_CEILING)
                    .toPlainString();
        }

        throw new NoSuchElementException("Conversion does not exits");
    }
}
