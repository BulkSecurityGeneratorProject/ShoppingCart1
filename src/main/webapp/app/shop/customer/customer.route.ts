import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil } from 'ng-jhipster';

import { UserRouteAccessService } from '../../shared';
import { CustomerComponent } from './customer.component';
import { CustomerDeletePopupComponent } from './customer-delete-dialog.component';
import { CustomerPopupComponent } from './customer-dialog.component';

@Injectable()
export class CustomerResolvePagingParams implements Resolve<any> {

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

export const customerRoute: Routes = [
    {
        path: 'mycart',
        component: CustomerComponent,
        resolve: {
            'pagingParams': CustomerResolvePagingParams
        },
        data: {
            authorities: [],
            pageTitle: 'Customers'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const customerPopupRoute: Routes = [
    {
        path: 'mycart/:id/delete',
        component: CustomerDeletePopupComponent,
        data: {
            authorities: [],
            pageTitle: 'Customers'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'mycartcomplete',
        component: CustomerPopupComponent,
        data: {
            authorities: [],
            pageTitle: 'Customers'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
];
