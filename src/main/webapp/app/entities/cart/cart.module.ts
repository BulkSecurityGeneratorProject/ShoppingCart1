import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ShoppingCartSharedModule } from '../../shared';
import {
    CartService,
    CartPopupService,
    CartComponent,
    CartDetailComponent,
    CartDialogComponent,
    CartPopupComponent,
    CartDeletePopupComponent,
    CartDeleteDialogComponent,
    cartRoute,
    cartPopupRoute,
} from './';

const ENTITY_STATES = [
    ...cartRoute,
    ...cartPopupRoute,
];

@NgModule({
    imports: [
        ShoppingCartSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        CartComponent,
        CartDetailComponent,
        CartDialogComponent,
        CartDeleteDialogComponent,
        CartPopupComponent,
        CartDeletePopupComponent,
    ],
    entryComponents: [
        CartComponent,
        CartDialogComponent,
        CartPopupComponent,
        CartDeleteDialogComponent,
        CartDeletePopupComponent,
    ],
    providers: [
        CartService,
        CartPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ShoppingCartCartModule {}
