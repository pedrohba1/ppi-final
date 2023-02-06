import { rest } from 'msw'

export const getProduct = rest.get('/products/', (req, res, ctx) => {
  const productId = req.url.searchParams.get('id')

  return res(
    ctx.json({
      id: productId,
      name: 'carro de rolimã',
      description: 'descrição',
      price: '100.00',
      vendor: 'Bufulin',
      amount: 5,
    })
  )
})
