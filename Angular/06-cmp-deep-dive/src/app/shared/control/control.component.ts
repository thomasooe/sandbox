import { Component, ContentChild, ElementRef, Input, ViewEncapsulation, inject } from '@angular/core';

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
  private readonly el = inject(ElementRef); // programmatic access to the host element
  @ContentChild('input') private readonly control?: ElementRef<HTMLInputElement | HTMLTextAreaElement>;


  //@HostListener('click')
  onClick() {
    console.log('click');
    console.log(this.control?.nativeElement.name);
    //console.log(this.el);
  }
}
