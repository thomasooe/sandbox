import { Component, Input } from '@angular/core';
import { TaskComponent } from "./task/task.component";
import { NewTaskComponent } from "../new-task/new-task.component";

@Component({
  selector: 'app-tasks',
  standalone: true,
  imports: [TaskComponent, NewTaskComponent],
  templateUrl: './tasks.component.html',
  styleUrl: './tasks.component.css'
})
export class TasksComponent {
  @Input({required: true}) userId!: string;
  @Input({required: true}) name!: string;
  
  isAddingTask = false;
  

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
  return this.tasks.filter((task) => task.userId === this.userId);
 }

 onCompleteTask(id: string) {
    this.tasks = this.tasks.filter((task) => task.id !== id);
 }

 onStartAddTask() {
  this.isAddingTask = true;
 }

 onCancelAddTask() {
  this.isAddingTask = false;
 }
}
