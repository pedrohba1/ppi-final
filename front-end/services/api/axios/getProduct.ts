import axios from 'axios'

type IGetProduct = {
  id: string
}

export const getProduct = async function ({ id }: IGetProduct) {
  const response = await axios.get('/product', { params: { id } })
  return response.data
}
