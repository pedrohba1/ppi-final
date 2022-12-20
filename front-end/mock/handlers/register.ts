import { rest } from 'msw'

export const register = rest.post('/register', (_, res, ctx) => {
  return res(
    ctx.json({
      auth: 'bearerTToken',
    })
  )
})
