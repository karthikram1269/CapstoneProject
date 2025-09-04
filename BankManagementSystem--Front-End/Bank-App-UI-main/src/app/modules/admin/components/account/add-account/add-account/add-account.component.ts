import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MaterialModule } from '../../../../../../material.module';
import { CommonModule } from '@angular/common';
import { AdminService } from '../../../../services/admin.service';

@Component({
  selector: 'app-add-account',
  imports:[MaterialModule,CommonModule,ReactiveFormsModule],
  templateUrl: './add-account.component.html'
})
export class AddAccountComponent {
  accountForm: FormGroup;
  message = '';

  constructor(private fb: FormBuilder, private api: AdminService) {
    this.accountForm = this.fb.group({
      userName: ['', Validators.required],
      aadhar: ['', Validators.required],
      bankNumber: ['', Validators.required],
      ifsc: [''],
      balance: [0, Validators.required]
    });
  }

  onSubmit(): void {
    if (this.accountForm.invalid) return;

    this.api.addAccount(this.accountForm.value).subscribe({
      next: () => {
        this.message = 'Account created!';
        this.accountForm.reset({ balance: 0 });
      },
      error: () => (this.message = 'Failed to create account')
    });
  }
}
