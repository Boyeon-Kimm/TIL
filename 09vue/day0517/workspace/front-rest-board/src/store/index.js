import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";
import router from "@/router";

Vue.use(Vuex);

const REST_API = `http://localhost:9999/api`;

export default new Vuex.Store({
  state: {
    boards: [],
    board: {},
    tmdbPopularMovies: [],
    user: {}, //세팅만...
  },
  getters: {},
  mutations: {
    GET_BOARDS(state, payload) {
      state.boards = payload;
    },
    GET_BOARD(state, payload) {
      state.board = payload;
    },
    CREATE_BOARD(state, payload) {
      state.boards.push(payload);
    },
    UPDATE_BOARD(state, payload) {
      state.board = payload;
    },
    GET_TMDB_POPULAR(state, movies) {
      state.tmdbPopularMovies = movies;
    },
  },
  actions: {
    getBoards({ commit }, payload) {
      let params = null;
      if (payload) params = payload;

      const API_URL = `${REST_API}/board`;
      axios({
        url: API_URL,
        method: "GET",
        params,
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
        .then((res) => {
          commit("GET_BOARDS", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getBoard({ commit }, id) {
      const API_URL = `${REST_API}/board/${id}`;
      axios({
        url: API_URL,
        method: "GET",
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
        .then((res) => {
          commit("GET_BOARD", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    createBoard({ commit }, board) {
      const API_URL = `${REST_API}/board`;
      axios({
        url: API_URL,
        method: "POST",
        params: board,
      })
        .then(() => {
          commit("CREATE_BOARD", board);
          router.push("/board");
        })
        .catch((err) => {
          console.log(err);
        });
    },
    updateBoard({ commit }, board) {
      const API_URL = `${REST_API}/board`;
      axios({
        url: API_URL,
        method: "PUT",
        params: board,
      }).then(() => {
        commit("UPDATE_BOARD", board);
        router.push({ name: "boardDetail", params: { id: board.id } });
      });
    },
    deleteBoard({ commit }, id) {
      const API_URL = `${REST_API}/board/${id}`;
      axios({
        url: API_URL,
        method: "DELETE",
      })
        .then(() => {
          commit;
          router.push({ name: "boardList" });
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getTmdbPopular({ commit }) {
      commit;
      const TMDB_API_KEY = process.env.VUE_APP_TMDB_API_KEY;
      const API_URL = `https://api.themoviedb.org/3/movie/popular`;
      const params = {
        api_key: TMDB_API_KEY,
        language: "ko",
        region: "KR",
      };

      axios({
        url: API_URL,
        method: "GET",
        params,
      }).then((res) => {
        commit("GET_TMDB_POPULAR", res.data.results);
      });
    },
    userLogin({ commit }, user) {
      const API_URL = `${REST_API}/login`;
      axios({
        url: API_URL,
        method: "POST",
        params: user,
      })
        .then((res) => {
          console.log(res);
          sessionStorage.setItem("access-token", res.data["access-token"]);
          commit("USER_LOGIN"); //필요하다면 데이터도 같이 올려보내라
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
  modules: {},
});
