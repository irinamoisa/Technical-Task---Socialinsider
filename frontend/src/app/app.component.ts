import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { AppService } from './app.service';
import { IData } from './data.model';
import { IRequest } from './request.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent{
  title = 'frontend';

  response: any;

  editForm = this.fb.group({
    start: [],
    end: [],
    timezone: [],
  });

  constructor (protected fb:FormBuilder, private appService:AppService) {}

  sendData(): void{
    const requestData = this.createFromForm();
    this.appService.getData(requestData).subscribe(res=>{
      this.response = res.body;
      console.log(this.response);
    });
  }

  protected createFromForm(): IRequest {
    return {
      start: new Date(this.editForm.get(['start'])!.value),
      end: new Date(this.editForm.get(['end'])!.value),
      timezone: Intl.DateTimeFormat().resolvedOptions().timeZone
    };
  }
}
