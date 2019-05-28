import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Part} from "./part.model";

@Injectable({
  providedIn: 'root'
})
export class PartService {
  private  partUrl: string;

  constructor(private http: HttpClient) {
    this.partUrl = 'http://localhost:8080/parts';
  }

  public findAllParts(): Observable<Part[]> {
    return this.http.get<Part[]>(this.partUrl);
  }

  public savePart(part: Part) {
    return this.http.post<Part>(this.partUrl, part);
  }
}
