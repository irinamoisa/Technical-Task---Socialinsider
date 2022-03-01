import { LocationChangeEvent } from "@angular/common";
import { Timestamp } from "rxjs";

export interface IRequest {
    start: Date,
    end: Date,
    timezone: any
}

export class Request implements IRequest{
    constructor (
        public start: Date,
        public end: Date,
        public timezone: any
    ){}
}

