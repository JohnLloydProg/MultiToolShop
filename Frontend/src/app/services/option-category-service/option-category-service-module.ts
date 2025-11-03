import { inject, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { OptionCategory } from '../../models/option-category';
import { firstValueFrom } from 'rxjs';
import { environment } from '../../../environments/environment';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class OptionCategoryServiceModule { 
  private httpClient = inject(HttpClient);

  async getAll():Promise<OptionCategory[]> {
    const observable = this.httpClient.get<OptionCategory[]>(`${environment.apiUrl}/api/option-category`);
    return firstValueFrom(observable)
  }
}
