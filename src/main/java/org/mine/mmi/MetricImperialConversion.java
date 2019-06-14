package org.mine.mmi;

import javafx.util.Pair;

/**
 * Conversion (Metric <--> Imperial)
 */
public interface MetricImperialConversion {


    /**
     * Makes conversion from one unit to another
     * @param key - Pair(unitFrom, unitTo)
     * @param value - Value that needs to be converted
     * @return the result of the conversion
     * @throws java.util.NoSuchElementException if the key is not found, conversion has not beed defined
     */
    String convert(Pair<String, String> key, Double value);
}
