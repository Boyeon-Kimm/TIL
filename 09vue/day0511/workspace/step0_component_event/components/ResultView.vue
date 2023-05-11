<template>
  <div>
    <h2>전체 {{ total }} 번 클릭됨</h2>
  </div>
</template>

<script>
export default {
    name: "ResultView",
    props: {
        total: Number
    }
}
</script>

<style>

</style>