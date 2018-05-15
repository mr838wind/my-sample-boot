import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import MyContent from '@/components/MyContent'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'MyContent',
      component: MyContent
    },
    {
      path: '/hello-world',
      name: 'HelloWorld',
      component: HelloWorld
    }
  ]
})
