import { Component, OnInit, signal } from '@angular/core';
import { OrderItem } from '../components/order-item/order-item';
import { OrderServiceModule } from '../services/order-service/order-service-module';
import { Order } from '../models/order';

@Component({
  selector: 'app-orders',
  imports: [OrderItem],
  templateUrl: './orders.html',
  styleUrl: './orders.less'
})
export class Orders implements OnInit{
  private service = new OrderServiceModule();
  orders = signal<Order[]>([]);

  ngOnInit(): void {
      this.service.getByCustomerId(Number.parseInt(localStorage.getItem("customerId") ?? "0")).then(data => this.orders.set(data));
  }

  refresh() {
    console.log("A order has been cancelled!");
    this.service.getByCustomerId(Number.parseInt(localStorage.getItem("customerId") ?? "0")).then(data => this.orders.set(data))
  }

}
