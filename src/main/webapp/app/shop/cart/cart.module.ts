import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ShoppingCartSharedModule } from '../../shared';
import {
    CartService,
    CartPopupService,
    CartComponent,
    CartDeletePopupComponent,
    CartDeleteDialogComponent,
    CartRoute,
    CartPopupRoute,
} from './';

const ENTITY_STATES = [
    ...CartRoute,
    ...CartPopupRoute,
];

@NgModule({
    imports: [
        ShoppingCartSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        CartComponent,
        CartDeleteDialogComponent,
        CartDeletePopupComponent,
    ],
    entryComponents: [
        CartComponent,
        CartDeleteDialogComponent,
        CartDeletePopupComponent,
    ],
    providers: [
        CartService,
        CartPopupService
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ShoppingCartCartModule {}
