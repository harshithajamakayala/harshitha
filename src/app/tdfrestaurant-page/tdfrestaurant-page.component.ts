import { Component, OnInit } from '@angular/core';
import { Restaurant } from '../restaurant';
import { RestaurantOperationsService } from '../restaurant-operations.service';

@Component({
  selector: 'app-tdfrestaurant-page',
  templateUrl: './tdfrestaurant-page.component.html',
  styleUrls: ['./tdfrestaurant-page.component.css']
})
export class TDFRestaurantPageComponent implements OnInit {


  __restuarantService: RestaurantOperationsService; // creating object of Service layer
  r: Restaurant = new Restaurant(0, '', '', '', '', '', '', '', '');
  constructor(restaurantService: RestaurantOperationsService) {
    this.__restuarantService = restaurantService;
    console.log(this.r);
  }

  ngOnInit() {

  }
  submitingRestaurants() {

    this.__restuarantService.addRestaurants(this.r);
    console.log(this.r);

  }

}

