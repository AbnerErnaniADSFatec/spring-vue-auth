<template>
  <div id = "app">
      <p>Buscas de Usuarios
        <input type = "text" v-model = "username">
        <button @click = "search">Search</button>
      </p>
      <ul>
        <li v-for = "(user, i) in users">
          {{ user.nome }} - {{ user.email }}
        </li>
      </ul>
  </div>
</template>

<style>
  @import '../assets/styles/search-users.css';
</style>

<script>
  import axios from 'axios';
  axios.defaults.baseURL = 'http://localhost:8080/api-auth/users'
  export default {
    name: 'SearchUsers',
    data() {
      return {
        novo: '',
        username: "",
        users: []
      }
    },
    methods: {
      search() {
        axios.get('find_by_name?user_name=' + this.username,
          {
            headers: {
              Accept: 'application/json',
              'Access-Control-Allow-Origin' : '*'
            }
          }
        ).then(
          response => {
            console.log(response.data);
            this.users = response.data;
          }
        ).catch(
          error => console.log(error)
        );
      }
    }
  }
</script>