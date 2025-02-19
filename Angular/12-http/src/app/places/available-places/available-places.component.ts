import { Component, DestroyRef, OnInit, inject, signal } from '@angular/core';

import { Place } from '../place.model';
import { PlacesComponent } from '../places.component';
import { PlacesContainerComponent } from '../places-container/places-container.component';
import { PlacesService } from '../places.service';

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
  error = signal('');

  private placesService = inject(PlacesService);
  private destroyRef = inject(DestroyRef);

  ngOnInit() {
      this.isFetching.set(true);
        const subscription = this.placesService.loadAvailablePlaces()
        .subscribe({
          next: (places) => {
            console.log(places);
            this.places.set(places);
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

  onSelectPlace(selectedPlace: Place) {
    const subscription = this.placesService.addPlaceToUserPlaces(selectedPlace.id).subscribe({
      next: (resData) => console.log(resData)
    });

    this.destroyRef.onDestroy(() => {
      subscription.unsubscribe();
    })
  }
}
