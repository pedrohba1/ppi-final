<!-- Please remove this file from your project -->
<!-- 
    TODO: façam um compoente para listar produtos, 3 por linha
 -->

<template>
  <div class="text-center">
    <h1>
      Products view
    </h1>
    <div v-for="product of products">
      <img src="http://placekitten.com/200/300" />
      <img src="http://placekitten.com/200/300" />
      <img src="http://placekitten.com/200/300" />
    </div>
  </div>
</template>

<script>
import Vue from 'vue'

export default Vue.extend({
  name: 'NuxtProducts',
})
</script>
