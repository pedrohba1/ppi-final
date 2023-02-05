import {instance} from "./instance"
type IGetProduct = {
  id: string
}

export const getProduct = async function ({ id }: IGetProduct) {
  const response = await instance.get('/product', { params: { id } })
  return response.data
}
