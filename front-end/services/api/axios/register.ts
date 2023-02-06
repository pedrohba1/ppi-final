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

  // check if password and repeat password mismatches 

  const response = await instance.post('/auth/signup', {
    username,
    password,
  })
  return response.data
}
