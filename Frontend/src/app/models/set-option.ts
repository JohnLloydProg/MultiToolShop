import { ProductOption } from "./product-option";

export interface SetOption {
    id:number,
    setId:number,
    multiToolOption:ProductOption,
    addedPrice:number,
    created:Date,
    updated:Date
}
