import { Component, OnInit } from '@angular/core';
import {Part} from "../../../share/part.model";
import {PartService} from "../../../share/part.service";

@Component({
  selector: 'app-part-form',
  templateUrl: './part-form.component.html',
  styleUrls: ['./part-form.component.sass']
})
export class PartFormComponent implements OnInit {
  currentPart: Part;
  constructor(private partService: PartService) { }

  ngOnInit() {
    this.currentPart = new Part();
  }

  onSubmit() {
    this.partService.savePart(this.currentPart).subscribe(console.log);
  }

}
