package uk.co.innoxium.candorapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uk.co.innoxium.candorapi.api.data.Update;
import uk.co.innoxium.candorapi.api.endpoint.repo.UpdateRepository;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    public CommandLineRunner initDb(UpdateRepository repo) {

        System.out.println("Preloading updates");
        log.info("Preloading updates");
        return args -> repo.save(new Update("version", "filePath"));
    }
}
