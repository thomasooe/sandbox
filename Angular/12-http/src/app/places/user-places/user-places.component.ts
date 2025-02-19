import { Component, DestroyRef, OnInit, inject, signal } from '@angular/core';

import { PlacesContainerComponent } from '../places-container/places-container.component';
import { PlacesComponent } from '../places.component';
import { Place } from '../place.model';
import { PlacesService } from '../places.service';

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

  private placesService = inject(PlacesService);
  private destroyRef = inject(DestroyRef);


  ngOnInit() {
    this.isFetching.set(true);
      const subscription = this.placesService.loadUserPlaces()
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
  this.placesService.removeUserPlace(selectedPlace);
}
}
