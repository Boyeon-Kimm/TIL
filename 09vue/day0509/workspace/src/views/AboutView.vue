<template>
  <div>
    <h2>이곳은 About View 입니다.</h2>
    <button @click="moveToHome">홈으로</button>
    <!--동적 라우트 매칭-->
    <router-link :to="{name: 'user', params: {username: 'kim'}}">김보연 페이지 </router-link>
    <router-link :to="{name: 'user', params: {username: 'ruby'}}">김루비 페이지 </router-link>
    <router-link :to="{name: 'user', params: {username: 'yang'}}">양어쩌고 페이지</router-link>
  </div>
</template>

<script>
export default {
  methods: {
    moveToHome(){
      // this.$router.push({name: 'home'}) // 이름을 가지고 있다면 이것도 가능
      this.$router.push('/') // 뒤로가기
    }
  }
}
</script>

<style>

</style>