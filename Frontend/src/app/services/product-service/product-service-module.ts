import { inject, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient, provideHttpClient, withFetch } from '@angular/common/http';
import { ProductSet } from '../../models/product-set';
import { firstValueFrom } from 'rxjs';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class ProductServiceModule { 
  private httpClient = inject(HttpClient);

  getProductSet(id:number):Promise<ProductSet> {
    const observable = this.httpClient.get<ProductSet>(`http://localhost:8086/api/set/${id}`)
    return firstValueFrom(observable);
  }

  getProductSets():Promise<ProductSet[]> {
    const observable = this.httpClient.get<ProductSet[]>("http://localhost:8086/api/set")
    return firstValueFrom(observable);
  }

  getPopularProduct(length:number):Promise<ProductSet[]> {
    const observable = this.httpClient.get<ProductSet[]>(`http://localhost:8086/api/set/popular/${length}`);
    return firstValueFrom(observable);
  }
}
