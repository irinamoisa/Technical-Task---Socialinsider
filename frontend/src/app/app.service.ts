import { HttpClient, HttpHeaders, HttpResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { IData } from "./data.model";
import { IRequest } from "./request.model";

@Injectable({ providedIn: 'root' })
export class AppService {
  protected resourceUrl = "http://localhost:9090/api/brand";

  constructor(protected http: HttpClient) {}

  getData(request: IRequest): Observable<HttpResponse<IData[]>> {
    return this.http.post<IData[]>(this.resourceUrl, request, { observe: 'response', headers: new HttpHeaders({'Access-Control-Allow-Origin': '*'}) });
  }
}