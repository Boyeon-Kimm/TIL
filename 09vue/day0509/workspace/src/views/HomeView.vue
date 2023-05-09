<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <!--정적으로 데이터를 내려보냄.. props -->
    <HelloWorld msg="헬로우~~ 뷰앱 ㅎㅎ"/>
  </div>
</template>

<script>
// @ is an alias to /src
// @를 쓰면 src부터 시작을 한 경로와 똑같다
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'HomeView',
  components: {
    HelloWorld
  }
}
</script>
