import { instance } from "./instance"

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
  const response = await instance.post('/register', {
    username,
    password,
    repeatPassword,
  })
  return response.data
}
