import Vue from 'vue'

import { instance } from './instance'
type IPostProduct = {
  name: string
  description: string
  price: number
  amount: number
}

export const createProduct = async function (data: IPostProduct) {
  try {
    const response = await instance.post('/products/create', data)

    Vue.$toast.open('success')

    return response.data
  } catch (e) {
    Vue.$toast.error('erro ao criar produto')
  }
}
