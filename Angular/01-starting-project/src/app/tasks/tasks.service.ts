import { NewTaskData } from "./task/task.model";

@Injectable({providedIn: 'root'})
export class TasksService {
    private tasks = [ 
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
    ];

gerUserTasks(userId: string) {
    return this.tasks.filter((task) => task.userId === userId);
}

addTask(taskData: NewTaskData, userId: string) {
    this.tasks.push({
        id: new Date().getTime().toString(),
        title: taskData.title,
        summary: taskData.summary,
        duedate: taskData.date,
        userId: userId
      })
}

removeTask(id: string) {
    this.tasks = this.tasks.filter((task) => task.id !== id);
}
}
import { Injectable } from "@angular/core";
