import { NewTaskData } from "./task/task.model";
import { Injectable } from "@angular/core";

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

constructor() {
    const tasks = localStorage.getItem('tasks')

    if (tasks) {
        this.tasks = JSON.parse(tasks)
    }
}

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
      this.saveTasks();
}

removeTask(id: string) {
    this.tasks = this.tasks.filter((task) => task.id !== id);
    this.saveTasks();
}

private saveTasks()  {
    localStorage.setItem('tasks', JSON.stringify(this.tasks))
}
}

