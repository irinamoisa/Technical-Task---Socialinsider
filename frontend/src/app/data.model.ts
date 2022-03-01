import { LocationChangeEvent } from "@angular/common";

export interface IData {
    brandName: string,
    totalProfiles: number,
    totalFans: number,
    totalEngagement: number
}

export class Data implements IData{
    constructor (
        public brandName: string, 
        public totalProfiles: number, 
        public totalFans: number,
        public totalEngagement: number
    ){}
}

