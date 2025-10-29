import { inject, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Customer } from '../../models/customer';
import { firstValueFrom } from 'rxjs';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class CustomerServiceModule {
  private httpClient = inject(HttpClient);

  async login(email:string, password:string):Promise<Customer> {
    const observable = this.httpClient.get<Customer>("http://localhost:8086/api/customer", {
      headers: new HttpHeaders({"email":email, "password":password})
    });
    return firstValueFrom(observable);
  }

  async getById(id:number):Promise<Customer> {
    const observable = this.httpClient.get<Customer>(`http://localhost:8086/api/customer/${id}`);
    return firstValueFrom(observable);
  }
}
