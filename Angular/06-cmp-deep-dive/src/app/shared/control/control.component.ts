import { AfterContentInit, Component, ContentChild, ElementRef, Input, ViewEncapsulation, afterNextRender, afterRender, inject } from '@angular/core';

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
export class ControlComponent implements AfterContentInit {
  @Input({ required: true }) label!: string;
  private readonly el = inject(ElementRef); // programmatic access to the host element
  @ContentChild('input') private readonly control?: ElementRef<HTMLInputElement | HTMLTextAreaElement>;

  constructor() {
    afterRender(() => {
      console.log("After Render");
    });

    afterNextRender(() => {
      console.log("After Next Render");
    });
  }

  //@HostListener('click')
  onClick() {
    console.log('click');
    console.log(this.control?.nativeElement.name);
    //console.log(this.el);
  }

  ngAfterContentInit(): void {
    console.log(this.control?.nativeElement);
  }
}
