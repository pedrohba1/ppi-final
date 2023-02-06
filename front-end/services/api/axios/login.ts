import { instance } from "./instance";

type ILogin = {
  username: string
  password: string
}

type LoginRes = {
  token:string;
}

export const login = async function ({ username, password }: ILogin) {
  const response = await instance.post<LoginRes>('/login', { username, password })
  localStorage.setItem("token", response.data.token)
  return response.data
}
