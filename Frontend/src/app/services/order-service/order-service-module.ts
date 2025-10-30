import { inject, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Order } from '../../models/order';
import { firstValueFrom } from 'rxjs';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class OrderServiceModule {
  private httpClient = inject(HttpClient);

  checkout(order:Order):Promise<Order> {
    const observable = this.httpClient.post<Order>("http://localhost:8086/api/order", order);
    return firstValueFrom(observable);
  }

  getByCustomerId(id:number):Promise<Order[]> {
    const observable = this.httpClient.get<Order[]>(`http://localhost:8086/api/orders/${id}`);
    return firstValueFrom(observable);
  }
}
