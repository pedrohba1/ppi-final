import { rest } from 'msw'

export const login = rest.post('/login', (_, res, ctx) => {
  return res(
    ctx.json({
      token: 'bearerTToken',
    })
  )
})
