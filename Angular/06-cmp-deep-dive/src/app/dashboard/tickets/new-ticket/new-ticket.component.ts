import { AfterViewInit, Component, ElementRef, ViewChild, input, output } from '@angular/core';
import { ButtonComponent } from '../../../shared/button/button.component';
import { ControlComponent } from '../../../shared/control/control.component';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-new-ticket',
  standalone: true,
  imports: [ButtonComponent, ControlComponent, FormsModule],
  templateUrl: './new-ticket.component.html',
  styleUrl: './new-ticket.component.css'
})
export class NewTicketComponent implements AfterViewInit {
  @ViewChild('form') form?: ElementRef<HTMLFormElement>;
  //private readonly form = viewChild.required<ElementRef<HTMLFormElement>>('form');
  add = output<{title: string; text: string}>();
  enteredTitle = '';
  enteredText = '';

  onSubmit() {
    this.add.emit({title: this.enteredTitle, text: this.enteredText});
    this.enteredText = '';
    this.enteredTitle = '';
    }

    ngAfterViewInit() {
      console.log('AFTER VIEW INIT');
      console.log(this.form?.nativeElement);
    }
}
