<template>
  <div class = "app">
    <div class = "form">
      <div class = "row">
        <div class = "col-10">
          <div>
            <input type = "text" v-model = "username" placeholder = "Nome de usuário...">
          </div>
        </div>
        <div class = "col">
          <button class = "button icon-only" @click = "search">
            Buscar
            <img src = "https://icongr.am/feather/search.svg?size=16">
          </button>
        </div>
      </div>
    </div>
    <table id = 'users' class = "striped">
      <thead>
        <tr>
          <th>User name</th>
          <th>E-mail</th>
        </tr>
      </thead>
      <tbody v-for = "(user, i) in users">
        <tr>
          <td>{{ user.nome }}</td>
          <td>{{ user.email }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

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