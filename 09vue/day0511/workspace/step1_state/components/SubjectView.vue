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
    // 클릭 이벤트가 발생했을 때 실행할 메소드
    methods: {
        addCount() {
            this.count += 1;
            // view 단에서 냅다 state에 접근을 하고 있는데
            // 이거 가능하지만 이렇게 접근하지 마세요!
            this.$store.state.total++;
        },
    },
};
</script>

<style>

</style>