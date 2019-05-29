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
  private computersSubscription: Subscription;
  parts: Part[];
  showForm: boolean;
  currentPart: Part;
  computers: number;

  constructor(private partService: PartService) { }

  ngOnInit() {
    this.getData();
  }

  ngOnDestroy(): void {
    this.partSubscription.unsubscribe();
    this.computersSubscription.unsubscribe();
  }

  private getData(): void {
    this.partSubscription = this.partService.findAllParts().subscribe(data => {
      this.parts = data;
    });
    this.getComputers();
  }

  private getComputers(): void {
    this.computersSubscription = this.partService.getComputers().subscribe(data => {
      this.computers = data;
    });
  }

  addNewPart() {
    this.currentPart = new Part();
    this.showForm = true;
  }

  onEdit(part: Part) {
    this.showForm = true;
    this.currentPart = part;
  }

  onDelete(partId: number) {
    this.partService.deletePart(partId);
  }

  onAddPart(showForm: boolean) {
    this.showForm = showForm;
    this.getData();
  }
}
