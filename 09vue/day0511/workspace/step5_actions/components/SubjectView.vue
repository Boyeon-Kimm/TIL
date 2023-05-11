<template>
  <div>
    <button @click="addOneCount">{{ title }} + 1 - {{ count }}</button>
    <button @click="addTenCount">{{ title }} + 10 - {{ count }}</button>
    <button @click="addRandomCount">{{ title }} + ? - {{ count }}</button>
    <button @click="asyncAddOne">{{ title }}  비동 - {{ count }}</button>
  </div>
</template>

<script>
export default {
  name: "SubjectView",
  props: {
    title: String,
  },
  data() {
    return {
      count: 0,
    };
  },
  methods: {
    addOneCount() {
      this.count += 1;
      //action이라고 하는것을 호출을 할텐데... 
      //mutations와 구분하기 위해서 메서드 이름을 카멜케이스를 사용했다.
      this.$store.dispatch('addOne')
    },
    addTenCount() {
      this.count += 10;
      //값을 인자로 넘겼다.
      this.$store.commit('ADD_TEN', 10)
    },
    addRandomCount() {
      let num = Math.round(Math.random() * 100)
      this.count += num;
      //객체를 인자로 넘겼다.
      this.$store.commit('ADD_RANDOM', {num})
    },
    //비동기도 actions를 호출해
    asyncAddOne(){
      this.count+=1
      this.$store.dispatch('asyncAddOne')
    }
  },
};
</script>

<style>
</style>