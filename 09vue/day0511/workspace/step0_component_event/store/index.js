import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    // 공통의 데이터(상태)들을 저장하는 영역

  },
  getters: {
    // stated를 이용하여 원본의 데이터를 수정하지 않은 상태로 새로운 값을 뿌려주고 싶을 때
    // computed와 같은 역할을 하고 있음

  },
  mutations: {
    // state를 변경하는 유일한 방법, 첫번째 인자로 state가 들어와
    // 동기적으로 작성할 것 !!
  },
  actions: {
    // mutations 호출
    // backend api와 통신하는 곳, context라고 하는 만능 객체가 인자로 들어옴
  },
  modules: { // 따로 다뤄보지는 않는다
    // 여러개로 쪼개놓고 관리를 하는 곳
  }
})
