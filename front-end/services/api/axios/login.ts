import Vue from 'vue'
import { instance } from './instance'

import 'vue-toast-notification/dist/theme-sugar.css'

type ILogin = {
  username: string
  password: string
}

type LoginRes = {
  token: string
}

export const login = async function ({ username, password }: ILogin) {
  try {
    const response = await instance.post<LoginRes>('/auth/signin', {
      username,
      password,
    })
    localStorage.setItem('token', response.data.token)

    Vue.$toast.open('success')

    return response.data
  } catch (e) {
    Vue.$toast.error('failed')
  }
}
