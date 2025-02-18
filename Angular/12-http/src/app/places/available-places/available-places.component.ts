import { Component, DestroyRef, OnInit, inject, signal } from '@angular/core';

import { Place } from '../place.model';
import { PlacesComponent } from '../places.component';
import { PlacesContainerComponent } from '../places-container/places-container.component';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs';

@Component({
  selector: 'app-available-places',
  standalone: true,
  templateUrl: './available-places.component.html',
  styleUrl: './available-places.component.css',
  imports: [PlacesComponent, PlacesContainerComponent]
})
export class AvailablePlacesComponent implements OnInit {
  places = signal<Place[] | undefined>(undefined);

  isFetching = signal(false);

  private httpClient = inject(HttpClient);
  private destroyRef = inject(DestroyRef);

  ngOnInit() {
      this.isFetching.set(true);
        const subscription = this.httpClient.get<{places: Place[]}>('http://localhost:3000/places')
        .pipe(
          map((resData) => resData.places)
        )
        .subscribe({
          next: (places) => {
            console.log(places);
            this.places.set(places);
            //console.log(response.body?.places);
          },
          complete: () => {
            this.isFetching.set(false);
          }
        }); /// Port 3000 ist der default port

        this.destroyRef.onDestroy(() => {
          subscription.unsubscribe();
        })
  }
}
