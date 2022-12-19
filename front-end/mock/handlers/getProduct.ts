import { rest } from 'msw'

export const getProducts = rest.get('/product', (req, res, ctx) => {

    console.log(req.params)
    
    return res(
    ctx.json({
        id: String(req.params.id),
        name: 'produto',
    })
  )
})
