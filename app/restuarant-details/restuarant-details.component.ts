import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Restaurant } from '../restaurant';
import { RestaurantOperationsService } from '../restaurant-operations.service';

@Component({
  selector: 'app-restuarant-details',
  templateUrl: './restuarant-details.component.html',
  styleUrls: ['./restuarant-details.component.css']
})
export class RestuarantDetailsComponent {

  __restuarantService:RestaurantOperationsService; // creating object of Service layer
  router:Router;
  activeRoute:ActivatedRoute;
  r:Restaurant = new Restaurant(0,'','','','','','','','');
    constructor(restaurantService:RestaurantOperationsService,router:Router,activeRoute:ActivatedRoute)
  {
    this.__restuarantService = restaurantService;
    this.router = router;
    this.activeRoute = activeRoute;

    let searchRestaurantId= this.activeRoute.snapshot.params['rid']; // extract value from prameter(URI)
    console.log(searchRestaurantId);
    this.r = this.__restuarantService.getRestaurantByNumber(parseInt(searchRestaurantId)); // get data from service class
    console.log(this.r);

}
}
