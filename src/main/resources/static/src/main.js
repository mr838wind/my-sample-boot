import Vue from 'vue'
import App from './App.vue'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.css'
import axios from 'axios'

Vue.use(Vuetify)
Vue.prototype.$http = axios

new Vue({
  el: '#app',
  render: h => h(App)
})
