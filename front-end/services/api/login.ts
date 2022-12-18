import axios from 'axios'

type ILogin = {
  username: string
  password: string
}

export const login = async function ({ username, password }: ILogin) {
  const response = await axios.post('/login', { username, password })
  return response.data.message
}
