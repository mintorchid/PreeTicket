<template>
  <div class="activity-item" v-on:click="showActDialog">
    <div class="activity-title">
      <h1>{{ title }}</h1>
    </div>
    <div class="activity-title-line"></div>
    <div class="activity-detail">
      <p>{{ time }}</p>
    </div>
  </div>
<!--
  <el-dialog
    title="Log in"
    width="450px"
    :visible.sync="act_dialog"
    center>
    <el-form label-width="100px" ref="log_form" :model="log_form" :rules="log_form_rules">
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button type="primary" @click="submitChange" plain>提交修改</el-button>
      <el-button @click="act_dialog = false">取消</el-button>
    </span>
  </el-dialog>
  -->
</template>

<script>
    export default {
        name: "Activity",
      props: {
        id: Number,
        status: Boolean,
        title: String,
        time: String
      },
      data(){
          return{
            act_dialog: false,
            new_activity_info:[],
          }
      },
      methods:{
        showActDialog(){
          this.act_dialog = true;
        },
        submitChange(){
          // todo
        }
      }
    }
</script>

<style scoped>
  .activity-item{
    width: 70%;
    border-top-right-radius: 6px;
    border-bottom-right-radius: 6px;
    border: #409eff 1px solid;
    border-left: #409eff 5px solid;
    margin: 0 auto 5px auto;
    padding: 20px 20px;
    cursor: pointer;
  }

  .activity-item:hover{
    background-color: #e6e2ff;
  }
  .activity-title{
    width: 100%;
  }
  .activity-title>h1{
    font-size: 25px;
    color: #303133;
  }
  .activity-title-line{
    height: 2px;
    width: 40px;
    background-color: #409eff;
    margin-bottom: 8px;
  }
  .activity-detail{
    color: #606266;
    padding-top: 5px;
  }
</style>
