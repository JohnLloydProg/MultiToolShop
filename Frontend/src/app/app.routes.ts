import { Routes } from '@angular/router';
import { Home } from './home/home';
import { Orders } from './orders/orders';
import { About } from './about/about';
import { Products } from './products/products';
import { Product } from './product/product';
import { Profile } from './profile/profile';

export const routes: Routes = [
    {path:"", component:Home},
    {path:"orders", component:Orders}, {path:"about", component:About},
    {path:"products", component:Products}, {path:"product/:id", component:Product},
    {path:"profile", component:Profile}
];
