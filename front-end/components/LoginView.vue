<!-- Please remove this file from your project -->
<template>
  <div class="flex justify-center min-h-screen">
    <div class="flex justify-center place-items-center">
      <form
        class="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4 flex flex-col items-center"
        @submit.prevent="onSubmit(email, password)"
      >
        <fieldset class="form-group">
          <div class="mb-4">
            <label
              class="block text-grey-darker text-sm font-bold mb-2"
              for="username"
            >
              email
            </label>
            <input
              v-model="email"
              class="shadow appearance-none border rounded w-full py-2 px-3 text-grey-darker"
              type="text"
              placeholder="Email"
            />
          </div>
        </fieldset>

        <fieldset class="form-group">
          <div class="mb-6">
            <label
              class="block text-grey-darker text-sm font-bold mb-2"
              for="password"
            >
              Password
            </label>
            <input
              v-model="password"
              class="shadow appearance-none border border-red rounded w-full py-2 px-3 text-grey-darker mb-3"
              type="password"
              placeholder="******************"
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
import { login } from '../services/api/axios/login'

export default Vue.extend({
  name: 'NuxtLogin',
  data() {
    return {
      email: null,
      password: null,
    }
  },
  methods: {
    async onSubmit() {
      const data = {
        password: this.password,
        email: this.email,
      }

      await login({ ...data })
    },
  },
})
</script>
