import { Component, OnInit } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AdminService, Payment } from '../../../../services/admin.service';
import { MaterialModule } from '../../../../../../material.module';

@Component({
  selector: 'app-get-all-payments',
  imports:[MaterialModule,CommonModule,RouterLink,ReactiveFormsModule],
  templateUrl: './get-all-payments.component.html'
})
export class GetAllPaymentsComponent implements OnInit {
  payments: Payment[] = [];
  displayedColumns = ['id', 'fromBankNumber', 'toBankNumber', 'amount', 'status'];

  constructor(private api: AdminService) {}

  ngOnInit() {
    this.api.getAllPayments().subscribe(res => (this.payments = res));
  }
}
