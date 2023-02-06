export interface Product {
  id: string
  name: string
  description: string
  price: number
  amount: number
  image: string
  seller: {
    id: string
    username: string
    roles: {
      id: number
      name: string
    }[]
  }
}
