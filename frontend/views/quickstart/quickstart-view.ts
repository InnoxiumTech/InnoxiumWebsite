import '!style-loader!css-loader!./quickstart-view.css';
import { customElement, html } from 'lit-element';
import { View } from '../../views/view';

@customElement('quickstart-view')
export class QuickstartView extends View {
  render() {
    return html`<div>Content placeholder</div>`;
  }
}
