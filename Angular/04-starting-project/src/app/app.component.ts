import { Component, signal } from '@angular/core';
import { type ResultData } from './result-data.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {
  resultsData = signal<ResultData[] | undefined>(undefined); 

  
}
