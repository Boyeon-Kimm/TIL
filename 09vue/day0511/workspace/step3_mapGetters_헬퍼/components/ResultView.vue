<template>
  <div>
    <h2>전체 {{total}} 번 클릭됨</h2>
    <h3>{{countMsg}}</h3>
  </div>
</template>

<script>
//헬퍼를 이용하면 굉장히 편리해진다.
import {mapGetters} from 'vuex'

export default {
    name: "ResultView",
    computed: {
      //물론 state도 가넝하다. 
      //mapState라는걸 가져오면 (ㅎㅎ 직접 해볼것)
      total() {
        return this.$store.state.total
      },
      ...mapGetters([
        'countMsg'
      ])
    }
}
</script>

<style>

</style>