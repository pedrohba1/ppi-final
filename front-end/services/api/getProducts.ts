import axios from 'axios'

export const getProducts = async function (){
  const response = await axios.post('/products')
  return response.data.message
}