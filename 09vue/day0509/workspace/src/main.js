import Vue from 'vue'
import App from './App.vue'
import router from './router'

Vue.config.productionTip = false

// 객체의 속성을 shortcut해서 쓸 수 있음
// router: router , 키와 밸류가 같다면 생략해서 작성 가능함
new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
