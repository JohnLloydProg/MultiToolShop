import { Component, input, OnInit, signal } from '@angular/core';
import { ProductSet } from '../../models/product-set';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-product-card',
  imports: [RouterLink],
  templateUrl: './product-card.html',
  styleUrl: './product-card.less'
})
export class ProductCard {
  product = input<ProductSet>();
}
