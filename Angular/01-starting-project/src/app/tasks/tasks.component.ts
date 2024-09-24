import { Component, Input, inject } from '@angular/core';
import { TaskComponent } from "./task/task.component";
import { NewTaskComponent } from "../new-task/new-task.component";
import { type NewTaskData } from './task/task.model';
import { TasksService } from './tasks.service';

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
  
  private taksService = inject(TasksService);
  
 get selectedUserTasks() { 
  return this.taksService.gerUserTasks(this.userId);
 }

 onCompleteTask(id: string) {
    this.taksService.removeTask(id);
 }

 onStartAddTask() {
  this.isAddingTask = true;
 }

 onCloseAddTask() {
  this.isAddingTask = false;
 }
}
