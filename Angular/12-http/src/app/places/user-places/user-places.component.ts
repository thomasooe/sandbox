import { Component, DestroyRef, OnInit, inject, signal } from '@angular/core';

import { PlacesContainerComponent } from '../places-container/places-container.component';
import { PlacesComponent } from '../places.component';
import { HttpClient } from '@angular/common/http';
import { Place } from '../place.model';
import { catchError, map, throwError } from 'rxjs';

@Component({
  selector: 'app-user-places',
  standalone: true,
  templateUrl: './user-places.component.html',
  styleUrl: './user-places.component.css',
  imports: [PlacesContainerComponent, PlacesComponent],
})
export class UserPlacesComponent implements OnInit {
  user_places = signal<Place[] | undefined>(undefined);

  isFetching = signal(false);
  error = signal('');

  private httpClient = inject(HttpClient);
  private destroyRef = inject(DestroyRef);


  ngOnInit() {
    this.isFetching.set(true);
      const subscription = this.httpClient.get<{places: Place[]}>('http://localhost:3000/user-places')
      .pipe(
        map((resData) => resData.places), catchError((error) => 
        {
          console.log(error);
          return throwError(
            () => new Error('Server Error fetching favorite places. Try again later')
            );
          })
      )
      .subscribe({
        next: (places) => {
          console.log(places);
          this.user_places.set(places);
          //console.log(response.body?.places);
        },
        complete: () => {
          this.isFetching.set(false);
        },
        error: (error) => {
          //console.log(error);
          this.error.set(error.message);
          //this.error.set("Shome Server Error happened. Try again later");
        }
      }); /// Port 3000 ist der default port

      this.destroyRef.onDestroy(() => {
        subscription.unsubscribe();
      })
}

onUnSelectPlace(selectedPlace: Place) {

}
}
