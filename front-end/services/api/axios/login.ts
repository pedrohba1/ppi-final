import axios from 'axios'

type ILogin = {
  username: string
  password: string
}

type LoginRes = {
  token:string;
}

export const login = async function ({ username, password }: ILogin) {
  const response = await axios.post<LoginRes>('/login', { username, password })
  localStorage.setItem("token", response.data.token)
  return response.data
}
