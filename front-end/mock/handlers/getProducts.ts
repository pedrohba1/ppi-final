import { rest } from 'msw'

export const getProducts = rest.get('/products', (_, res, ctx) => {
  return res(
    ctx.json({
      products: [
        {
          id: '1',
          name: 'carro de rolimã',
          description: 'descrição',
          price: '100.00',
          vendor: 'Bufulin',
          amount: 5,
        },
        {
          id: '2',
          name: 'carro de rolimã',
          description: 'descrição',
          price: '100.00',
          vendor: 'Bufulin',
          amount: 5,
        },
        {
          id: '3',
          name: 'carro de rolimã',
          description: 'descrição',
          price: '100.00',
          vendor: 'Bufulin',
          amount: 5,
        },
      ],
    })
  )
})
