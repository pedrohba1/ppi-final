<template>
  <div class="py-8">
    <div class="grid grid-cols-4 gap-8 mx-10">
      <div
        v-for="product in products"
        :key="product.id"
        class="w-64 p-6 bg-white rounded-lg shadow-lg hover:shadow-xl"
      >
        <NuxtLink :to="{ path: `/product/${product.id}` }" class="ml-5">
          <img
            :src="product.image"
            class="h-48 w-full object-cover rounded-lg mb-4"
          />
          <p class="text-xl font-medium text-gray-800 mb-2">
            {{ product.name }}
          </p>
          <p class="text-base text-gray-600">{{ product.description }}</p>
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
