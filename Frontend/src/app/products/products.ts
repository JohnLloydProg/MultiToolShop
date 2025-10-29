import { Component, ElementRef, OnInit, signal, ViewChild } from '@angular/core';
import { ProductCard } from '../components/product-card/product-card';
import { ProductServiceModule } from '../services/product-service/product-service-module';
import { ProductSet } from '../models/product-set';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { OptionCategoryServiceModule } from '../services/option-category-service/option-category-service-module';

@Component({
  selector: 'app-products',
  imports: [ProductCard, ReactiveFormsModule],
  templateUrl: './products.html',
  styleUrl: './products.less'
})
export class Products implements OnInit {
  private service:ProductServiceModule = new ProductServiceModule();
  products = signal<ProductSet[]>([]);
  filter = new FormGroup({
    outStock : new FormControl(true),
    inStock : new FormControl(true),
    type1 : new FormControl(true),
    type2 : new FormControl(true),
    type3 : new FormControl(true),
  })
  
  showAvailability:boolean = false;
  showTypes:boolean = false;

  ngOnInit(): void {
      this.service.getProductSets().then(data => this.products.set(data));
      this.filter.valueChanges.subscribe((data) => {
        this.service.getProductSets().then((products) => {
          const filtered = products.filter(productSet => {
            return ((data.inStock?.valueOf() && productSet.stock > 0) || 
                  (data.outStock?.valueOf() && productSet.stock === 0)) &&
                  ((data.type1?.valueOf() && productSet.name.includes("Type 1")) ||
                  (data.type2?.valueOf() && productSet.name.includes("Type 2")) ||
                  (data.type3?.valueOf() && productSet.name.includes("Type 3")));
          });
          this.products.set(filtered);
        });
      })
  }

  clickedAvailability() {
    this.showAvailability = !this.showAvailability;
  }

  clickedTypes() {
    this.showTypes = !this.showTypes;
  }
}
