<template>
  <div id="login-div">
    <div id="logo-div2"></div>
    <div id="login-div2">
      <el-container>
        <el-main>
          <h1 style="margin: 30px">Welcome</h1>
          <el-form ref="login_form" :model="login_form" label-width="80px" :rules="login_form_rules">
            <el-form-item label="用户名：" prop="username">
              <el-input placeholder="用户名" v-model="login_form.username"></el-input>
            </el-form-item>
            <el-form-item label="密码：" prop="password">
              <el-input placeholder="" v-model="login_form.password" type="password"></el-input>
            </el-form-item>
          </el-form>
          <div style="float: right;margin-right: 20px">
            <el-button type="info" @click="userLogin" plain>注册</el-button>
            <el-button type="primary">登录</el-button>
          </div>
        </el-main>
      </el-container>
    </div>
  </div>
</template>

<script>
    import API from "../api";

    export default {
        name: "Login",
      data() {
        return {
          login_form:{
            username:"",
            password:"",
          },
          login_form_rules:{
            username:[
              { required: true, message: "请输入用户名", trigger: 'blur'},
            ],
            password: [
              { required: true, message: "请输入密码", trigger: 'blur'},
            ]
          }
        }
      },
      methods:{
          userLogin(){
            let data = this.login_form;
            API.userLoginApi(data).then(res=>{
              if(res.type === 1){
                this.$router.push({path: `/participant/main`});
              }else if(res.type === 2){
                this.$router.push({path: `/organizer/main`});
              }else{
                this.$message.error('登陆失败，请检查你的用户名和密码');
              }
            });
          },
      }
    }
</script>

<style scoped>
  #login-div{
    height: 100%;
    width: 100%;
    background-color: #1a77ce;
  }
  #logo-div2{
    height: 30%;
  }
  #login-div2{
    width: 30%;
    min-width: 350px;
    margin: 0 auto;
    background-color: rgba(255,255,255,0.8);
    border-radius: 10px;
  }
  .el-input-div{
    margin: 15px 20px;
  }
</style>
