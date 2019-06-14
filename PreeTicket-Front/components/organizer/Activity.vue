<template>
  <div class="activity-item" v-on:click="showActDialog">
    <a class="items_img">
      <img src="@/assets/img/qwe.jpg" style="width: 100%;height: 100%;"/>
    </a>
    <div class="items_txt">
      <div class="activity-title">
        <h1>{{ title }}</h1>
      </div>
      <div class="activity-title-line"></div>
      <div class="activity-title-line2"></div>
      <div class="activity-info">
        <p><i class="el-icon-alarm-clock" style="color: #1a77ce"></i> {{ time }}</p>
        <p><i class="el-icon-map-location" style="color: #1a77ce"></i> {{ location }}</p>
        <p><i class="el-icon-star-on" style="color: #1a77ce"></i> {{ status }}</p>
      </div>
      <div class="activity-detail">
        <p>{{detail}}</p>
      </div>
    </div>
    <div class="items_notice">
      <div class="activity-notice">
        <p style="font-size: 20px">通知：</p>
        <div class="activity-notice-item" v-for="(n,index) in notice" :key="index" style="width: 100%;padding: 2px 0;">
          <div style="float: left;width: 200px">
            <p>{{ n.time }}</p>
          </div>
          <div style="margin-left: 200px">
            <p>{{ n.content }}</p>
          </div>
        </div>
      </div>
    </div>
    <el-dialog
      title="Log in"
      width="450px"
      :visible.sync="act_dialog"
      center
      append-to-body>
      <el-form label-width="100px" ref="act_info_form" :model="act_info_form">
      </el-form>
      <span slot="footer" class="dialog-footer">
      <el-button type="primary" @click="submitChange" plain>提交修改</el-button>
      <el-button @click="act_dialog = false">取消</el-button>
    </span>
    </el-dialog>
  </div>
</template>

<script>
    export default {
        name: "Activity",
      props: {
        id: Number,
        status: Boolean,
        title: String,
        time: String,
        location:String,
        detail:String,
        notice:Array,
      },
      data(){
          return{
            act_dialog: false,
            act_info_form:{
              id: this.id,
              status: this.status,
              title: this.title,
              time: this.time,
              location: this.location,
              detail: this.detail,
              notice: this.notice,
            }
          }
      },
      methods:{
        showActDialog(){
          this.act_dialog = true;
          console.log("wedawdawd");
        },
        submitChange(){
          // todo
        }
      }
    }
</script>

<style scoped>
  .activity-item{
    width: 50%;
    border-top-right-radius: 6px;
    border-bottom-right-radius: 6px;
    border-bottom: #409eff 1px dotted;
    margin: 0 auto;
    padding: 20px 20px;
    cursor: pointer;
  }
  .activity-item:after {
    display: block;
    clear: both;
    visibility: hidden;
    height: 0;
    overflow: hidden;
    content: ".";
  }
  .activity-item:hover{
    background-color: #e8e8ff;
  }
  .activity-title>h1{
    font-size: 25px;
    color: #303133;
  }
  .activity-title-line{
    height: 2px;
    width: 70px;
    background-color: #409eff;
    margin-top: 2px;
  }
  .activity-title-line2{
    height: 1px;
    width: 100%;
    background-color: #409eff;
    margin-top: 1px;
    margin-bottom: 3px;
  }
  .activity-info{
    color: #606266;
    padding-top: 5px;
  }
  .activity-detail{
    height: 100px;
    color: #606266;
    padding-top: 5px;
    overflow: hidden;
    text-overflow: ellipsis;
  }
  .activity-notice{
    color: #606266;
    height: 100%;
    overflow-y: scroll;
  }
  .items_img{
    position: relative;
    display: block;
    width: 153px;
    height: 206px;
    overflow: hidden;
    margin-right: 20px;
    float: left;
  }
  .items_txt{
    width: 480px;
    line-height: 24px;
    float: left;
  }
  .items_notice{
    position: relative;
    float: left;
    width: 100%;
    max-height: 150px;
    padding: 10px 3px;
  }
</style>
