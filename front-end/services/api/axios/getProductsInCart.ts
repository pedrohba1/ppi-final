import axios from 'axios'

export const getProductsInCart = async function () {
  const response = await axios.get('/cart')
  return response.data.products
}
