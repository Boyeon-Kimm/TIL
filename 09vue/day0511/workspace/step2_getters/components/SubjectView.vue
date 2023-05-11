<template>
  <div>
    <button @click="addCount">{{ title }} - {{ count }}</button>
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
    addCount() {
      this.count += 1;
      //view 단에서 냅다 state에 접근을 하고 있는데 
      //이거 가넝하지만 하라고 말라고? --> 말라고~~ 연습이니까~~
      this.$store.state.total++;
    },
  },
};
</script>

<style>
</style>