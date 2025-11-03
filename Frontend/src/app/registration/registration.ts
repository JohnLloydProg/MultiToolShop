import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { CustomerServiceModule } from '../services/customer-service/customer-service-module';
import { Customer } from '../models/customer';

@Component({
  selector: 'app-registration',
  imports: [ReactiveFormsModule],
  templateUrl: './registration.html',
  styleUrl: './registration.less'
})
export class Registration {
  private service = new CustomerServiceModule();

  registration = new FormGroup({
    firstName:new FormControl<string>(""),
    middlName:new FormControl<string>(""),
    lastName:new FormControl<string>(""),
    email:new FormControl<string>(""),
    password:new FormControl<string>(""),
    confirmPass:new FormControl<string>(""),
    address:new FormControl<string>(""),
    contactNumber:new FormControl<string>(""),
    birthDate:new FormControl<Date|null>(null),
  });

  register() {
    if (this.registration.get("password")?.value != this.registration.get("confirmPass")?.value) {
      alert("The two passwords are not the same!");
      return;
    }


    let customer:Customer = {
      firstName:this.registration.get("firstName")?.value!,
      middleName:this.registration.get("middlName")?.value!,
      lastName:this.registration.get("lastName")?.value!,
      email:this.registration.get("email")?.value!,
      password:this.registration.get("password")?.value!,
      address:this.registration.get("address")?.value!,
      contactNumber:this.registration.get("contactNumber")?.value!,
      birthdate:this.registration.get("birthDate")?.value!
    };
    this.service.register(customer).then(data => {
      alert("You have successfully registered your account!");
    })
  }
}
