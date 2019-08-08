import { TestBed } from '@angular/core/testing';
import {HttpClient} from '@angular/common/http';

import { MainService } from './main.service';

describe('MainService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MainService = TestBed.get(MainService);
    expect(service).toBeTruthy();
  });
});
