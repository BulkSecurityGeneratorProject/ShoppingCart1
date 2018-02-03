import './vendor.ts';

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Ng2Webstorage } from 'ngx-webstorage';

import { ShoppingCartSharedModule, UserRouteAccessService } from './shared';
import { ShoppingCartAppRoutingModule} from './app-routing.module';
import { ShoppingCartHomeModule } from './home/home.module';
import { ShoppingCartAdminModule } from './admin/admin.module';
import { ShoppingCartAccountModule } from './account/account.module';
import { ShoppingCartEntityModule } from './entities/entity.module';
import { customHttpProvider } from './blocks/interceptor/http.provider';
import { PaginationConfig } from './blocks/config/uib-pagination.config';

// jhipster-needle-angular-add-module-import JHipster will add new module here

import {
    JhiMainComponent,
    NavbarComponent,
    FooterComponent,
    ProfileService,
    PageRibbonComponent,
    ErrorComponent
} from './layouts';

@NgModule({
    imports: [
        BrowserModule,
        ShoppingCartAppRoutingModule,
        Ng2Webstorage.forRoot({ prefix: 'jhi', separator: '-'}),
        ShoppingCartSharedModule,
        ShoppingCartHomeModule,
        ShoppingCartAdminModule,
        ShoppingCartAccountModule,
        ShoppingCartEntityModule,
        // jhipster-needle-angular-add-module JHipster will add new module here
    ],
    declarations: [
        JhiMainComponent,
        NavbarComponent,
        ErrorComponent,
        PageRibbonComponent,
        FooterComponent
    ],
    providers: [
        ProfileService,
        customHttpProvider(),
        PaginationConfig,
        UserRouteAccessService
    ],
    bootstrap: [ JhiMainComponent ]
})
export class ShoppingCartAppModule {}
