// import { Component, OnInit } from '@angular/core';
// import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
// import { UserService } from '../../../services/user.services';
// import { MaterialModule } from '../../../../../material.module';
// import { CommonModule } from '@angular/common';

// @Component({
//   selector: 'app-profile',
  
//   templateUrl: './profile.component.html',
//   styleUrls: ['./profile.component.css'],
// })
// export class ProfileComponent implements OnInit {
//   profile: any = null;
//   message = '';
//   error = '';
//   form!: FormGroup;

//   constructor(private fb: FormBuilder, private api: UserService) {}

//   ngOnInit(): void {
//     this.form = this.fb.group({
//       id: [null, Validators.required],
//       aadhar: ['', Validators.required],
//       pan: [''],
//     });
//   }

//   loadProfile() {
//     this.message = this.error = '';
//     const { id, aadhar } = this.form.getRawValue();
//     if (!id || !aadhar) return;
//     this.api.getProfile(+id, aadhar).subscribe({
//       next: (p) => (this.profile = p),
//       error: (e) => (this.error = e?.error || 'Failed to load profile'),
//     });
//   }

//   updateKyc() {
//     const { id, aadhar, pan } = this.form.getRawValue();
//     if (!id || !aadhar || !pan) return;
//     this.api.updateKyc(+id, aadhar, pan).subscribe({
//       next: (txt) => (this.message = String(txt)),
//       error: (e) => (this.error = e?.error || 'Failed to update KYC'),
//     });
//   }
// }
