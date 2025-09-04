import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Customer {
  id?: number;
  name: string;
  email: string;
  phone?: string;
  aadhar?: string;
  pan?: string;
}

export interface Account {
  id?: number;
  userName: string;
  aadhar: string;
  bankNumber: string;
  ifsc?: string;
  balance: number;
}

export interface Payment {
  id?: number;
  fromBankNumber: string;
  toBankNumber: string;
  amount: number;
  status?: string;
  createdAt?: string;
}

export interface AuditRecord {
  id?: number;
  paymentId?: number;
  details?: string;
  createdAt?: string;
}

@Injectable({ providedIn: 'root' })
export class AdminService {
  // Updated with full URLs
  private customersBase = 'http://localhost:8765/api/customers';
  private accountsBase  = 'http://localhost:8765/api/accounts';
  private paymentsBase  = 'http://localhost:8765/api/payments';
  private auditBase     = 'http://localhost:8765/api/audit';

  constructor(private http: HttpClient) {}

  // Customers
  addCustomer(payload: Customer): Observable<Customer> {
    return this.http.post<Customer>(`${this.customersBase}/save`, payload);
  }

  getAllCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.customersBase);
  }

  // Accounts
  addAccount(payload: Account): Observable<Account> {
    return this.http.post<Account>(`${this.accountsBase}/add`, payload);
  }

  getAllAccounts(): Observable<Account[]> {
    return this.http.get<Account[]>(this.accountsBase);
  }

  // Payments
  getAllPayments(): Observable<Payment[]> {
    return this.http.get<Payment[]>(this.paymentsBase);
  }

  // Audit
  getAudit(): Observable<AuditRecord[]> {
    return this.http.get<AuditRecord[]>(this.auditBase);
  }

  syncAudit(): Observable<AuditRecord[]> {
    return this.http.post<AuditRecord[]>(`${this.auditBase}/sync`, {});
  }
}
