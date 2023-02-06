import { rest } from 'msw'

export const getProducts = rest.get('/products/list', (_, res, ctx) => {
  const products = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10].map((item) => ({
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
