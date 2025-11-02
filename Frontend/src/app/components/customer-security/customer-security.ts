import { Component, OnInit, signal } from '@angular/core';
import { CustomerServiceModule } from '../../services/customer-service/customer-service-module';
import { Customer } from '../../models/customer';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-customer-security',
  imports: [ReactiveFormsModule],
  templateUrl: './customer-security.html',
  styleUrl: './customer-security.less'
})
export class CustomerSecurity implements OnInit{
  private service = new CustomerServiceModule();
  changePass = new FormGroup({
    newPass:new FormControl<string>(""),
    confirmPass:new FormControl<string>("")
  });
  
  customer = signal<Customer|null>(null);

  ngOnInit(): void {
    if ('customerId' in localStorage) {
      this.service.getById(Number(localStorage.getItem('customerId'))).then(data => this.customer.set(data));
    }
  }

  changePassRequest() {
    if (this.changePass.get("newPass")?.value != this.changePass.get("confirmPass")?.value) {
      alert("The two passwords are not the same!");
      return
    }
    if (this.changePass.get("newPass")?.value === this.customer()?.password) {
      alert("New password can't be the same as the current one!");
      return
    }

    if (this.customer()){
      this.customer()!.password = this.changePass.get("newPass")?.value!;
      this.service.update(this.customer()!).then(data => alert("You password has been changed!"))
    }
  }

}
