package one.digitalinnovation.heroesapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class heroNotFoundException extends Exception {
    public heroNotFoundException(Long id) {
        super("Hero not found with ID " + id);
    }
}
