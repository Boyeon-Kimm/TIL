<template>
  <div>
    <h3>게시판</h3>
    <router-link to="/board/list">게시판 목록</router-link>
    <router-link to="/board/create">게시글 등록</router-link>
    <router-view/>
  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>