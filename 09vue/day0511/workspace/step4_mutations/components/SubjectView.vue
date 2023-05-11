<template>
  <div>
    <button @click="addOneCount">{{ title }} + 1 - {{ count }}</button>
    <button @click="addTenCount">{{ title }} + 10 - {{ count }}</button>
    <button @click="addRandomCount">{{ title }} + ? - {{ count }}</button>
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
      //mutations는 직접 부를순없고 메서드를 통해서 부를 수 있음.
      //commit('메서드이름'[,넘기고 싶은 인자])
      this.$store.commit('ADD_ONE')
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
  },
};
</script>

<style>
</style>