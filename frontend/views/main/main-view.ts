import { CSSModule } from '@vaadin/flow-frontend/css-utils';
import '@vaadin/vaadin-app-layout';
import '@vaadin/vaadin-avatar/vaadin-avatar';
import '@vaadin/vaadin-tabs';
import '@vaadin/vaadin-tabs/vaadin-tab';
import { customElement, html } from 'lit-element';
import { router } from '../../index';
// @ts-ignore
import {serverSideRoutes, ViewRoute, views} from '../../routes';
import { appStore } from '../../store/app-store';
import { Layout } from '../view';
import styles from './main-view.css';
import {AppLayoutElement} from "@vaadin/vaadin-app-layout";

@customElement('main-view')
export class MainView extends Layout {
  static get styles() {
    return [CSSModule('lumo-typography'), CSSModule('lumo-color'), CSSModule('app-layout'), styles];
  }

  render() {
    return html`
      <vaadin-app-layout id="layout">
        <div id="topbar" slot="navbar" theme="dark">
          <header slot="navbar">
            <a href="${router.urlForPath("")}">
              <img id="logo" src="images/logo.svg" alt="${appStore.applicationName} logo" />
            </a>
            <a href="${router.urlForPath("")}">
              <h1>${appStore.applicationName}</h1>
            </a>
          </header>
          <vaadin-tabs slot="navbar" id="tabs" .selected="${this.getSelectedViewRoute()}">
            ${this.getMenuRoutes().map(
              (viewRoute) => html`
                <vaadin-tab>
                  <a href="${router.urlForPath(viewRoute.path)}" tabindex="-1">${viewRoute.title}</a>
                </vaadin-tab>
              `
            )}
            <vaadin-tab @click="${this.downloadCandor}">
              <a>Download</a>
            </vaadin-tab>
          </vaadin-tabs>
        </div>
        <slot></slot>
      </vaadin-app-layout>
    `;
  }

  downloadCandor() {

    window.location.href = window.location.href + "download/candor/latest";
  }

  connectedCallback() {
    super.connectedCallback();

    this.reaction(
        () => appStore.location,
        () => {
          AppLayoutElement.dispatchCloseOverlayDrawerEvent();
        }
    );
  }

  private getMenuRoutes(): ViewRoute[] {
    // Only routes that have a title will be rendered
    // @ts-ignore
    return views.filter((route) => route.title);
  }

  private getSelectedViewRoute(): number {

    let num = this.getMenuRoutes().findIndex((viewRoute) => viewRoute.path == appStore.location);
    console.log(num)
    if(num == -1) num = views.length + 1
    return num
  }
}
