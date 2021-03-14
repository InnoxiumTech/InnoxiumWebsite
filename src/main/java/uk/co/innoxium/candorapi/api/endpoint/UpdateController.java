package uk.co.innoxium.candorapi.api.endpoint;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uk.co.innoxium.candorapi.api.data.Update;
import uk.co.innoxium.candorapi.api.endpoint.repo.UpdateRepository;

import java.util.List;

@RestController
@AllArgsConstructor
public class UpdateController {

    private final UpdateRepository repo;

    @GetMapping("/api/updates")
    public @ResponseBody List<Update> getUpdates() {

        return repo.findAll();
    }

    @GetMapping("/api/updates/{id}")
    public @ResponseBody Update getUpdate(@PathVariable Long id) {

        return repo.findById(id).orElseThrow(() -> new UpdateNotFoundException(id));
    }
}

@ControllerAdvice
class UpdateNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(UpdateNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String updateNotFound(UpdateNotFoundException e) {

        return e.getMessage();
    }
}
