import { Routes } from '@angular/router';
import { Home } from './home/home';
import { Orders } from './orders/orders';
import { About } from './about/about';
import { Products } from './products/products';
import { Product } from './product/product';
import { Profile } from './profile/profile';
import { CustomerDetails } from './components/customer-details/customer-details';
import { CustomerSecurity } from './components/customer-security/customer-security';
import { Registration } from './registration/registration';

export const routes: Routes = [
    {path:"", component:Home},
    {path:"orders", component:Orders}, {path:"about", component:About},
    {path:"products", component:Products}, {path:"product/:id", component:Product},
    {path:"registration", component:Registration},
    {path:"profile", component:Profile, children:[
        {path:"", redirectTo:"details", pathMatch:'full'},
        {path:"details", component:CustomerDetails}, 
        {path:"security", component:CustomerSecurity}
    ]}
];
