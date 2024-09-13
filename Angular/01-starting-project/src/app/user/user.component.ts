import { Component } from '@angular/core';

import { DUMMY_USERS } from '../dummy-users';

const ramdomIndex = Math.floor(Math.random() * DUMMY_USERS.length)

@Component({
  selector: 'app-user',
  standalone: true,
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent {
  selectedUser = DUMMY_USERS[ramdomIndex];

  get imagePath(){ 
    return 'assets/users/' + this.selectedUser.avatar;
   }

   onSelectUser() {
    const ramdomIndex = Math.floor(Math.random() * DUMMY_USERS.length)
    this.selectedUser = DUMMY_USERS[ramdomIndex]

    console.log("new Index is " + ramdomIndex)
   }
}
