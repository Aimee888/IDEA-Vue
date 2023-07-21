import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import jump1test from '@/components/jump1test'
import navigation from '@/components/navigation'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/HelloWorld',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/jump1test',
      name: 'jump1test',
      component: jump1test
    },
    {
      path: '/',
      name: 'navigation',
      component: navigation
    }
  ]
})
