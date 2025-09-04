import { Component, OnInit } from '@angular/core';
import { Account, AdminService } from '../../../../services/admin.service';
import { MaterialModule } from '../../../../../../material.module';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-get-all-accounts',
  imports:[MaterialModule,CommonModule,ReactiveFormsModule],
  templateUrl: './get-all-accounts.component.html'
})
export class GetAllAccountsComponent implements OnInit {
  accounts: Account[] = [];
  displayedColumns = ['id', 'userName', 'aadhar', 'bankNumber', 'ifsc', 'balance'];

  constructor(private api: AdminService) {}

  ngOnInit() {
    this.api.getAllAccounts().subscribe(res => (this.accounts = res));
  }
}
