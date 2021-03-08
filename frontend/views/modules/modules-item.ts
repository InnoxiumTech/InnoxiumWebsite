import '@polymer/iron-icon';
import '@vaadin/vaadin-ordered-layout';
import {customElement, html, LitElement} from 'lit-element';

@customElement('modules-item')
export class ModulesItem extends LitElement {

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
          <span class="post" id="desc"></span>
          <vaadin-horizontal-layout theme="spacing-m" class="actions">
            <vaadin-button id="button">Download Module</vaadin-button>
          </vaadin-horizontal-layout>
        </vaadin-vertical-layout>
      </vaadin-horizontal-layout>
    `;
  }
}
