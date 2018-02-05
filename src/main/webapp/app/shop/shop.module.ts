import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { ShoppingCartShopProductModule } from './product/product.module';
import { ShoppingCartCartModule } from './cart/cart.module';
import { ShoppingCartCustomerModule } from './customer/customer.module';
import { ShoppingCartAddressModule } from './address/address.module';

@NgModule({
    imports: [
        ShoppingCartShopProductModule,
        ShoppingCartCartModule,
        ShoppingCartCustomerModule,
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ShoppingCartShopModule {}
