<template>
  <div>
    <h2>사용자 정보를 위한 페이지 입니다.</h2>
    <h4>
        <!--동적 라우트 매칭-->
        {{ $route.params.username }} 
    </h4>
  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>