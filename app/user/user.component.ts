import { Component } from '@angular/core';
import { Restaurant } from '../restaurant';
import { RestaurantOperationsService } from '../restaurant-operations.service';
import { ActivatedRoute, Route, Router } from '@angular/router';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {

  __restaurantService:RestaurantOperationsService;
  router:Router;

  allRestaurants:Array<Restaurant>=[];
 


  constructor(restaurantService:RestaurantOperationsService,router:Router){
    this.__restaurantService=restaurantService;
    this.allRestaurants=this.__restaurantService.getRestaurantArr();
    this.router=router;
  }

  viewRestaurantDetails(rid:string)
  {
    
    this.router.navigate(['restaurantDetails',rid]);
  }
  

  getFilterData(filterValue:string)
  {
    console.log(" Filter Value "+filterValue);

    this.allRestaurants = this.__restaurantService.getRestaurantById(filterValue);
  }

  getFilterMenu(filterValue:string){
    this.allRestaurants=this.__restaurantService.getRestaurantById(filterValue);
  }

  getFilterRatings(filterValue:string){
    this.allRestaurants=this.__restaurantService.getRestaurantByRatings(filterValue);

  }
}
