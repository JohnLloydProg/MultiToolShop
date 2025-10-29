import { Component, OnInit, signal } from '@angular/core';
import { Customer } from '../models/customer';
import { CustomerServiceModule } from '../services/customer-service/customer-service-module';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-profile',
  imports: [ReactiveFormsModule],
  templateUrl: './profile.html',
  styleUrl: './profile.less'
})
export class Profile implements OnInit{
  private service = new CustomerServiceModule();
  customer = signal<Customer|null>(null);
  login = new FormGroup({
    "email": new FormControl(''),
    "password": new FormControl('')
  });

  ngOnInit(): void {
      if ('customerId' in localStorage) {
        this.service.getById(Number(localStorage.getItem('customerId'))).then((data) => this.customer.set(data));
      }
  }

  getDetails() {
    return Object.entries(this.customer() ?? {}).map(([key, value]) => ({key, value}));
  }

  loginClick() {
    console.log(`Email: ${this.login.get("email")?.value}, Password: ${this.login.get("password")?.value}`)
    this.service.login(this.login.get("email")?.value ?? '', this.login.get("password")?.value ?? '').then((data) => {
      this.customer.set(data);
      localStorage.setItem("customerId", ""+data.id);
      console.log(data);
    })
  }

  logout() {
    localStorage.removeItem("customerId");
    this.customer.set(null);
  }
}
