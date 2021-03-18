import '!style-loader!css-loader!./home-view.css';
import '@vaadin/vaadin-button';
import '@vaadin/vaadin-text-field';
import { customElement, html } from 'lit-element';
import { View } from '../../views/view';
// @ts-ignore
import Swal from 'sweetalert2';
// @ts-ignore
import {Router} from "@vaadin/router";

@customElement('home-view')
export class HomeView extends View {
  name: string = '';

  render() {
    return html`
      <vaadin-vertical-layout>
        <div id="centered">
          <h1>
            This website is still under construction.
          </h1>
          <span>
            For now you can download candor by clicking the button below.
          </span>
          </br>
          <span>
            Modules for candor will be available on the relevant <a href="https://nexusmods.com/">Nexus Mods</a> pages.
          </span>
          <br>
          <vaadin-button @click="${this.downloadCandor}">Download Candor</vaadin-button>
        </div>
      </vaadin-vertical-layout>
    `;
  }

  downloadCandor() {
    Swal.fire("download", "Candor will download shortly.", "success").then(() => {

      //
      window.location.href = window.location.href + "download/candor/latest";
      // window.open(window.location.href + "/download/candor/latest", "", "", true);
      // Router.go("download/candor/latest")
    });
  }
}
