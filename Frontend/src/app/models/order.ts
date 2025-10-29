import { Customer } from "./customer";
import { SetOption } from "./set-option";

export interface Order {
    id:number,
    customer:Customer,
    options:SetOption[],
    totalPrice:number,
    status:string,
    created:Date
}
