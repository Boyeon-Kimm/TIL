<template>
  <div>
    <h3>로그인</h3>
    <div>
        <input type="text" v-model.trim="user.id" placeholder="아디">
        <input type="password" v-model.trim="user.password" placeholder="비번">
        <button @click="login">로그인</button>
    </div>
  </div>
</template>

<script>
export default {
    name: "UserLogin",
    data() {
        return {
            user : {
                id: "",
                password: ""
            }
        }
    },
    methods: {
        login(){
            this.$store.dispatch('userLogin', this.user)
        }
    },
}
</script>

<style>

</style>