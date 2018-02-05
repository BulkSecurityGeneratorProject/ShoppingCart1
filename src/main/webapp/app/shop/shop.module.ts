import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { ShoppingCartCategoryModule } from './category/category.module';
import { ShoppingCartProductModule } from './product/product.module';
import { ShoppingCartCustomerModule } from './customer/customer.module';
import { ShoppingCartAddressModule } from './address/address.module';
import { ShoppingCartCartModule } from './cart/cart.module';
/* jhipster-needle-add-entity-module-import - Application will add entity modules imports here */

@NgModule({
    imports: [
        ShoppingCartCategoryModule,
        ShoppingCartProductModule,
        ShoppingCartCustomerModule,
        ShoppingCartAddressModule,
        ShoppingCartCartModule,
        /* jhipster-needle-add-entity-module - Application will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ShoppingCartEntityModule {}
