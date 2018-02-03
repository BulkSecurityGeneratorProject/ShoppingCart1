/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { Headers } from '@angular/http';

import { ShoppingCartTestModule } from '../../../test.module';
import { CartComponent } from '../../../../../../main/webapp/app/entities/cart/cart.component';
import { CartService } from '../../../../../../main/webapp/app/entities/cart/cart.service';
import { Cart } from '../../../../../../main/webapp/app/entities/cart/cart.model';

describe('Component Tests', () => {

    describe('Cart Management Component', () => {
        let comp: CartComponent;
        let fixture: ComponentFixture<CartComponent>;
        let service: CartService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [ShoppingCartTestModule],
                declarations: [CartComponent],
                providers: [
                    CartService
                ]
            })
            .overrideTemplate(CartComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(CartComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(CartService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new Headers();
                headers.append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of({
                    json: [new Cart(123)],
                    headers
                }));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.carts[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
