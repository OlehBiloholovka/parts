import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Part} from "../../../share/part.model";
import {PartService} from "../../../share/part.service";

@Component({
  selector: 'app-part-form',
  templateUrl: './part-form.component.html',
  styleUrls: ['./part-form.component.sass']
})
export class PartFormComponent implements OnInit {
  @Input() currentPart: Part;
  @Output()
  showForm = new EventEmitter<boolean>();
  constructor(private partService: PartService) { }

  ngOnInit() {
  }

  onSubmit() {
    this.partService.savePart(this.currentPart)
      .subscribe(() => this.showForm.emit(false));
  }

  onCancel() {
    this.showForm.emit(false);
  }
}
