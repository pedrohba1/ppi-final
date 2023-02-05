import { instance } from "./instance"

export const getProducts = async function () {
  const response = await instance.get('/products')

  console.log('produts', response.data)
  return response.data.products
}
