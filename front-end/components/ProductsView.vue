<template>
  <div class="bg-slate-200 pt-4">
    <div class="grid grid-cols-3 gap-4">
      <div v-for="product in products" :key="product.id" class="w-60 pt-3 bg-slate-50 hover:bg-slate-300
      hover:drop-shadow-2xl">
        <NuxtLink :to="{ path: `/product/${product.id}` }"
          ><img src="http://placekitten.com/200/300" class="pl-5" />
          <p class="pl-5"></p>
          <p class="pl-5">
            {{ product.name }}
          </p>
          <p class="pl-5">
            {{ product.description }}
          </p>
        </NuxtLink>
      </div>
    </div>
  </div>
</template>

<script>
import Vue from 'vue'
import { getProducts } from '../services/api/axios/getProducts'

export default Vue.extend({
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
