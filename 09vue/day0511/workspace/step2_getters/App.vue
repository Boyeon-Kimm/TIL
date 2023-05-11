<template>
  <div id="app">
    <h2>당신이 좋아하는 파트를 선택하세요.</h2>
    <result-view ></result-view>
    <subject-view title="코딩"></subject-view>
    <subject-view title="알고"></subject-view>
  </div>
</template>

<script>
import ResultView from "./components/ResultView.vue";
import SubjectView from "./components/SubjectView.vue";

export default {
  name: "App",
  components: {
    ResultView,
    SubjectView,
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
