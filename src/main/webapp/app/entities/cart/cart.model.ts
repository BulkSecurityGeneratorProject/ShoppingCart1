import { BaseEntity } from './../../shared';

export class Cart implements BaseEntity {
    constructor(
        public id?: number,
        public title?: string,
        public completed?: boolean,
        public products?: BaseEntity[],
        public customer?: BaseEntity,
    ) {
        this.completed = false;
    }
}
