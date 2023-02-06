# front-end

## Build Setup

```bash
# install dependencies
$ yarn install

# serve with hot reload at localhost:3000
$ yarn dev

# build for production and launch server
$ yarn build
$ yarn start

# generate static project
$ yarn generate
```

## Special Directories

Você pode criar os seguintes diretórios extras, alguns dos quais têm comportamentos especiais. Somente `pages` é necessário; você pode excluí-los se não quiser usar sua funcionalidade.

### `assets`

O diretório assets contém seus ativos não compilados, como arquivos Stylus ou Sass, imagens ou fontes.

### `components`

O diretório de componentes contém seus componentes Vue.js. Os componentes compõem as diferentes partes de sua página e podem ser reutilizados e importados em suas páginas, layouts e até mesmo outros componentes.

### `layouts`

Os layouts são de grande ajuda quando você deseja mudar a aparência e o comportamento do seu aplicativo Nuxt, seja incluindo uma barra lateral ou tendo layouts distintos para dispositivos móveis e desktop.

### `pages`

Este diretório contém as visualizações e rotas de sua aplicação. O Nuxt lerá todos os arquivos \*.vue dentro deste diretório e configurará o Vue Router automaticamente.

### `plugins`

O diretório plugins contém plugins JavaScript que você deseja executar antes de instanciar a aplicação Vue.js raiz. Este é o lugar para adicionar plugins Vue e injetar funções ou constantes. Cada vez que você precisar usar Vue.use(), deve criar um arquivo em plugins/ e adicionar seu caminho aos plugins em nuxt.config.js.

### `static`

Este diretório contém seus arquivos estáticos. Cada arquivo dentro deste diretório é mapeado para /.

### `store`

Este diretório contém seus arquivos de store Vuex. Criar um arquivo neste diretório ativa automaticamente o Vuex.
