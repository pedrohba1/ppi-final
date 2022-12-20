<template>
    <div>
      <div class="bg-gradient-to-r from-purple-500 to-blue-500 pb-3">
        <br>
        <p class="font-sans text-xl font-semibold">
            <NuxtLink to="/" class="pl-4 pr-4 m-4 ring-2 ring-blue-500">About Page</NuxtLink>
            <NuxtLink to="/login" class="pl-4 pr-4 m-4 ring-2 ring-blue-500">Login</NuxtLink>
            <NuxtLink to="/products" class="pl-4 pr-4 m-4 ring-2 ring-blue-500">Produtos</NuxtLink>
            <NuxtLink to="/cart" class="pl-4 pr-4 m-4 ring-2 ring-blue-500">Meu Carrinho</NuxtLink>
        </p>
      </div>
      <Nuxt />
    </div>
</template>