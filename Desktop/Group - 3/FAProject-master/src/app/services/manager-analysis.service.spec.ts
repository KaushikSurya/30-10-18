import { TestBed } from '@angular/core/testing';

import { ManagerAnalysisService } from './manager-analysis.service';

describe('ManagerAnalysisService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ManagerAnalysisService = TestBed.get(ManagerAnalysisService);
    expect(service).toBeTruthy();
  });
});
