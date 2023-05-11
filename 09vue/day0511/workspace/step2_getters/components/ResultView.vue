<template>
  <div>
    <h2>전체 {{total}} 번 클릭됨</h2>
    <h3>{{countMsg}}</h3>
  </div>
</template>

<script>
export default {
    name: "ResultView",
    computed: {
      total() {
        return this.$store.state.total
      },
      countMsg: function (){
        return this.$store.getters.countMsg
      }
      // countMsg(){
      //   return this.$store.getters.countMsg
      // }
    }
}
</script>

<style>

</style>