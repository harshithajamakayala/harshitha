import { Component } from '@angular/core';
import { Restaurant } from '../restaurant';
import { RestaurantOperationsService } from '../restaurant-operations.service';

@Component({
  selector: 'app-admin-work',
  templateUrl: './admin-work.component.html',
  styleUrls: ['./admin-work.component.css']
})
export class AdminWorkComponent {

  __restaurantService: RestaurantOperationsService;

  constructor(restaurantService: RestaurantOperationsService) {
    this.__restaurantService = restaurantService;
  }

  readRestaurant(restaurantId: string,
    restaurantName: string,
    location: string,
    restaurantOwner: string,
    category: string,
    imageName: string,
    ratings: string,
    discription:string,
    contactNumber: string) {
      console.log(restaurantId+""+restaurantName+""+restaurantOwner+""+location+""+category+""+imageName+""+ratings+""+discription+""+contactNumber);
      let restaurantFromUser:Restaurant= new Restaurant(parseInt(restaurantId),restaurantName,location,restaurantOwner,category,imageName,ratings,discription,contactNumber)
      this.__restaurantService.addRestaurants(restaurantFromUser);

  }


}
