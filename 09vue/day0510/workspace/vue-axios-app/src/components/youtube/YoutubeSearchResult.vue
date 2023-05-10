<template>
  <div>
    <h3>검색 결과</h3>
    <ul class="youtube-list">
        <!--li 태그를 v-for로 videos를 내려서 돌릴 것임 
            key는 식별할 수 있는 id -->
        <li v-for="video in videos" :key=video.id.videoId>
            <img :src="video.snippet.thumbnails.default.url">
            {{ video.snippet.title }}
        </li>
    </ul>
  </div>
</template>

<script>
export default {
    name: "YoutubeSearchResult",
    // props 내려왔다. videos가 내려왔는데 Array이다.
    props: {
        videos: Array
    }
}
</script>

<style scoped>
    .youtube-list {
        text-align: left;
    }
</style>