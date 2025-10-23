import { Component, ElementRef, ViewChild } from '@angular/core';
import { ProductCard } from '../components/product-card/product-card';

@Component({
  selector: 'app-products',
  imports: [ProductCard],
  templateUrl: './products.html',
  styleUrl: './products.less'
})
export class Products {
  showAvailability:boolean = false;
  showTypes:boolean = false;

  clickedAvailability() {
    this.showAvailability = !this.showAvailability;
  }

  clickedTypes() {
    this.showTypes = !this.showTypes;
  }
}
