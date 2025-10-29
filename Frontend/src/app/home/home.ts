import { Component, OnInit, signal } from '@angular/core';
import { ProductCard } from '../components/product-card/product-card';
import { ProductSet } from '../models/product-set';
import { ProductServiceModule } from '../services/product-service/product-service-module';

@Component({
  selector: 'app-home',
  imports: [ProductCard],
  templateUrl: './home.html',
  styleUrl: './home.less'
})
export class Home implements OnInit{
  private service = new ProductServiceModule();
  products = signal<ProductSet[]>([]);

  ngOnInit(): void {
      this.service.getPopularProduct(3).then((data) => this.products.set(data));
  }

}
