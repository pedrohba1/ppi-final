<!-- Please remove this file from your project -->
<!-- 
    TODO: façam um compoente para listar produtos, 3 por linha
 -->

<template>
  <div class="">
    <h1>Products view</h1>
    <div
    class="grid grid-cols-3 gap-4"
    >
      <div 
      v-for="product in products"
      :key="product.id"
       >
        <img src="http://placekitten.com/200/300" />
        <p>
          {{ product.name }}
        </p>
        <p>
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
