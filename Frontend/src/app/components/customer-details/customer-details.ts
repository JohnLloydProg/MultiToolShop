import { Component, OnInit, signal } from '@angular/core';
import { CustomerServiceModule } from '../../services/customer-service/customer-service-module';
import { Customer } from '../../models/customer';
import { formatDate } from '@angular/common';

@Component({
  selector: 'app-customer-details',
  imports: [],
  templateUrl: './customer-details.html',
  styleUrl: './customer-details.less'
})
export class CustomerDetails implements OnInit {
  service = new CustomerServiceModule()
  customer = signal<Customer|null>(null);
  formatedCreated = signal<string>("");
  formatedBirthdate = signal<string>("");

  ngOnInit(): void {
    if ('customerId' in localStorage) {
      this.service.getById(Number(localStorage.getItem("customerId"))).then(data => {
        this.customer.set(data);
        console.log(data);
        this.formatedCreated.set(formatDate(this.customer()?.created ?? "", "mediumDate", "en-us"));
        this.formatedBirthdate.set(formatDate(this.customer()?.birthdate ?? "", "mediumDate", "en-us"));
      });
      
    }
  }

}
