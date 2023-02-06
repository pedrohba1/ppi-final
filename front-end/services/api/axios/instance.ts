import axios, { AxiosRequestConfig } from 'axios'

const instance = axios.create({
  baseURL:
    process.env.ENABLE_MOCK === 'enabled'
      ? `http://localhost:${process.env.PORT}`
      : process.env.BASE_URL,
})

instance.interceptors.request.use(
  (config: AxiosRequestConfig) => {
    const token = localStorage.getItem('token')

    if (token) {
      config.headers.Authorization = `Bearer ${token}`
    }

    return config
  },
  (error) => Promise.reject(error)
)

export { instance }
