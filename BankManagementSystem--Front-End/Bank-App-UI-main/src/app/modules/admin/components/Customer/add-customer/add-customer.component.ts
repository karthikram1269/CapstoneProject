import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AdminService } from '../../../services/admin.service';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { MaterialModule } from '../../../../../material.module';

@Component({
  selector: 'app-add-customer',
  imports:[MaterialModule,CommonModule,RouterLink,ReactiveFormsModule],
  templateUrl: './add-customer.component.html'
})
export class AddCustomerComponent {
  customerForm: FormGroup;
  message = '';

  constructor(private fb: FormBuilder, private api: AdminService) {
    this.customerForm = this.fb.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phone: [''],
      aadhar: ['', Validators.required],
      pan: ['']
    });
  }

  onSubmit(): void {
    if (this.customerForm.invalid) return;

    this.api.addCustomer(this.customerForm.value).subscribe({
      next: () => {
        this.message = 'Customer added successfully!';
        this.customerForm.reset();
      },
      error: () => (this.message = 'Failed to add customer')
    });
  }
}
