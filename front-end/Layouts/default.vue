<template>
    <div>
      <div class="bg-gradient-to-r from-purple-500 to-blue-500 pb-3 gap-2">
        <br>
        <p class="font-sans text-xl">
            <NuxtLink to="/login" class="pl-4 pr-4">Home page</NuxtLink>
            <NuxtLink to="/products" class="pl-4 pr-4">Produtos</NuxtLink>
            <NuxtLink to="/carrinho" class="pl-4 pr-4">Meu Carrinho</NuxtLink>
        </p>
      </div>
      <Nuxt />
    </div>
</template>