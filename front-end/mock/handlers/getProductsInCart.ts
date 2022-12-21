import { rest } from 'msw'

export const getProductsInCart = rest.get('/cart', (_, res, ctx) => {
  const products = [1, 2, 3].map((item) => ({
    id: item,
    name: 'carro de rolimã',
    description: 'descrição',
    price: '100.00',
    vendor: 'Bufulin',
    amount: 5,
  }))

  return res(
    ctx.json({
      products,
    })
  )
})