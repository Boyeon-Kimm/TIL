<template>
    <div>
        <h2>유튜브 전용 페이지</h2>
        <!--search-input이라는 이벤트가 들어왔을 때 실행시키고 싶은 메소드(search) 작성 -->
        <youtube-search @search-input="search"></youtube-search>
        <youtube-search-result
            :videos="videos"
        ></youtube-search-result>
    </div>
</template>

<script>
import YoutubeSearch from '../components/youtube/YoutubeSearch.vue';
import YoutubeSearchResult from '../components/youtube/YoutubeSearchResult.vue';
import axios from axios;

export default {
    name: "YoutubeView", // 컴포넌트 만들고 나서 name 속성 지정해주는 습관이 좋음
    components: { 
        YoutubeSearch, 
        YoutubeSearchResult, 
    },
    data() {
        return {
            videos = [] // videos 배열을 하나 저장하고 있음
        }
    },
    methods: {
        search(value) {
            // 부모 컴포넌트까지 잘 올라왔음
            // console.log(value);
            const URL = "https://www.googleapis.com/youtube/v3/search"; // 요청 보낼 곳
            const API_KEY = process.env.VUE_APP_YOUTUBE_API_KEY;
            axios({
                url: URL,
                method: "GET",
                params: {
                    key: API_KEY,
                    part: "snippet",
                    q: value, // 쿼리, q매개변수에 검색어를 넣어서 보내겠다
                    type: "video",
                    maxResults: 20,
                },
            })
            .then((res) => {
                return res.data.items;
            })
            .then((res) => {
                this.videos = res
            })
            .catch((err) => console.log(err));
        },
    },
};
</script>

<style scoped>
    h2 {
        color: red;
    }
</style>