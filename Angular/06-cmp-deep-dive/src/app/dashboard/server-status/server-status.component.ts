import { Component, OnDestroy, OnInit } from '@angular/core';

@Component({
  selector: 'app-server-status',
  standalone: true,
  imports: [],
  templateUrl: './server-status.component.html',
  styleUrl: './server-status.component.css'
})
export class ServerStatusComponent implements OnInit, OnDestroy {
  currentStatus: 'online' | 'offline' | 'unknown' = 'online';
  //private interval: NodeJS.Timeout | undefined;
  private interval?: ReturnType<typeof setInterval>

  ngOnInit() {
    this.interval = setInterval(() => {
      const rnd = Math.random(); // value between 0 - 1

      if (rnd < 0.5) {
        this.currentStatus = 'online';
      } else if (rnd < 0.9) {
        this.currentStatus = 'offline';
      } else {
        this.currentStatus = 'unknown';
      }
    }, 5000)
  }

  ngOnDestroy(): void {
      clearTimeout(this.interval);
  }
}
