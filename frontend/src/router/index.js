import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import MyDataTable from '@/components/MyDataTable'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'home',
      component: HelloWorld
    },
    {
      path: '/my-data-table',
      name: 'my-data-table',
      component: MyDataTable
    },
    {
      path: '/hello-world',
      name: 'hello-world',
      component: HelloWorld
    }
  ]
})
