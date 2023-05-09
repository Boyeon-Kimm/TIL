<template>
  <div id="app">
    <nav>
      <!--<a>태그가 기본 해당주소로 GET요청을 보낸다-->
      <router-link to="/">Home </router-link>|
      <!-- :으로 바인드해서 이름을 사용하겠다 -->
      <!--index.js에 routes 안의 name: 'about'과 연결된 것임 -->
      <router-link :to="{name: 'about'}">About </router-link>|
      <router-link :to="{name: 'user'}">User </router-link>|
      <router-link :to="{name: 'board'}">게시판</router-link>
    </nav>
    <router-view/>
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
