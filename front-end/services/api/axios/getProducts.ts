import axios from 'axios'

export const getProducts = async function () {
  const response = await axios.get('/products')
  return response.data.products
}
