import axios, { AxiosRequestConfig } from 'axios';

const instance = axios.create({
  baseURL: 'your_api_base_url'
});

instance.interceptors.request.use(
  (config: AxiosRequestConfig) => {
    const token = localStorage.getItem('token');

    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }

    return config;
  },
  error => Promise.reject(error)
);

export {instance};