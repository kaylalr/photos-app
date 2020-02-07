import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
// import Photo from '../views/Photo.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home,
    children: [
      {
        path: 'about',
        name: 'about',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
      },
      {
        path: 'uploadImg',
        name: 'uploadImg',
        component: () => import(/* webpackChunkName: "uploadImg" */ '../views/UploadImg.vue')
      },
      {
        path: 'photos',
        name: 'photos',
        component: () => import(/* webpackChunkName: "photos" */ '../views/Photos.vue')
      },
      {
        path: 'photo/:id',
        name: 'photo',
        props: true,
        component: () => import(/* webpackChunkName: "photo" */ '../views/Photo.vue')
      },
    ]
  },
]

const router = new VueRouter({
  mode: 'history',
  routes,
})

export default router
