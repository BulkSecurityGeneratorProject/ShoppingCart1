import { BaseEntity } from './../../shared';

export class Product implements BaseEntity {
    constructor(
        public id?: number,
        public title?: string,
        public keywords?: string,
        public description?: string,
        public rating?: number,
        public dateAdded?: any,
        public dateModified?: any,
        public cart?: BaseEntity,
        public categories?: BaseEntity[],
        public quantity?: number,
    ) {
    }
}
