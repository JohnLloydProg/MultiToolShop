import { Customer } from "./customer";
import { ProductSet } from "./product-set";
import { SetOption } from "./set-option";

export interface Order {
    id?:number,
    customer:Customer,
    multiToolSet:ProductSet|null,
    options:SetOption[],
    totalPrice:number,
    status?:string,
    created?:Date
}
