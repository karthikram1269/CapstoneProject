import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaterialModule } from '../../../../../../material.module';
import { AdminService, AuditRecord } from '../../../../services/admin.service';

@Component({
  selector: 'app-sync-audit',
  standalone: true,
  imports: [CommonModule, MaterialModule],
  templateUrl: './sync-audit.component.html',
  styleUrls: ['./sync-audit.component.css']
})
export class SyncAuditComponent {
  audit: AuditRecord[] = [];
  displayedColumns = ['id', 'paymentId', 'details', 'createdAt'];
  syncing = false;

  constructor(private api: AdminService) {}

  onSync() {
    this.syncing = true;
    this.api.syncAudit().subscribe({
      next: res => (this.audit = res),
      complete: () => (this.syncing = false)
    });
  }
}
