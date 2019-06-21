<template>
  <div id="mainDiv">
    <div id="loginDiv">
      <Login />
    </div>
  </div>
</template>

<script>
  import Login from '~/components/Login.vue'
    export default {
      name: "mainpage",
      components: {
        Login
      },
    }
</script>

<style scoped>
  html,body,#mainDiv{
    height: 100vh;
    min-height: 400px;
  }
  #loginDiv{
    width: 100%;
    height: 100%;
    margin: 0 auto;
    min-width: 400px;
  }
</style>
