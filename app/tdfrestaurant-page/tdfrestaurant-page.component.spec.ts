import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TDFRestaurantPageComponent } from './tdfrestaurant-page.component';

describe('TDFRestaurantPageComponent', () => {
  let component: TDFRestaurantPageComponent;
  let fixture: ComponentFixture<TDFRestaurantPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TDFRestaurantPageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TDFRestaurantPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
