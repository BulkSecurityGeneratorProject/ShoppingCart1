import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { Product } from './product.model';
import { ProductPopupService } from './product-popup.service';
import { ProductService } from './product.service';
import { User, UserService } from '../../shared';

@Component({
    selector: 'jhi-product-addtocart-dialog',
    templateUrl: './product-addtocart-dialog.component.html'
})
export class ProductAddToCartDialogComponent {

    product: Product;

    constructor(
        private productService: ProductService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmAdd(id: number, quantity: number) {
        this.productService.addToCart(id, quantity).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'productListModification',
                content: 'Added an product'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-product-addtocart-popup',
    template: ''
})
export class ProductAddToCartPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private productPopupService: ProductPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.productPopupService
                .open(ProductAddToCartDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
