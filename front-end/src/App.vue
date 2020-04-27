<template>
  <div id = "app">
    <div id = "nav">
      <router-link to = "/">Home</router-link> |
      <router-link to = "/search">Search User</router-link>
    </div>
    <router-view/>
  </div>
</template>

<script>
  export default {
    name: 'app'
  }
</script>