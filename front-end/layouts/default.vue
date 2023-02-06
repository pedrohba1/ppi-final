<template>
  <div>
    <div class="bg-gradient-to-r from-purple-500 to-blue-500">
      <div class="container mx-auto">
        <div class="flex justify-between items-center py-4">
          <NuxtLink
            to="/"
            class="text-white text-xl font-semibold py-4 px-8 rounded-lg hover:bg-purple-600 hover:text-white"
          >
            Sobre
          </NuxtLink>
          <NuxtLink
            to="/login"
            class="text-white text-xl font-semibold py-4 px-8 rounded-lg hover:bg-purple-600 hover:text-white"
          >
            Login
          </NuxtLink>
          <NuxtLink
            to="/products"
            class="text-white text-xl font-semibold py-4 px-8 rounded-lg hover:bg-purple-600 hover:text-white"
          >
            Produtos
          </NuxtLink>

          <NuxtLink
            to="/product/create"
            class="text-white text-xl font-semibold py-4 px-8 rounded-lg hover:bg-purple-600 hover:text-white"
          >
            Criar produto
          </NuxtLink>
          <NuxtLink
            to="/cart"
            class="text-white text-xl font-semibold py-4 px-8 rounded-lg hover:bg-purple-600 hover:text-white"
          >
            Meu carrinho
          </NuxtLink>
        </div>
      </div>
    </div>
    <Nuxt />
  </div>
</template>
