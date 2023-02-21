export class RestaurantDTO {
    restaurantId:number;
	restaurantName:string;
	restaurantContactNumber:string;

    constructor(restaurantId:number,
        restaurantName:string,
        restaurantContactNumber:string){
       
            this.restaurantId=restaurantId;
            this.restaurantName=restaurantName;
            this.restaurantContactNumber=restaurantContactNumber;
    }

}
