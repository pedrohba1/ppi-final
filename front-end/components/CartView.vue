<template>
  <div>
    <h1 class="font-semibold pl-4">Meu Carrinho</h1>
    <br />
    <h2 class="pl-4">produtos:</h2>
    <div class="col grid col-span-1">
      <div v-for="product in products" :key="product.id">
        <NuxtLink to="/product"
          ><img src="http://placekitten.com/200/300" class="pl-4"
        />
        <p class="pl-4">
          {{ product.name }}
        </p>
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
