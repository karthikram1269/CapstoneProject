// import { Component, OnInit } from '@angular/core';
// import { FormBuilder, FormControl } from '@angular/forms';
// import { UserService } from '../../../services/user.services';

// @Component({
//   selector: 'app-accounts',
//   templateUrl: './accounts.component.html',
//   styleUrls: ['./accounts.component.css']
// })
// export class AccountsComponent implements OnInit {
//   byAadhar!: FormControl;
//   byBank!: FormControl;
//   result: any = null;

//   constructor(private fb: FormBuilder, private api: UserService) {}

//   ngOnInit() {
//     this.byAadhar = this.fb.control('');
//     this.byBank = this.fb.control('');
//   }

//   searchAadhar() {
//     const a = this.byAadhar.value?.trim();
//     if (!a) return;
//     this.api.getAccountByAadhar(a).subscribe({
//       next: r => this.result = r,
//       error: () => this.result = null
//     });
//   }

//   searchBank() {
//     const b = this.byBank.value?.trim();
//     if (!b) return;
//     this.api.getAccountByBank(b).subscribe({
//       next: r => this.result = r,
//       error: () => this.result = null
//     });
//   }
// }
