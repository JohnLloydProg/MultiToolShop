import { Component } from '@angular/core';
import { OrderItem } from '../components/order-item/order-item';

@Component({
  selector: 'app-orders',
  imports: [OrderItem],
  templateUrl: './orders.html',
  styleUrl: './orders.less'
})
export class Orders {

}
