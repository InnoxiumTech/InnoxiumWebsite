import { Route } from '@vaadin/router';
import { Flow } from '@vaadin/flow-frontend/Flow';
import './views/home/home-view';
import './views/main/main-view';

export type ViewRoute = Route & { title?: string; children?: ViewRoute[] };

export const {serverSideRoutes} = new Flow({
  imports: () => import('../target/frontend/generated-flow-imports')
});

export const views: ViewRoute[] = [
  // for client-side, place routes below (more info https://vaadin.com/docs/v18/flow/typescript/creating-routes.html)
  {
    path: '',
    component: 'home-view',
    title: 'Home',
  },
  {
    path: 'home',
    component: 'home-view',
  },
  {
    path: 'candor',
    component: 'candor-manager-view',
    title: 'Candor Manager',
    action: async () => {
      await import('./views/candormanager/candor-manager-view');
    },
  },
  {
    path: 'quickstart',
    component: 'quickstart-view',
    title: 'Quickstart',
    action: async () => {
      await import('./views/quickstart/quickstart-view');
    },
  },
];
export const routes: ViewRoute[] = [
  {
    path: '',
    component: 'main-view',
    children: [
        ...views,
      ...serverSideRoutes
    ],
  },
];
