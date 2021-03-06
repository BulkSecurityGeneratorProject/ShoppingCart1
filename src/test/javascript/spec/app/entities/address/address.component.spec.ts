/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { Headers } from '@angular/http';

import { ShoppingCartTestModule } from '../../../test.module';
import { AddressComponent } from '../../../../../../main/webapp/app/entities/address/address.component';
import { AddressService } from '../../../../../../main/webapp/app/entities/address/address.service';
import { Address } from '../../../../../../main/webapp/app/entities/address/address.model';

describe('Component Tests', () => {

    describe('Address Management Component', () => {
        let comp: AddressComponent;
        let fixture: ComponentFixture<AddressComponent>;
        let service: AddressService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [ShoppingCartTestModule],
                declarations: [AddressComponent],
                providers: [
                    AddressService
                ]
            })
            .overrideTemplate(AddressComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(AddressComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(AddressService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new Headers();
                headers.append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of({
                    json: [new Address(123)],
                    headers
                }));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.addresses[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
