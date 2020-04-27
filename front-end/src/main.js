import Vue from 'vue'
import routes from './routes'
import App from './App.vue'

new Vue({
  el: '#app',
  router: routes,
  render: h => h(App)
})
