import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { Customer } from './customer.model';
import { ResponseWrapper, createRequestOption } from '../../shared';

@Injectable()
export class CustomerService {

    // private resourceUrl =  SERVER_API_URL + 'api/customers';
    private resourceUrl =  SERVER_API_URL + 'api/carts';

    constructor(private http: Http) { }

    find(id: number): Observable<Customer> {
        return this.http.get(`${this.resourceUrl}/cartitem/${id}`).map((res: Response) => {
            const jsonResponse = res.json();
            return this.convertItemFromServer(jsonResponse);
        });
    }

    query(req?: any): Observable<ResponseWrapper> {
        const options = createRequestOption(req);
        return this.http.get(`${this.resourceUrl}/cartitems`, options)
            .map((res: Response) => this.convertResponse(res));
    }

    delete(id: number): Observable<Response> {
        return this.http.delete(`${this.resourceUrl}/cartitem/${id}`);
    }

    submitCart(): Observable<Response> {
        return this.http.get(`${this.resourceUrl}/completed`);
    }

    private convertResponse(res: Response): ResponseWrapper {
        const jsonResponse = res.json();
        const result = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            result.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return new ResponseWrapper(res.headers, result, res.status);
    }

    /**
     * Convert a returned JSON object to Customer.
     */
    private convertItemFromServer(json: any): Customer {
        const entity: Customer = Object.assign(new Customer(), json);
        return entity;
    }

    /**
     * Convert a Customer to a JSON which can be sent to the server.
     */
    private convert(customer: Customer): Customer {
        const copy: Customer = Object.assign({}, customer);
        return copy;
    }
}
