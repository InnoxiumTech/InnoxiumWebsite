package uk.co.innoxium.candorapi.views.modules;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import uk.co.innoxium.candorapi.data.endpoint.ModulesEndpoint;

import java.util.Arrays;
import java.util.List;

/**
 * A Designer generated component for the person-form-view template.
 *
 * Designer will add and remove fields with @Id mappings but does not overwrite
 * or otherwise change this file.
 */
@JsModule("./views/modules/modules-view.ts")
@CssImport("./views/modules/modules-view.css")
@Tag("modules-view")
//@Route(value = "modules")
@PageTitle("Modules")
public class ModulesView extends LitTemplate implements AfterNavigationObserver {

    @Id("grid")
    private Grid<ModulesEndpoint.Module> grid;

    public ModulesView() {
        grid.addComponentColumn(ModulesItem::new);
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {

        // Set some data when this view is displayed.
        List<ModulesEndpoint.Module> persons = Arrays.asList( //

            addModule("./imagePath", "Baldur's Gate 3", "This module adds support for Baldur's Gate 3", "./someFile.bin"),
            addModule("./imagePath", "Dragon Age: Origins", "This module adds support for Dragon Age: Origins", "./someFile.bin")
        );
        grid.setItems(persons);
    }

    private static ModulesEndpoint.Module addModule(String image, String name, String desc, String filePath) {
        ModulesEndpoint.Module m = new ModulesEndpoint.Module();

        m.setModuleName(name);
        m.setDescription(desc);
        m.setIconPath(image);
        m.setFilePath(filePath);

        return m;
    }


}
