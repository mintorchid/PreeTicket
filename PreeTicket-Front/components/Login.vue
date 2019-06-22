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
            <el-button type="info" @click="reg_dialog=true" plain>注册</el-button>
            <el-button type="primary" @click="userLogin">登录</el-button>
          </div>
        </el-main>
      </el-container>
    </div>

    <el-dialog
      :visible.sync="reg_dialog"
      title="注册"
      :fullscreen="true"
      append-to-body
      center>
      <div style="padding: 10px 20px">
        <el-form ref="reg_form" :model="reg_form" label-width="120px" :rules="reg_form_rules">
          <el-form-item label="用户名：" prop="username">
            <el-input placeholder="用户名" v-model="reg_form.username"></el-input>
          </el-form-item>
          <el-form-item label="密码：" prop="password">
            <el-input placeholder="" v-model="reg_form.password" type="password"></el-input>
          </el-form-item>
          <el-form-item label="昵称：" prop="nickname">
            <el-input placeholder="" v-model="reg_form.nickname"></el-input>
          </el-form-item>
          <el-form-item label="性别：" prop="gender">
            <el-radio v-model="reg_form.gender" label="1">男</el-radio>
            <el-radio v-model="reg_form.gender" label="0">女</el-radio>
          </el-form-item>
          <el-form-item label="电话：" prop="tel">
            <el-input placeholder="" v-model="reg_form.tel" type="tel"></el-input>
          </el-form-item>
          <el-form-item label="电子邮件：" prop="email">
            <el-input placeholder="" v-model="reg_form.email" type="email"></el-input>
          </el-form-item>
        </el-form>
      </div>
      <div>
        <el-button type="primary" @click="UserReg()"></el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
    import API from "../api";
    import Cookies from "js-cookie"

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
          },
          reg_dialog:false,
          reg_form: {
            username:"",
            password:"",
            nickname:"",
            avator:"",
            gender:"",
            tel: null,
            email:"",
          },
          reg_form_rules:{
            username:[
              { required: true, message: "请输入用户名", trigger: 'blur'},
            ],
            password: [
              { required: true, message: "请输入密码", trigger: 'blur'},
            ],
            nickname:[
              { required: true, message: "请输入密昵称", trigger: 'blur'},
            ],
          },
        }
      },
      methods:{
          userLogin(){
            let data = this.login_form;
            API.userLoginApi(data).then(res=>{
              if(res.data.type == 1){
                this.$router.push({path: `/participant/main`});
                Cookies.set('userid', res.data.id_normal);
                Cookies.set('username', res.data.username);
                Cookies.set('nickname', res.data.nickname);
              }else if(res.data.type == 2){
                this.$router.push({path: `/organizer/main`});
                Cookies.set('userid', res.data.id_organizer);
                Cookies.set('username', res.data.username);
                Cookies.set('nickname', res.data.organize);
              }else{
                this.$message.error('登陆失败，请检查你的用户名和密码');
              }
            });
          },
        UserReg(){
          let data = this.reg_form;
          API.userRegisterApi(data).then(res=>{
            if(res.code===200){
              this.reg_dialog = false;
              this.$message.success("注册成功");
            }else {
              this.$message.error(res.message);
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
