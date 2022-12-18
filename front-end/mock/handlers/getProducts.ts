import { rest } from 'msw'

export const getProducts = rest.get('/products', (_, res, ctx) => {
  return res(
    ctx.json({
      message: 'it works :)',
    })
  )
})
