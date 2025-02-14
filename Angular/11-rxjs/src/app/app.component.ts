import { Component, DestroyRef, OnInit, effect, inject, signal } from '@angular/core';
import { toObservable, toSignal } from '@angular/core/rxjs-interop';

import { Observable, interval, map } from 'rxjs';

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html'
})
export class AppComponent implements OnInit {
  clickCount = signal(0);
  clickCount$ = toObservable(this.clickCount);
  private destroyRef = inject(DestroyRef);
  interval$ = interval(1000);
  intervalSignal = toSignal(this.interval$, { initialValue: 999 });

  customInterval$ = new Observable((subscriber) => {
    let timesExecuted = 0;
    const interval = setInterval(() => {
      //if (timesExecuted > 2) {
      //  subscriber.error('abcError')
      //}
      if (timesExecuted > 3) {
        clearInterval(interval);
        subscriber.complete();
        return;
      }
      console.log('Emitting new value...')
      subscriber.next({ message: 'New value' });
      timesExecuted++;
    }, 2000);
  });

  constructor() {
    //effect(() => {
    //  console.log(`Clicked Button ${this.clickCount()} times.`)
    //});

    const subscription1 = this.customInterval$.subscribe({
      next: (val) => console.log(val),
      complete: () => console.log('Interval completed'),
      error: (err) => console.log(err)
    });

    const subscription = this.clickCount$.subscribe({
      next: (val) => console.log(`$Clicked Button ${this.clickCount()} times.`)
    });
    this.destroyRef.onDestroy(() => {
      subscription1.unsubscribe();
      subscription.unsubscribe();
    })
  }

  ngOnInit(): void {
    const subscription = interval(1000).pipe(
      map((val) => val * 2)
    ).subscribe({
      next: (val) => console.log(val)
    });

    this.destroyRef.onDestroy(() => {
      subscription.unsubscribe();
    });
  }

  onClick() {
    this.clickCount.update(prevCount => prevCount + 1)
  }

}
