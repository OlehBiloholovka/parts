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

  public deletePart(partId: number): boolean {
    let isDeleted = false;
    this.http.post<Part>( this.partUrl + '/delete', partId)
        .subscribe(() => isDeleted = true);
    return isDeleted;
  }

  public getComputers(): Observable<number> {
    return this.http.get<number>(this.partUrl + '/computers');
  }
}
