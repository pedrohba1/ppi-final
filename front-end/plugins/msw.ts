// NEW
if (process.env.ENABLE_MOCK === "enabled") {
  const { worker } = require('../mock/browser')
  worker.start()
}
