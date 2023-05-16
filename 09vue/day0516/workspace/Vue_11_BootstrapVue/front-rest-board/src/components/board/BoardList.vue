<template>
  <div class="container">
    <h3>게시글 목록</h3>
    <hr />
    <div>
      <b-table-simple
        hover
        :items="boards"
      >
      <b-thead class="text-center">
        <b-tr>
          <b-th>번호</b-th>
          <b-th>제목</b-th>
          <b-th>쓰니</b-th>
          <b-th>조회수</b-th>
          <b-th>등록일</b-th>
        </b-tr>
      </b-thead>
      <b-tbody class="text-center">
        <b-tr v-for="board in pageBoardList" :key="board.id">
          <b-td>{{ board.id }}</b-td>
          <b-td>
            <b-link :to="`/board/${board.id}`">{{
              board.title
            }}</b-link>
          </b-td>
          <b-td>{{ board.writer }}</b-td>
          <b-td>{{ board.viewCnt }}</b-td>
          <b-td>{{ board.regDate }}</b-td>
        </b-tr>
      </b-tbody>
      </b-table-simple>
    </div>
    <b-pagination
      v-model="currentPage"
      :total-rows="boardCount"
      :per-page="perPage"
      align="center"
    ></b-pagination>


    <div>
      <b-form inline>
        <b-form-select v-model="mode">
          <b-form-select-option value="1">제목</b-form-select-option>
          <b-form-select-option value="2">내용</b-form-select-option>
          <b-form-select-option value="3">제목+내용</b-form-select-option>
        </b-form-select>
        <b-form-input type="text" v-model="keyword" />
        <b-button variant="danger" @click="search">검색</b-button>
      </b-form>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'BoardList',
  data() {
    return {
      currentPage:1,
      perPage: 3,
      mode: 1,
      keyword: '',
    };
  },
  computed: {
    ...mapState(['boards']),
    boardCount() {
      return this.boards.length
    },
    pageBoardList(){
      return this.boards.slice(
        (this.currentPage-1) * this.perPage,
        this.currentPage*this.perPage
      )
    }
  },
  created() {
    this.$store.dispatch('getBoards');
  },
  methods: {
    search() {
      const payload = {
        mode: this.mode,
        keyword: this.keyword,
      };
      this.$store.dispatch('getBoards', payload);
    },
  },
};
</script>

<style></style>
