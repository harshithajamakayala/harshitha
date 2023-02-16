import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';
import { AdminWorkComponent } from './admin-work/admin-work.component';
import { DiscriptionPipe } from './discription-pipe';
import { RestuarantDetailsComponent } from './restuarant-details/restuarant-details.component';
import { RouterModule,Routes } from '@angular/router';
import {FormsModule} from '@angular/forms';
import { UpcomingOffersComponent } from './upcoming-offers/upcoming-offers.component';
import { TDFRestaurantPageComponent } from './tdfrestaurant-page/tdfrestaurant-page.component';

const allLinks:Routes = [
  {path:'launchrestuarant',component:AdminWorkComponent},
  {path:'restaurants',component:UserComponent},
  {path:'upcomingoffers',component:UpcomingOffersComponent },
  {path:'restaurantDetails/:rid',component:RestuarantDetailsComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    AdminWorkComponent,
    DiscriptionPipe,
    RestuarantDetailsComponent,
    UpcomingOffersComponent,
    TDFRestaurantPageComponent
  ],
  imports: [
    BrowserModule,RouterModule.forRoot(allLinks),
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
