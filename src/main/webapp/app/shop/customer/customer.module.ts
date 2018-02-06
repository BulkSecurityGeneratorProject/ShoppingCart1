import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ShoppingCartSharedModule } from '../../shared';
import {
    CustomerService,
    CustomerPopupService,
    CustomerComponent,
    CustomerDeletePopupComponent,
    CustomerDeleteDialogComponent,
    customerRoute,
    customerPopupRoute,
    CustomerResolvePagingParams,
    CustomerPopupComponent,
    CustomerDialogComponent
} from './';

const ENTITY_STATES = [
    ...customerRoute,
    ...customerPopupRoute,
];

@NgModule({
    imports: [
        ShoppingCartSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        CustomerComponent,
        CustomerDeleteDialogComponent,
        CustomerDeletePopupComponent,
        CustomerPopupComponent,
        CustomerDialogComponent
    ],
    entryComponents: [
        CustomerComponent,
        CustomerDeleteDialogComponent,
        CustomerDeletePopupComponent,
        CustomerPopupComponent,
        CustomerDialogComponent
    ],
    providers: [
        CustomerService,
        CustomerPopupService,
        CustomerResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ShoppingCartCustomerModule {}
