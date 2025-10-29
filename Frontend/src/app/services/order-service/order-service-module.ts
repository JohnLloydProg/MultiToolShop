import { inject, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Order } from '../../models/order';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class OrderServiceModule {
  private httpClient = inject(HttpClient);

  checkout(order:Order) {
    this.httpClient.post("http://localhost:8086/api/order", order);
  }

  getByCustomerId(id:number) {

  }
}
