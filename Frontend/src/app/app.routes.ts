import { Routes } from '@angular/router';
import { Home } from './home/home';
import { Cart } from './cart/cart';
import { Orders } from './orders/orders';
import { About } from './about/about';
import { Products } from './products/products';

export const routes: Routes = [
    {path:"", component:Home}, {path:"cart", component:Cart},
    {path:"orders", component:Orders}, {path:"about", component:About},
    {path:"products", component:Products}
];
