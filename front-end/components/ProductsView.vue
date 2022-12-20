<template>

  <div class="bg-white pt-4">
    <div
    class="grid grid-cols-3 gap-4"
    >
      <div 
      v-for="product in products"
      :key="product.id"
       >
        <NuxtLink to="/product"><img src="http://placekitten.com/200/300" class="pl-4"/></NuxtLink>
        <p class="pl-4">
          <NuxtLink to="/product">{{ product.name }}</NuxtLink>
        </p>
        <p class="pl-4">
          {{ product.description }}
        </p>
      </div>
    </div>
  </div>
</template>

<script>
import Vue from 'vue'
import { getProducts } from '../services/api/axios/getProducts'

export default Vue.extend({

  layout:'default',

  name: 'NuxtProducts',

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
