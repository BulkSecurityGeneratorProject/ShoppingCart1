import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { CartComponent } from './cart.component';
import { CartDetailComponent } from './cart-detail.component';
import { CartPopupComponent } from './cart-dialog.component';
import { CartDeletePopupComponent } from './cart-delete-dialog.component';

export const cartRoute: Routes = [
    {
        path: 'cart',
        component: CartComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Carts'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'cart/:id',
        component: CartDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Carts'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const cartPopupRoute: Routes = [
    {
        path: 'cart-new',
        component: CartPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Carts'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'cart/:id/edit',
        component: CartPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Carts'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'cart/:id/delete',
        component: CartDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Carts'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
