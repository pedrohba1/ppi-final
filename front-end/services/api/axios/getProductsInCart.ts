import { instance } from './instance'

export const getProductsInCart = async function () {
  const response = await instance.get('/cart')
  return response.data.products
}
