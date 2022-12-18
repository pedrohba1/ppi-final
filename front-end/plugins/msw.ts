// NEW
if (process.env.NODE_ENV === 'development') {
  const { worker } = require('../mock/browser')
  worker.start()
}
