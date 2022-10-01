import { TestBed } from '@angular/core/testing';

import { UserRService } from './user-r.service';

describe('UserRService', () => {
  let service: UserRService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserRService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
