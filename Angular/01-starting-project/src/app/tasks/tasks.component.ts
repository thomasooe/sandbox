import { Component, Input } from '@angular/core';
import { TaskComponent } from "./task/task.component";

@Component({
  selector: 'app-tasks',
  standalone: true,
  imports: [TaskComponent],
  templateUrl: './tasks.component.html',
  styleUrl: './tasks.component.css'
})
export class TasksComponent {
  @Input({required: true}) userId!: string;
  @Input({required: true}) name!: string;
  

  tasks = [ 
    {
    id: 't1',
    userId: 'u1',
    title: 'Master Angular',
    summary: 'Learn all',
    duedate: '2024-12-31'
  },
  {
    id: 't2',
    userId: 'u3',
    title: 'Build first prototype',
    summary: 'Learn all',
    duedate: '2024-12-31'
  },
  {
    id: 't3',
    userId: 'u3',
    title: 'Prepare issue template',
    summary: 'Learn all',
    duedate: '2024-12-31'
  }

]

 get selectedUserTasks() {
  console.log('selected user ' + this.userId);
  
  return this.tasks.filter((task) => task.userId === this.userId);
 }
}