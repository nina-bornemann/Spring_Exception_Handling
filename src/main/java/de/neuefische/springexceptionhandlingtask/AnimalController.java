package de.neuefische.springexceptionhandlingtask;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    @GetMapping("{species}")
    String getAnimalSpecies(@PathVariable String species) {
        if (!species.equals("dog")) {
            throw new IllegalArgumentException("Only 'dog' is allowed");
        }
        return species;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleIllegalArgumentException(IllegalArgumentException e) {
        return e.getMessage();
    }

    @GetMapping
    String getAllAnimals() {
        throw new NoSuchElementException("No Animals found");
    }
}
