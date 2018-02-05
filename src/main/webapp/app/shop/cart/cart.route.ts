import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil } from 'ng-jhipster';

import { UserRouteAccessService } from '../../shared';
import { CartComponent } from './cart.component';
import { CartDeletePopupComponent } from './cart-delete-dialog.component';

@Injectable()
export class CartResolvePagingParams implements Resolve<any> {

    constructor(private paginationUtil: JhiPaginationUtil) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const page = route.queryParams['page'] ? route.queryParams['page'] : '1';
        const sort = route.queryParams['sort'] ? route.queryParams['sort'] : 'id,asc';
        return {
            page: this.paginationUtil.parsePage(page),
            predicate: this.paginationUtil.parsePredicate(sort),
            ascending: this.paginationUtil.parseAscending(sort)
      };
    }
}

export const CartRoute: Routes = [
    {
        path: 'cart2',
        component: CartComponent,
        resolve: {
            'pagingParams': CartResolvePagingParams
        },
        data: {
            authorities: [],
            pageTitle: 'Cart'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const CartPopupRoute: Routes = [

    {
        path: 'cart/:id/delete',
        component: CartDeletePopupComponent,
        data: {
            authorities: [],
            pageTitle: 'Cart'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
