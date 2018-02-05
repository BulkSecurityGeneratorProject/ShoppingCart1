import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ShoppingCartSharedModule } from '../../shared';
import {
    ProductService,
    ProductPopupService,
    ProductComponent,
    ProductAddToCartPopupComponent,
    ProductAddToCartDialogComponent,
    productRoute,
    productPopupRoute,
} from './';

const ENTITY_STATES = [
    ...productRoute,
    ...productPopupRoute,
];

@NgModule({
    imports: [
        ShoppingCartSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        ProductComponent,
        ProductAddToCartDialogComponent,
        ProductAddToCartPopupComponent,
    ],
    entryComponents: [
        ProductComponent,
        ProductAddToCartDialogComponent,
        ProductAddToCartPopupComponent,
    ],
    providers: [
        ProductService,
        ProductPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ShoppingCartShopProductModule {}
