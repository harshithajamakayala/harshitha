import { Injectable } from '@angular/core';
import { Restaurant } from './restaurant';

@Injectable({
  providedIn: 'root'
})
export class RestaurantOperationsService {

  constructor() { }

  restaurantArr:Restaurant[]=[];

  addRestaurants(restaurantFromUser:Restaurant){
    this.restaurantArr.push(restaurantFromUser); 
    console.log("Inside Restaurant Service : Restuarant Added "+restaurantFromUser.restaurantId);
    console.log(" Total Restaurant Are :- "+this.restaurantArr.length);
  }

  getRestaurantArr():Restaurant[]
  {
    return this.restaurantArr;
  }

  getRestaurantByNumber(searchRestaurantId:number):Restaurant
  {
    let outputRest:Restaurant = new Restaurant(0,'','','','','','','','');
    for(let i=0;i<this.restaurantArr.length;i++)
    {
      let thisRest:Restaurant = this.restaurantArr[i];
        if(thisRest.restaurantId == searchRestaurantId)
        {
          outputRest = thisRest;
          break;
        }
    }
    
    return outputRest;
  }


  getRestaurantById(filterCategory:string):Restaurant[]
  {
    // localhost:8080/api/course/{category}
   let outputArr:Restaurant[] = [];

    this.restaurantArr.forEach(r=>{
      if(r.location == filterCategory)
      {
        outputArr.push(r);
      }
      if(r.category==filterCategory){
        outputArr.push(r);
      }
    });

    return outputArr;
  }
  getRestaurantByRatings(filterCategory:string):Restaurant[]
  {
    // localhost:8080/api/course/{category}
   let outputArr:Restaurant[] = [];

    this.restaurantArr.forEach(r=>{
      
      if(r.location==filterCategory && r.ratings>"4"){
        outputArr.push(r);
      }
    });

    return outputArr;
  }
  
  

  

}
