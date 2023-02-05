import {instance} from "./instance"
type IPostProduct = {
  name: string;
  description: string;
  price: number;
  amount: number;
}

export const createProduct = async function (data: IPostProduct) {
  const response = await instance.post('/product', data)
  return response.data
}
