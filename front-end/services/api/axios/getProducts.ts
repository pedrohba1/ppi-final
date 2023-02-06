import { instance } from "./instance"


import { Product } from "~/types/product";

export const getProducts = async function () {
  const response = await instance.get<Product[]>('/products/list')
  return response.data;
}
