package uk.co.innoxium.candorapi;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.vaadin.artur.helpers.LaunchUtil;
import uk.co.innoxium.candorapi.api.data.Update;
import uk.co.innoxium.candorapi.api.endpoint.repo.UpdateRepository;

/**
 * The entry point of the Spring Boot application.
 *
 * Use the * and some desktop browsers.
 *
 */
@SpringBootApplication(scanBasePackages = { "uk.co.innoxium.candorapi.api.endpoint", "uk.co.innoxium.candorapi" })
@Theme(themeClass = Lumo.class, variant = Lumo.DARK)
@PWA(name = "InnoxiumTech", shortName = "InnoxiumTech", offlineResources = {"images/logo.svg", "icons/favicon.ico"}, iconPath = "icons/favicon.ico")
public class Application extends SpringBootServletInitializer implements AppShellConfigurator, CommandLineRunner {

    public static final String[] BASE_PACKAGES = new String [] {
            "uk.co.innoxium.candorapi.api.endpoint",
            "uk.co.innoxium.candorapi"
    };

    Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private UpdateRepository repo;

    public static void main(String[] args) {
        System.setProperty("spring.jackson.serialization.INDENT_OUTPUT", "true");
        LaunchUtil.launchBrowserInDevelopmentMode(SpringApplication.run(Application.class, args));
    }

    @Override
    public void run(String... args) throws Exception {

        // This is where we will likely load our db entries from

        repo.save(new Update("aVersion", "aFilePath"));

        repo.findAll().forEach((update) -> {
            logger.info("{}", update);
        });
    }
}
