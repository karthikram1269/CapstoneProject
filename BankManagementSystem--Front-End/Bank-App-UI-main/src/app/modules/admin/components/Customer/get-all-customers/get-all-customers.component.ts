import { Component, OnInit } from '@angular/core';
import { AdminService, Customer } from '../../../services/admin.service';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { MaterialModule } from '../../../../../material.module';

@Component({
  selector: 'app-get-all-customers',
  imports:[MaterialModule,CommonModule,RouterLink,ReactiveFormsModule],
  templateUrl: './get-all-customers.component.html'
})
export class GetAllCustomersComponent implements OnInit {
  customers: Customer[] = [];
  displayedColumns: string[] = ['id', 'name', 'email', 'phone', 'aadhar', 'pan'];

  constructor(private api: AdminService) {}

  ngOnInit(): void {
    this.api.getAllCustomers().subscribe(res => (this.customers = res));
  }
}
