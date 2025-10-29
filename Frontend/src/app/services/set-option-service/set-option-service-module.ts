import { inject, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { SetOption } from '../../models/set-option';
import { firstValueFrom } from 'rxjs';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class SetOptionServiceModule {
  private httpClient = inject(HttpClient);

  async getSetOptionsBySet(setId:number):Promise<SetOption[]> {
    const observable = this.httpClient.get<SetOption[]>(`http://localhost:8086/api/set-option/set/${setId}`)
    return firstValueFrom(observable);
  }

}
