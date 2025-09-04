import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SyncAuditComponent } from './sync-audit.component';

describe('SyncAuditComponent', () => {
  let component: SyncAuditComponent;
  let fixture: ComponentFixture<SyncAuditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SyncAuditComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SyncAuditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
