import {Component, OnDestroy, OnInit} from '@angular/core';
import {Part} from "../../share/part.model";
import {PartService} from "../../share/part.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-parts',
  templateUrl: './parts.component.html',
  styleUrls: ['./parts.component.sass']
})
export class PartsComponent implements OnInit, OnDestroy {

  private partSubscription: Subscription;
  parts: Part[];
  add: boolean;

  constructor(private partService: PartService) { }

  ngOnInit() {
    this.partSubscription = this.partService.findAllParts().subscribe(data => {
      this.parts = data;
    });
  }

  ngOnDestroy(): void {
    this.partSubscription.unsubscribe();
  }

  addNewPart() {
    this.add = true;
  }
}
