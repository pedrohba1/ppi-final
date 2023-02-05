<template>
    <div class="flex justify-center min-h-screen">
      <div class="flex justify-center place-items-center">
        <form
          class="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4 flex flex-col items-center"
          @submit.prevent="onSubmit(name, price, description, amount)"
        >
          <fieldset class="form-group">
            <div class="mb-4">
              <label
                class="block text-grey-darker text-sm font-bold mb-2"
                for="name"
              >
                name
              </label>
              <input
                v-model="name"
                class="shadow appearance-none border rounded w-full py-2 px-3 text-grey-darker"
                type="text"
                placeholder="Name"
              />
            </div>
          </fieldset>
          
          <fieldset class="form-group">
            <div class="mb-4">
              <label
                class="block text-grey-darker text-sm font-bold mb-2"
                for="price"
              >
                price
              </label>
              <input
                v-model="price"
                class="shadow appearance-none border rounded w-full py-2 px-3 text-grey-darker"
                type="number"
                placeholder="price"
              />
            </div>
          </fieldset>

          <fieldset class="form-group">
            <div class="mb-4">
              <label
                class="block text-grey-darker text-sm font-bold mb-2"
                for="description"
              >
                description
              </label>
              <input
                v-model="description"
                class="shadow appearance-none border rounded w-full py-2 px-3 text-grey-darker"
                type="text"
                placeholder="Insert your description here"
              />
            </div>
          </fieldset>

          <fieldset class="form-group">
            <div class="mb-4">
              <label
                class="block text-grey-darker text-sm font-bold mb-2"
                for="amount"
              >
                amount
              </label>
              <input
                v-model="amount"
                class="shadow appearance-none border rounded w-full py-2 px-3 text-grey-darker"
                type="number"
                placeholder="0"
              />
            </div>
          </fieldset>
  
          <div class="flex items-center justify-between">
            <button
              class="bg-blue hover:bg-blue-dark text-black font-bold py-2 px-4 rounded"
              type="button"
              @click="onSubmit"
            >
              Sign In
            </button>
          </div>
          <div>
            <NuxtLink :to="{ path: `/register` }">Sign up </NuxtLink>
          </div>
        </form>
      </div>
    </div>
  </template>
  
  <script>
  import Vue from 'vue'
  // import createProduct from 'services/api/axios/createProduct'


  export default Vue.extend({
    name: 'NuxtCreateProduct',
    data() {
      return {
        name: null,
        description: null,
        amount: null,
        price: null
      }
    },
    methods: {
      async onSubmit() {
        // const data = {
        //   password: this.password,
        //   email: this.email,
        // }
  
        // await login({ ...data })

      },
    },
  })
  </script>