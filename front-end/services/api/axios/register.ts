import Vue from 'vue'
import { instance } from './instance'

type IRegister = {
  username: string
  password: string
  repeatPassword: string
}

export const register = async function ({
  username,
  password,
  repeatPassword,
}: IRegister) {
  try {
    // check if password and repeat password mismatches

    if (password !== repeatPassword) {
      Vue.$toast.error('password mismatch')
      return
    }

    const response = await instance.post('/auth/signup', {
      username,
      password,
    })

    Vue.$toast.open('success')

    return response.data
  } catch (e) {
    Vue.$toast.error('erro no cadastro. Seu email está formatado corretamente?')
  }
}
