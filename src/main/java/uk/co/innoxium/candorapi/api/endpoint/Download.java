package uk.co.innoxium.candorapi.api.endpoint;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.co.innoxium.candorapi.Application;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@RestController
public class Download {

    @GetMapping(value = "/download/{name}/{version}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public @ResponseBody ResponseEntity<Resource> serveFile(@PathVariable String name, @PathVariable String version, HttpServletRequest request) {

        if(name.equalsIgnoreCase("candor") && version.equalsIgnoreCase("latest")) {

            try {

                if(Application.runPath == null || Application.runPath.isEmpty()) Application.runPath = Paths.get("").toAbsolutePath().normalize().toString();

                Path runDir = Paths.get(Application.runPath);
                File candorPath = new File(runDir.toString(), "files/CandorModManager.zip");

                System.out.println(runDir);
                System.out.println(candorPath);

                Resource resource = new FileSystemResource(candorPath);
                String contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
                if(Objects.isNull(contentType)) contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;

                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(contentType))
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                        .header(HttpHeaders.CONTENT_LENGTH, String.valueOf(resource.contentLength()))
                        .body(resource);
            } catch (IOException e) {

                e.printStackTrace();
                // TODO: Redirect to 404 page
                throw new DownloadException();
            }
        }
        throw new DownloadException();
    }
}

@ControllerAdvice
class DownloadAdvice {

    @ResponseBody
    @ExceptionHandler(DownloadException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    String updateNotFound(DownloadException e) {

        return e.getMessage();
    }
}

class DownloadException extends RuntimeException {

    public DownloadException() {
        super("An error occurred, either a bad request, or the file was not found");
    }
}
