import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import MyDataTablePagingFrontend from '@/components/MyDataTablePagingFrontend'
import MyDataTablePagingBackend from '@/components/MyDataTablePagingBackend'
import MyForm from '@/components/MyForm'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'home',
      component: HelloWorld
    },
    {
      path: '/my-data-table-paging-frontend',
      name: 'my-data-table-paging-frontend',
      component: MyDataTablePagingFrontend
    },
    {
      path: '/my-data-table-paging-backend',
      name: 'my-data-table-paging-backend',
      component: MyDataTablePagingBackend
    },
    {
      path: '/my-form',
      name: 'my-form',
      component: MyForm
    }
  ]
})
