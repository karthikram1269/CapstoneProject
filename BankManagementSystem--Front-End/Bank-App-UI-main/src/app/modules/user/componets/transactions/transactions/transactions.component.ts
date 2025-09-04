// import { Component, OnInit } from '@angular/core';
// import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
// import { UserService } from '../../../services/user.services';
// import { CommonModule } from '@angular/common';
// import { MaterialModule } from '../../../../../material.module';

// @Component({
//   selector: 'app-transactions',
  
//   templateUrl: './transactions.component.html',
//   styleUrls: ['./transactions.component.css'],
// })
// export class TransactionsComponent implements OnInit {
//   payments: any[] = [];
//   message = '';
//   error = '';
//   form!: FormGroup;

//   constructor(private fb: FormBuilder, private api: UserService) {}

//   ngOnInit(): void {
//     this.form = this.fb.group({
//       senderAccountNumber: ['', Validators.required],
//       receiverAccountNumber: ['', Validators.required],
//       amount: [0, [Validators.required, Validators.min(1)]],
//       senderEmail: [''],
//       receiverEmail: [''],
//       senderName: [''],
//       receiverName: [''],
//     });

//     this.load();
//   }

//   load() {
//     this.api.getPayments().subscribe({
//       next: d => this.payments = d,
//       error: () => this.error = 'Failed to load payments'
//     });
//   }

//   transfer() {
//     this.message = this.error = '';
//     if (this.form.invalid) return;
//     const req = this.form.getRawValue();
//     this.api.transfer(req).subscribe({
//       next: (r) => {
//         this.message = `Transfer ${r.status}: ₹${r.amount} (paymentId: ${r.paymentId})`;
//         this.load();
//       },
//       error: (e) => (this.error = e?.error || 'Transfer failed'),
//     });
//   }
// }
