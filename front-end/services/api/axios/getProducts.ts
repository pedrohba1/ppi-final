import { instance } from "./instance"

export const getProducts = async function () {
  const response = await instance.get('/products')
  return response.data.products
}
