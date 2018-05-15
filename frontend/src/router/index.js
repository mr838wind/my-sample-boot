import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import MyDataTable from '@/components/MyDataTable'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'MyDataTable',
      component: MyDataTable
    },
    {
      path: '/hello-world',
      name: 'HelloWorld',
      component: HelloWorld
    }
  ]
})
