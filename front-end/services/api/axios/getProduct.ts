import {instance} from "./instance"

import { Product } from "~/types/product"
type IGetProduct = {
  id: string
}

export const getProduct = async function ({ id }: IGetProduct) {
  const response = await instance.get<Product>(`/products/${id}`)
  return response.data
}
