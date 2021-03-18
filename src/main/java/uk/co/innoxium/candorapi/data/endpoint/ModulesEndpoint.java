package uk.co.innoxium.candorapi.data.endpoint;

import com.vaadin.flow.server.connect.auth.AnonymousAllowed;
import lombok.Data;

//@Endpoint("modules")
@AnonymousAllowed
@Data
public class ModulesEndpoint {

//    public Modules modules = new Modules();
//
//    public Modules getModule() {
//        return modules;
//    }
//
//    public List<Module> getAllModules() {
//
//        return modules.getModules();
//    }

    @Data
    public static class Module {

        String moduleName;
        String filePath;
        String description;
        String iconPath;
    }
//
//    @Data
//    public class Modules {
//
//        LinkedList<Module> modules = new LinkedList<>();
//
//        public Modules() {
//
//            modules.add(new Module("Dragon Age: Origins", "./filePath", "This module enables support for Dragon Age: Origins", "./iconPath"));
//            modules.add(new Module("Baldur's Gate 3", "./filePath", "This module enables support for the Baldur's Gate 3 game", "./iconPath"));
//        }
//    }
}
