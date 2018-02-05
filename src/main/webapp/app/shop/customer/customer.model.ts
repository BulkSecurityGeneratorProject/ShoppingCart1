import { BaseEntity } from './../../shared';

export class Customer implements BaseEntity {
    constructor(
        public id?: number,
        public title?: string,
        public purchasedPrice?: string,
        public quantity?: number
    ) {
    }
}
