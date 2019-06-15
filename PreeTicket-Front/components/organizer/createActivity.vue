<template>
  <div class="activity-item" v-on:click=showAct()>
    <div class="activity-title">
      <div id="create-activity-div">
        <p>+</p>
      </div>
    </div>


      <el-dialog
              title="新活动"
              width="450px"
              :visible.sync="act_dialog"
              center
              append-to-body>
          <el-form label-width="100px" ref="act_info_form" :model="act_info_form">
              <el-form-item label="活动名称" prop="name">
                  <el-input v-model="act_info_form.name"></el-input>
              </el-form-item>
              <el-form-item label="活动地点" prop="place">
                  <el-input v-model="act_info_form.place"></el-input>
              </el-form-item>
              <el-form-item label="活动报名时间" prop="time_signup">
                  <el-date-picker type="datetime" placeholder="" v-model="act_info_form.time_signup"></el-date-picker>
              </el-form-item>
              <el-form-item label="活动开始时间" prop="time_start">
                  <el-date-picker type="datetime" placeholder="" v-model="act_info_form.time_start"></el-date-picker>
              </el-form-item>
              <el-form-item label="活动最大人数" prop="capacity">
                  <el-input type="number" v-model="act_info_form.capacity"></el-input>
              </el-form-item>
              <el-form-item label="座位行数">
                  <el-input-number v-model="act_info_form.seat_row" type="number" :disabled="!act_info_form.status"></el-input-number>
              </el-form-item>
              <el-form-item label="座位列数">
                  <el-input-number v-model="act_info_form.seat_col" type="number" :disabled="!act_info_form.status"></el-input-number>
              </el-form-item>
              <el-form-item label="活动细节" prop="detail">
                  <el-input v-model="act_info_form.detail" type="textarea"></el-input>
              </el-form-item>
          </el-form>
          <span slot="footer" class="dialog-footer">
            <el-button type="primary" @click="createAct()">确认创建</el-button>
            </span>
      </el-dialog>
  </div>
</template>

<script>
    export default {
        name: "createActivity",
        data(){
            return{
                act_dialog: false,
                act_info_form:{
                    id: null,
                    status: true,
                    name: "",
                    time_signup: null,
                    time_start: null,
                    capacity: 0,
                    detail: "",
                    notice: [],
                    seat_row: 0,
                    seat_col: 0,
                    seats: [],
                },
            }
        },
        methods:{
            showAct(){
                this.act_dialog=true;
            },
            createAct(){
                // todo
                this.act_dialog = false
            }
        }
    }
</script>

<style scoped>
  #create-activity-div>p{
    font-size: 35px;
  }
  .activity-item{
    width: 60%;
    border: #79bbff 1px solid;
    border-radius: 6px;
    margin: 0 auto 5px auto;
    padding: 20px 20px;
    cursor: pointer;
  }
  .activity-title{
    width: 100%;
  }
  .activity-title>h1 {
    font-size: 30px;
    color: #303133;
  }
  #create-activity-div{
    width: 35px;
    height: 35px;
    background-color: #1a77ce;
    color: white;
    border-radius: 20px;
    line-height: 35px;
    padding-left: 8px;
  }
  #create-activity-div::after{
    display: block;
    width: 400px;
    position: relative;
    top: -34px;
    left: 40px;
    color: #1a77ce;
    content: "发起新的活动";
    font-size: 25px;
  }
</style>
