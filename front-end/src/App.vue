<template>
  <div class = "root">
    <h1 class = "is-center">Controle de Usuários</h1>
    <nav class = "tabs is-center" id = "menu">
      <router-link to = "/">Home</router-link>
      <router-link to = "/search">Search User</router-link>
    </nav>
    <div class = "app">
      <router-view/>
    </div>
  </div>
</template>

<style scoped>
  @import './assets/styles/style.css';
</style>

<script>
  export default {
    name: 'app'
  }
</script>