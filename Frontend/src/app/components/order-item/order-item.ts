import { Component, input } from '@angular/core';
import { Order } from '../../models/order';
import { ProductSet } from '../../models/product-set';

@Component({
  selector: 'app-order-item',
  imports: [],
  templateUrl: './order-item.html',
  styleUrl: './order-item.less'
})
export class OrderItem {
  order = input.required<Order>();
}
