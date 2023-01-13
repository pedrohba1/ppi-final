<template>
  <div>
    <h1 class="font-semibold pl-4">Meu Carrinho</h1>
    <br />
    <h2 class="pl-4">produtos:</h2>
    <div class="col grid col-span-1">
      <div v-for="product in products" :key="product.id"
      class="ml-4 mb-4 w-60 pt-3 bg-slate-50 hover:bg-slate-300 hover:drop-shadow-2xl">
        <NuxtLink to="/product"
          ><img src="http://placekitten.com/200/300" class="pl-5"
        />
        <p class="pl-5">
          {{ product.name }}
        </p>
          <button
          class="flex flex-col text-left items-center justify-center mt-5 p-5 rounded-full bg-lime-400">
            remover do carrinho
          </button>
        </NuxtLink>
      </div>
    </div>
  </div>
</template>

<script>
import Vue from 'vue'
import { getProductsInCart } from '../services/api/axios/getProductsInCart'

export default Vue.extend({
  name: 'NuxtCart',

  data() {
    return {
      products: [
        {
          id: '',
          name: '',
          description: '',
          price: '',
          amount: undefined,
        },
      ],
    }
  },
  async mounted() {
    this.products = await getProductsInCart()
  },
})
</script>
