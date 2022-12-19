import { rest } from 'msw'

export const getProduct = rest.get('/product', (req, res, ctx) => {
  const productId = req.url.searchParams.get('id')

  return res(
    ctx.json({
      id: productId,
      name: 'produto',
      description: "descrição",
      price: "100.00",
      amount: 5
    })
  )
})
