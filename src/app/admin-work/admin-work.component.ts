import { Component } from '@angular/core';
import { Restaurant } from '../restaurant';
import { RestaurantServiceOperationsService } from '../restaurant-service-operations.service';

@Component({
  selector: 'app-admin-work',
  templateUrl: './admin-work.component.html',
  styleUrls: ['./admin-work.component.css']
})
export class AdminWorkComponent {
  __restaurantService: RestaurantServiceOperationsService;

  constructor(restaurantService: RestaurantServiceOperationsService) {
    this.__restaurantService = restaurantService;
  }

  readRestaurants( restaurantName:string,
    managerName:string,
   contactNumber:string,
    buildingName:string,
    area:string,
   streetNo:string,
   city:string,
   state:string,
   country:string,
   pincode:string,
   imageName:string){
    console.log(restaurantName+" "+managerName+" "+contactNumber+" "+buildingName+""+country);
    let restaurantFromUser:Restaurant= new Restaurant(restaurantName,managerName,contactNumber,buildingName,area,streetNo,city,state,country,pincode,imageName);
    this.__restaurantService.addRestaurants(restaurantFromUser);
    

  }

}
