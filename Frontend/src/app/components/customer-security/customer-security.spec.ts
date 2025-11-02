import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerSecurity } from './customer-security';

describe('CustomerSecurity', () => {
  let component: CustomerSecurity;
  let fixture: ComponentFixture<CustomerSecurity>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CustomerSecurity]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomerSecurity);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
