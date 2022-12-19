<!-- Please remove this file from your project -->

<!-- TODO: façam um compoente para listar um produto só -->

<template>
  <div
    class="container flex justify-center items-center flex-col h-screen place-items-center"
  >
    <div class="flex flex-row">
      <div class="">
        <h1>{{ product.name }}</h1>
        <img src="http://placekitten.com/200/300" class="" />
      </div>
      <div
        class="flex flex-col text-left items-center justify-center pl-1 pt-1"
      >
        <h2>{{ product.price }}</h2>
        <p>{{ product.vendor }}</p>
        <p>{{ product.description }}</p>
        <p>{{ product.amount }}</p>
      </div>
    </div>
  </div>
</template>

<script>
import Vue from 'vue'
import { getProduct } from '../services/api/axios/getProduct'

export default Vue.extend({
  name: 'NuxtProduct',
  data() {
    return {
      product: {
        id: '',
        name: '',
        description: '',
        price: '',
        amount: undefined,
      },
    }
  },
  async mounted() {
    this.product = await getProduct({ id: this.$route.params.id })
  },
})
</script>
