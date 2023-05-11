<template>
  <div>
    <button @click="addCount">{{ title }} - {{ count }}</button>
  </div>
</template>

<script>
export default {
    name: "SubjectView",
    props: {
        title: String
    },
    data() {
        return {
            count: 0
        }
    },
    // 클릭 이벤트가 발생했을 때 실행할 메소드
    methods: {
        addCount() {
            this.count += 1;
            this.$emit('add-to-count')
        },
    },
};
</script>

<style>

</style>