package uk.co.innoxium.candorapi.api.endpoint;

public class UpdateNotFoundException extends RuntimeException {

    public UpdateNotFoundException(Long id) {
        super("Unable to find update version " + id);
    }
}
