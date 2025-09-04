import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaterialModule } from '../../../../../../material.module';
import { AdminService, AuditRecord } from '../../../../services/admin.service';

@Component({
  selector: 'app-get-audit',
  standalone: true,
  imports: [CommonModule, MaterialModule],
  templateUrl: './get-audit.component.html',
  styleUrls: ['./get-audit.component.css']
})
export class GetAuditComponent implements OnInit {
  audit: AuditRecord[] = [];
  displayedColumns = ['id', 'paymentId', 'details', 'createdAt'];

  constructor(private api: AdminService) { }

  ngOnInit(): void {
    this.api.getAudit().subscribe(res => (this.audit = res));
  }
}
