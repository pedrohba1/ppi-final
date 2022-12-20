import axios from 'axios'

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
  const response = await axios.post('/register', {
    username,
    password,
    repeatPassword,
  })
  return response.data
}
