package org.mine.mmi;

import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/convert")
public class MainController {

    private final Conversion conversion;

    private static String message = new StringBuilder("The conversion API is case sensitive. Current conversions: ")
            .append('\n').append("Kilometers -> Miles")
            .append('\n').append("Meters -> Feet")
            .append('\n').append("Centimeters -> Inches")
            .append('\n').append("Liters -> Gallons")
            .append('\n').append("Grams -> Ounces")
            .append('\n').append("----------------------")
            .append('\n').append("Miles -> Kilometers")
            .append('\n').append("Feet -> Meters")
            .append('\n').append("Meters -> Feet")
            .append('\n').append("Inches -> Centimeters")
            .append('\n').append("Gallons -> Liters")
            .append('\n').append("Ounces -> Grams")
            .toString();

    @Autowired
    public MainController(Conversion conversion) {
        this.conversion = conversion;
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET
    )

    public ResponseEntity<String> convert(@RequestParam String from, @RequestParam String to, @RequestParam Double value){

        try {
            return new ResponseEntity<>( conversion.convert(new Pair<>(from, to), value), HttpStatus.OK);
        }catch (NoSuchElementException ex){
            return new ResponseEntity<>(MessageFormat.format("Conversion {0} to {1} cannot be found {2}", from, to, message), HttpStatus.BAD_REQUEST);
        }
    }
}
