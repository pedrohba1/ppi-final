<!-- Please remove this file from your project -->

<!-- TODO: façam um compoente para listar um produto só -->

<template>
  <div
    class="container flex justify-center items-center flex-col h-screen place-items-center"
  >
    <div class="flex flex-row">
      <div class="">
        <h1>#NOMEPRODUTO#</h1>
        <img src="http://placekitten.com/200/300" class="" />
      </div>
      <div
        class="flex flex-col text-left items-center justify-center pl-1 pt-1"
      >
        <h2>#Preço#</h2>
        <p>#Nome Vendedor#</p>
        <p>#Descrição do produto#</p>
        <p>#quantidade disponível#</p>
      </div>
    </div>
  </div>
</template>

<script>
import Vue from 'vue'

export default Vue.extend({
  name: 'NuxtProduct',
  props: ['baseUrl', 'products'],
  data() {
    return {
      product: {},
    }
  },
  mounted() {
    this.id = this.$route.params.id
  },
})
</script>
