import { TestBed } from '@angular/core/testing';

import { ProjectTimeService } from './project-time.service';

describe('ProjectTimeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ProjectTimeService = TestBed.get(ProjectTimeService);
    expect(service).toBeTruthy();
  });
});
