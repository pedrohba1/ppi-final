<template>
    <div class="bg-gradient-to-r from-purple-500 to-blue-500">
      <div>
        <h1 class="pl-4">Barra de Navegação</h1>
        <br>
        <p>
            <NuxtLink to="/login" class="pl-4 pr-4">Home page</NuxtLink>
            <NuxtLink to="/products" class="pl-4 pr-4">Produtos</NuxtLink>
            <NuxtLink to="/carrinho" class="pl-4 pr-4">Meu Carrinho</NuxtLink>
        </p>
      </div>
      <Nuxt />
    </div>
</template>