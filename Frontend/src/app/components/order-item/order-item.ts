import { Component, EventEmitter, input, Output } from '@angular/core';
import { Order } from '../../models/order';
import { ProductSet } from '../../models/product-set';
import { OrderServiceModule } from '../../services/order-service/order-service-module';

@Component({
  selector: 'app-order-item',
  imports: [],
  templateUrl: './order-item.html',
  styleUrl: './order-item.less'
})
export class OrderItem {
  private service = new OrderServiceModule();
  @Output() onCancelled = new EventEmitter<void>();

  order = input.required<Order>();

  cancel() {
    console.log(this.order());
    this.service.cancelOrder(this.order().id!).then(data => {
      this.onCancelled.emit();
      alert("Your order has been cancelled!");
    })
  }
}
