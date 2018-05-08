import Vue from 'vue'
import App from './App.vue'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.css'
// http
import axios from 'axios'
// util
import _ from 'lodash'

Vue.use(Vuetify)
Vue.prototype.$http = axios
Vue.prototype.$_ = _


new Vue({
  el: '#app',
  render: h => h(App)
})
