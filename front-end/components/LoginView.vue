<!-- Please remove this file from your project -->
<template>

<div class="justify-center h-full">
<form 
class="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4 flex flex-col items-center"
@submit.prevent="onSubmit(email, password)"
>
<fieldset class="form-group">
    <div class="mb-4">
      <label class="block text-grey-darker text-sm font-bold mb-2" for="username">
        email
      </label>
      <input
      v-model="email"
      class="shadow appearance-none border rounded w-full py-2 px-3 text-grey-darker"  type="text" placeholder="Email">
    </div>
    </fieldset>

    <fieldset class="form-group">

    <div class="mb-6">
      <label class="block text-grey-darker text-sm font-bold mb-2" for="password">
        Password
      </label>
      <input 
      v-model="password" 
      class="shadow appearance-none border border-red rounded w-full py-2 px-3 text-grey-darker mb-3"  type="password" placeholder="******************">
    </div>
  </fieldset> 

    <div class="flex items-center justify-between">
      <button 
       @click="onSubmit" 
      class="bg-blue hover:bg-blue-dark text-white font-bold py-2 px-4 rounded" type="button">
        Sign In
      </button>
      <a class="inline-block align-baseline font-bold text-sm text-blue hover:text-blue-darker" href="#">
        Forgot Password?
      </a>
    </div>
  </form>
</div>


  </template>
  
  <script>
  import Vue from 'vue'
  
  export default Vue.extend({
    name: 'NuxtLogin',
    data() {
    return {
      email: null,
      password: null
    };
  },
  methods: {
    onSubmit() {
      const data = {
        password: this.password,
        email: this.email,
      };

      console.log(data)
    }
  },
  })

  </script>
  