import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    //공통의 데이터(상태)들을 저장하는 영역
    total: 0,
  },
  getters: {
    //state를 이용하여 원본의 데이터를 수정하지 않은 상태로 새로운 값을 뿌려주고 싶을때
    //computed와 같은 역할을 하고 있음.
    //현재 total의 투표수에 따라 문구를 달리 출력하고 싶다.~~~
    countMsg(state) {
      let msg = "10회 ";
      if (state.total > 10) msg += "초과";
      else msg += "이하";

      return `${msg} 호출됨`;
    },
  },
  mutations: {
    //state를 변경하는 유일한 방법 , 첫번째 인자로 state가 들어옴
    //동기적으로 작성할 것!!
    ADD_ONE(state) {
      state.total += 1;
    },
    //payload 숫자 값을 넘긴 상태이므로 바로 더할 수 있음
    ADD_TEN(state, payload) {
      state.total += payload;
    },
    //payload 객체가 들어왔다.
    ADD_RANDOM(state, payload) {
      state.total += payload.num;
    },
  },
  actions: {
    //mutations를 호출
    //backend api와 통신을 하는곳, context라고 하는 만능 객체가 인자로 들어옴
    // addOne(context) {
    //   // console.log(context);
    //   context.commit("ADD_ONE");
    // },
    addOne({ commit }) {
      commit("ADD_ONE");
    },
    //비동기통신
    asyncAddOne({ commit }) {
      //ez하게 비동기 해보는 방법
      // setTimeout(function () {
      //   commit("ADD_ONE");
      // }, 2000);
      setTimeout(() => {
        commit("ADD_ONE");
      }, 1000);
    },
  },
  modules: {
    //여러개로 쪼개놓고 관리를 하는 곳
  },
});
