<template>
  <div id="app">
    <h2>당신이 좋아하는 파트를 선택하세요.</h2>
    <!--:total은 자식에게 내려보낼 props의 이름-->
    <!--우측에 "total"은 아래에 적혀있는 data리턴값-->
    <result-view :total="total"></result-view>
    <subject-view @add-to-count="addTotalCount" title="코딩"></subject-view>
    <subject-view @add-to-count="addTotalCount" title="알고"></subject-view>
  </div>
</template>

<script>
import ResultView from './components/ResultView.vue';
import SubjectView from './components/SubjectView.vue';

export default {
  name: 'App',
  components: {
    ResultView,
    SubjectView
  },
  data() {
    return {
      total: 0
    }
  },
  methods: {
    addTotalCount() {
      this.total += 1;
    },
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
