import { Component, OnInit, signal } from '@angular/core';
import { Customer } from '../models/customer';
import { CustomerServiceModule } from '../services/customer-service/customer-service-module';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { RouterOutlet, RouterLinkWithHref } from '@angular/router';

@Component({
  selector: 'app-profile',
  imports: [ReactiveFormsModule, RouterOutlet, RouterLinkWithHref],
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
    this.service.login(this.login.get("email")?.value ?? '', this.login.get("password")?.value ?? '').then((data) => {
      this.customer.set(data);
      localStorage.setItem("customerId", ""+data.id);
      console.log(data);
    }).catch((reason) => {
      alert("Wrong email or password!");
    })
  }

  logout() {
    localStorage.removeItem("customerId");
    this.customer.set(null);
  }
}
