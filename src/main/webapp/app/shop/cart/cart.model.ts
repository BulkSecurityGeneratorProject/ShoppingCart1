import { BaseEntity } from './../../shared';

export class Cart implements BaseEntity {
    constructor(
        public id?: number,
        public quantity?: string,
        public purchasedPrice?: string,
    ) {
    }
}
