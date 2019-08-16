import { Project } from './project';
import { Day } from './day';

export class ProjectTime {
    constructor(
      public id: number, 
      public start: string,
      public finish: string,
      public working_hours: number,
      public projectEntity: Project,
      public day: Day
    ) {
  }
}
