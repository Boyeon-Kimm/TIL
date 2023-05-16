<template>
  <div>
    <h2>인기 순위</h2>
    <b-row cols="1" cols-sm="2" cols-md="4">
      <b-card
        v-for="(movie, index) in tmdbPopularMovies"
        :key="index"
        :title="movie.title"
        :img-src="`https://image.tmdb.org/t/p/original/${movie.poster_path}`"
        img-top
      >
        <b-card-text>
          {{ movie.overview }}
        </b-card-text>
        <b-list-group flush>
          <b-list-group-item>개봉일 : {{ movie.release_date }}</b-list-group-item>
          <b-list-group-item>언어 : {{ movie.original_language }}</b-list-group-item>
        </b-list-group>
      </b-card>
    </b-row>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  computed: {
    ...mapState(["tmdbPopularMovies"]),
  },

  created() {
    this.$store.dispatch("getTmdbPopular");
  },
};
</script>

<style></style>
