import { Component, DestroyRef, afterNextRender, inject, viewChild } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  private form = viewChild.required<NgForm>('form');
  private destroyRef = inject(DestroyRef);
 
  constructor() {
    afterNextRender(() => {
      const subscription = this.form().valueChanges?.subscribe({
        next: (value) => console.log(value)
      });

      this.destroyRef.onDestroy(() => subscription?.unsubscribe());
    });
  }

  onSubmit(formData: NgForm) {
    
    if (formData.form.invalid) {
      return;
    }

    const enteredEmail = formData.form.value.email;    
    const enteredPassword = formData.form.value.password;    

    console.log(formData.form)
    console.log(enteredEmail, enteredPassword);

    formData.form.reset();
  }
}
