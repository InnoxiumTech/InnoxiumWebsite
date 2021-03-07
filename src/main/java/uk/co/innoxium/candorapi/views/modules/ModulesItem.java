package uk.co.innoxium.candorapi.views.modules;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.wontlost.sweetalert2.Config;
import com.wontlost.sweetalert2.SweetAlert2Vaadin;
import uk.co.innoxium.candorapi.data.endpoint.ModulesEndpoint;

/**
 * A Designer generated component for the person-form-view template.
 *
 * Designer will add and remove fields with @Id mappings but does not overwrite
 * or otherwise change this file.
 */
@JsModule("./views/modules/modules-item.ts")
@Tag("modules-item")
public class ModulesItem extends LitTemplate {

    @Id("image")
    private Image image;
    @Id("name")
    private Span name;
    @Id("desc")
    private Span desc;
    @Id("button")
    private Button button;

    public ModulesItem(ModulesEndpoint.Module module) {
        image.setSrc(module.getIconPath());
        name.setText(module.getModuleName());
        desc.setText(module.getDescription());

        button.addClickListener(event -> {

            Config config = new Config();
            config.setText("Your download will begin shortly!");
            config.setTitle("Download Beginning.");
            config.setIcon("success");
            SweetAlert2Vaadin swal = new SweetAlert2Vaadin(config);
            swal.addCloseListener(event1 -> navigateToModule(module, button));
            swal.addConfirmListener(event1 -> navigateToModule(module, button));
            swal.open();
            System.out.println(module.getFilePath());
        });
    }

    void navigateToModule(ModulesEndpoint.Module module, Button button) {

        button.getUI().ifPresent(ui -> {

            ui.navigate(module.getFilePath());
        });
    }
}
