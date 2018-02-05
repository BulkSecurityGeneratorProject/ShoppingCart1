import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { ProductComponent } from './product.component';
import { ProductAddToCartPopupComponent } from './product-addtocart-dialog.component';

export const productRoute: Routes = [
    {
        path: 'shopproduct',
        component: ProductComponent,
        data: {
            authorities: [],
            pageTitle: 'Products'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const productPopupRoute: Routes = [
    {
        path: 'product/:id/addtocart',
        component: ProductAddToCartPopupComponent,
        data: {
            authorities: [],
            pageTitle: 'Products'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
