import '@polymer/iron-icon';
import '@vaadin/vaadin-ordered-layout';
import { customElement, html, LitElement } from 'lit-element';
import Swal from "sweetalert2";

@customElement('module')
export class CardListItem extends LitElement {
    createRenderRoot() {
        // Do not use a shadow root
        return this;
    }

    render() {
        return html`
      <vaadin-horizontal-layout theme="spacing-m" class="card">
        <img id="image" />
        <vaadin-vertical-layout>
          <vaadin-horizontal-layout theme="spacing-m" class="header">
            <span class="name" id="name"></span>
          </vaadin-horizontal-layout>
          <span class="post" id="description"></span>
          <vaadin-horizontal-layout theme="spacing-s" class="actions">
            <vaadin-button @click="${this.onClick1}">ClickMe!</vaadin-button>
          </vaadin-horizontal-layout>
        </vaadin-vertical-layout>
      </vaadin-horizontal-layout>
    `;
    }

    onClick1() {

        Swal.fire("Clicked", "You clicked me")
    }
}
