import { inject, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Order } from '../../models/order';
import { firstValueFrom } from 'rxjs';
import { environment } from '../../../environments/environment';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class OrderServiceModule {
  private httpClient = inject(HttpClient);

  checkout(order:Order):Promise<Order> {
    const observable = this.httpClient.post<Order>(`${environment.apiUrl}/api/order`, order);
    return firstValueFrom(observable);
  }

  getByCustomerId(id:number):Promise<Order[]> {
    const observable = this.httpClient.get<Order[]>(`${environment.apiUrl}/api/orders/${id}`);
    return firstValueFrom(observable);
  }

  cancelOrder(id:number):Promise<string> {
    const observable = this.httpClient.delete(`${environment.apiUrl}/api/order/${id}`, {responseType: "text"});
    return firstValueFrom(observable);
  }
}
