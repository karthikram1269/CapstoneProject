// import { Injectable } from '@angular/core';
// import { HttpClient } from '@angular/common/http';
// import { Observable } from 'rxjs';

// const CUS = 'http://localhost:8080/api/customers';
// const ACC = 'http://localhost:8080/api/accounts';
// const PAY = 'http://localhost:8080/api/payments';

// @Injectable({ providedIn: 'root' })
// export class UserService {
//   constructor(private http: HttpClient) {}

//   // customers
//   getCustomerById(id: number) { return this.http.get(`${CUS}/${id}`); }
//   updateKyc(id: number, aadhar: string, pan: string) {
//     return this.http.patch(`${CUS}/${id}/kyc`, { aadhar, pan }, { responseType: 'text' });
//   }
//   getProfile(id: number, aadhar: string) {
//     return this.http.get(`${CUS}/${id}/profile`, { params: { aadhar } });
//   }

//   // accounts
//   getAccountById(id: number) { return this.http.get(`${ACC}/${id}`); }
//   getAccountByAadhar(aadhar: string) { return this.http.get(`${ACC}/aadhar/${aadhar}`); }
//   getAccountByBank(bankNumber: string) { return this.http.get(`${ACC}/bank/${bankNumber}`); }
//   getAllAccounts() { return this.http.get<any[]>(ACC); }
//   credit(bank: string, amount: number) {
//     return this.http.post(`${ACC}/bank/${bank}/credit`, null, { params: { amount }, responseType: 'text' });
//   }
//   debit(bank: string, amount: number) {
//     return this.http.post(`${ACC}/bank/${bank}/debit`, null, { params: { amount }, responseType: 'text' });
//   }

//   // payments
//   transfer(req: any): Observable<any> {
//     return this.http.post(`${PAY}/transfer`, req);
//   }
//   getPayments(): Observable<any[]> { return this.http.get<any[]>(PAY); }
// }
