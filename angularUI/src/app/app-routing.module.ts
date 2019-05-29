import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PartsComponent} from "./component/parts/parts.component";

const routes: Routes = [
  {path: 'parts', component: PartsComponent},
  {path: '', component: PartsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
