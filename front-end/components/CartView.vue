<template>
  <div>
    <h1 class="font-semibold pl-4">Meu Carrinho</h1>
    <br />
    <h2 class="pl-4">produtos:</h2>
    <div class="col grid col-span-1">
      <div v-for="product in cart" :key="product.id">
        <NuxtLink to="/product"
          ><img src="http://placekitten.com/200/300" class="pl-4"
        /></NuxtLink>
        <p class="pl-4">
          <NuxtLink to="/product">{{ product.name }}</NuxtLink>
        </p>
      </div>
    </div>
  </div>
</template>

<script>
import Vue from 'vue'
import { getProducts } from '../services/api/axios/getProducts'

export default Vue.extend({
  name: 'NuxtProducts',
  layout: 'default',

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
    this.products = await getProducts()
  },
})
</script>
