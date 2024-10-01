import { Component, ElementRef, HostListener, Input, ViewEncapsulation, inject } from '@angular/core';

@Component({
  selector: 'app-control',
  standalone: true,
  imports: [],
  templateUrl: './control.component.html',
  styleUrl: './control.component.css',
  encapsulation: ViewEncapsulation.None,
  host: {
    class: 'control',
    '(click)': 'onClick()'
}
})
export class ControlComponent {
  @Input({required: true}) label!: string;
  private el = inject(ElementRef); // programmatic access to the host element

  //@HostListener('click')
  onClick() {
    console.log('click');
    //console.log(this.el);
  }
}
