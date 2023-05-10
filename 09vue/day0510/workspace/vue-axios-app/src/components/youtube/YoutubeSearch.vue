<template>
    <div>
        <h3>검색 컴포넌트</h3>
        <!--keyword라는 v-model로 연결-->
        <input type="text" v-modle="keyword">
        <!--button을 통해서 click이벤트(search)를 할 것임-->
        <button @click="search">검색</button>
    </div>
</template>

<script>
export default {
    name: "YoutubeSearch",
    data() {
        return {
            keyword: "",
        };
    },
    // 검색한 키워드를 메소드를 이용하여 부모한테 올려보내고 싶다.
    methods: {
        search() {
            // 내 인스턴스에서 emit이벤트를 발생시키겠다
            // 이벤트 이름과 던지고 싶은 인자가 있으면 추가로 작성해주면 됨.
            this.$emit('search-input', this.keyword);
        }
    },
};
</script>

<style>

</style>