import Vue from 'vue';
import VueRouter from 'vue-router';
import HomeView from '../views/HomeView.vue';
import AboutView from '../views/AboutView.vue';
import UserView from '../views/UserView.vue';
import BoardView from '../views/BoardView.vue';
import BoardList from '../components/board/BoardList.vue';
import BoardCreate from '@/components/board/BoardCreate.vue';

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home', // 안쓴다고 해서 에러나지 않음.
    component: HomeView,
  },
  {
    path: '/about',
    name: 'about',
    component: AboutView,
  },
  { // 동적으로 사용
    path: '/user/:username',
    name: 'user',
    component: UserView,
  },
  {
    path: '/board',
    name: 'board',
    component: BoardView,
    // 자식은 path 쓸 때 '/' 붙이지 마세용!
    children: [
      {
        path: 'list',
        component: BoardList,
      },
      {
        path: 'create',
        component: BoardCreate,
      },
    ]
  },
];

// main.js에서 불러와서 넣는다.
const router = new VueRouter({
  mode: 'history', // history 또는 hash , 기본값 : hash
  base: process.env.BASE_URL,
  routes,
});

export default router;
