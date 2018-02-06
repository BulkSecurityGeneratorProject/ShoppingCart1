import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { ShoppingCartShopProductModule } from './product/product.module';
import { ShoppingCartCustomerModule } from './customer/customer.module';

@NgModule({
    imports: [
        ShoppingCartShopProductModule,
        ShoppingCartCustomerModule,
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ShoppingCartShopModule {}
