import { Component, input, OnInit, signal } from '@angular/core';
import { ProductSet } from '../models/product-set';
import { ProductServiceModule } from '../services/product-service/product-service-module';
import { Form, FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { SetOptionServiceModule } from '../services/set-option-service/set-option-service-module';
import { SetOption } from '../models/set-option';
import { OrderServiceModule } from '../services/order-service/order-service-module';
import { Order } from '../models/order';
import { CustomerServiceModule } from '../services/customer-service/customer-service-module';

@Component({
  selector: 'app-product',
  imports: [ReactiveFormsModule],
  templateUrl: './product.html',
  styleUrl: './product.less'
})
export class Product implements OnInit{
  private setService = new ProductServiceModule();
  private optionService = new SetOptionServiceModule();
  private orderService = new OrderServiceModule();
  private customerService = new CustomerServiceModule();

  id = input.required<number>();
  product = signal<ProductSet|null>(null);
  options_by_category = signal<Map<string, SetOption[]>>(new Map<string, SetOption[]>());
  customizations_category = signal<Map<string, number>>(new Map<string, number>());
  multiple = new FormGroup({});
  single = new FormGroup({});
  order = new FormGroup({
    "multiple": this.multiple,
    "single": this.single
  });
  totalPrice = signal<number>(0);

  ngOnInit(): void {
      this.setService.getProductSet(this.id()).then(data => this.product.set(data));
      this.optionService.getSetOptionsBySet(this.id()).then(data => {
        for (const setOption of data) {
          if (!this.options_by_category().has(setOption.multiToolOption.categoryName)) {
            this.options_by_category().set(setOption.multiToolOption.categoryName, []);
          }
          this.options_by_category().get(setOption.multiToolOption.categoryName)?.push(setOption);
          if (!(setOption.multiToolOption.categoryName in this.single.controls) && !setOption.multiToolOption.multiple) {
            this.single.addControl(setOption.multiToolOption.categoryName, new FormControl<SetOption|null>(null));
          }
        }
      });
      this.order.valueChanges.subscribe((observer) => {
        let customizationTotal = 0;
        for (let control of Object.values<FormControl<SetOption>>(this.multiple.controls)) {
          customizationTotal += control.value?.addedPrice ?? 0;
        }
        for (let control of Object.values<FormControl<SetOption>>(this.single.controls)) {
          customizationTotal += control.value?.addedPrice ?? 0;
        }
        this.totalPrice.set((this.product()?.basePrice ?? 0) + customizationTotal);
      });
  }

  range(n: number): number[] {
    return Array.from({ length: n }, (_, i) => i);
  }

  addClicked(category:string) {
    if ([...this.customizations_category().values()].reduce((a, b) => a + b, 0) < (this.product()?.customizations ?? 0)) {
      if (!this.customizations_category().has(category)) {
        this.customizations_category().set(category, 0);
      }
      let num = this.customizations_category().get(category) ?? 0;
      this.multiple.addControl(`${category}-${num}`, new FormControl<SetOption|null>(null));
      this.customizations_category().set(category, num + 1)
    }
  }

  getMultipleKeys() {
    return Object.keys(this.multiple.controls);
  }

  getSingleKeys() {
    return Object.keys(this.single.controls);
  }

  getControlValues(): SetOption[] {
    let array:SetOption[] = [];
    for (let control of Object.values<FormControl<SetOption>>(this.multiple.controls)) {
      array.push(control.value as SetOption);
    }
    for (let control of Object.values<FormControl<SetOption>>(this.single.controls)) {
      array.push(control.value as SetOption);
    }
    return array;
  }

  validateForm() {
    for (let control of Object.values<FormControl>(this.multiple.controls)) {
      if (control.value === null) {
        return true;
      }
    }
    for (let control of Object.values<FormControl>(this.single.controls)) {
      if (control.value === null) {
        return true;
      }
    }

    return (this.getMultipleKeys().length < (this.product()?.customizations ?? 0))
  }

  removeClicked(category:string) {
    if (this.customizations_category().get(category) ?? 0 > 0) {
      this.customizations_category().set(category, (this.customizations_category().get(category) ?? 0) - 1)
      this.multiple.removeControl(`${category}-${(this.customizations_category().get(category) ?? 0)}`);
    }
  }

  checkout() {
    if ("customerId" in localStorage) {
      this.customerService.getById(Number.parseInt(localStorage.getItem("customerId") ?? "0")).then(customer => {
        var orderDetails:Order = {
          customer:customer,
          multiToolSet:this.product(),
          options:this.getControlValues(),
          totalPrice:this.totalPrice(),
          status:"PENDING"
        };
        this.orderService.checkout(orderDetails).then(data => {
          alert("Your order has been made!");
        });
      })
      
    }else {
      alert("You have not logged in yet!");
    }
    
  }
}
