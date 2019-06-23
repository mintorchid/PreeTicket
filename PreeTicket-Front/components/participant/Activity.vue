<template>
    <div class="activity-item" v-on:click="showActDialog">
        <a class="items_img">
            <img src="@/assets/img/qwe.jpg" style="width: 40%;height: 40%;"/>
        </a>
        <div class="items_txt">
            <div class="activity-title">
                <h1 :style="{color:status?'#303133':'#707173'}">{{ name }}{{status===1?"":"（已关闭）"}}</h1>
            </div>
            <div class="activity-title-line"></div>
            <div class="activity-title-line2"></div>
            <div class="activity-info">
                <p>活动时间：<i class="el-icon-time" style="color: #1a77ce"></i>{{ time_start }}</p>
                <p>举办地点：<i class="el-icon-map-location" style="color: #1a77ce"></i> {{ place }}</p>
                <p style="padding-top: 15px">最新通知：</p>
                <div style="width: 100%;padding: 9px 0;background: #f3f3f3;border-top: #dddddd 1px solid">
                    <div style="float: left;width: 200px">
                        <p>{{ notice[0].time_publish }}</p>
                    </div>
                    <div style="margin-left: 200px">
                        <p>{{ notice[0].detail }}</p>
                    </div>
                </div>
            </div>
        </div>

        <el-dialog
                :title="name"
                :fullscreen="true"
                :visible.sync="act_dialog"
                center
                append-to-body>
            <div style="margin-bottom: 20px">
                <el-button type="primary" @click="signUpAct" style="width: 100%;height: 50px">报名参加</el-button>
            </div>
            <el-form label-width="100px" ref="act_info_form" :model="act_info_form" size="mini">
                <el-form-item label="活动名称:" prop="name">
                    <p>{{ act_info_form.name }}</p>
                </el-form-item>
                <el-form-item label="活动地点:" prop="place">
                    <p>{{ act_info_form.place }}</p>
                </el-form-item>
                <el-form-item label="活动开始时间:" prop="time_start">
                    <p><i class="el-icon-time"></i> {{ act_info_form.time_start }}</p>
                </el-form-item>
                <el-form-item label="活动最大人数:" prop="capacity">
                    <p>{{ act_info_form.capacity }}</p>
                </el-form-item>
                <el-form-item label="活动细节:" prop="detail">
                    <div>
                        <p>{{ act_info_form.detail }}</p>
                    </div>
                </el-form-item>
            </el-form>


        </el-dialog>
      <el-dialog
        :visible.sync="seat_dialog"
        :fullscreen="true"
        append-to-body
        center>
        <div style="">
          <div v-if="!ticket"  style="padding: 20px 0">
            <el-button type="info" @click="getSeatMap" style="width: 100%;height:45px" plain>刷新</el-button>
          </div>
          <div style="float: right;padding-right: 30px;">
            <p> <span  style="font-size: 20px;"><i class="el-icon-user" style="color: #33ee33"></i></span>：座位被占用</p>
            <p> <span  style="font-size: 20px;"><i class="el-icon-user" style="color: #999999"></i></span>：座位可用</p>
          </div>
          <div style="padding: 30px;font-size: 17px">
          </div>
          <div class="div_seat_map" style="padding: 30px;text-align: center">
            <div class="div_seat_row" style="width:100%;font-size: 35px;display: flex;align-items: center; justify-content: space-between;" v-for="m in seat_row" :key="m">
              <div class="div_seat_col" v-for="n in seat_col" :key="n" v-on:click="chooseSeat(m,n)">
                <i class="el-icon-user" :style="{color: seats[(m-1)][(n-1)].stat===-1?'#7070ff':seats[(m-1)][(n-1)].stat===2?'#fdfdfe':seats[(m-1)][(n-1)].stat===0?'#cccccc':'#33ee33'}"></i>
              </div>
            </div>
            <div v-if="!ticket" style="margin-top: 30px">
              <el-button type="primary" @click="confirmSeat" style="width: 60%">确认</el-button>
            </div>
          </div>
        </div>
      </el-dialog>
      <el-dialog
        :visible.sync="seat_dialog2"
        :fullscreen="true"
        append-to-body
        center>
        <div style="">
          <div style="float: right;padding-right: 30px;">
            <p> <span  style="font-size: 20px;"><i class="el-icon-user" style="color: #33ee33"></i></span>：座位被占用</p>
            <p> <span  style="font-size: 20px;"><i class="el-icon-user" style="color: #999999"></i></span>：座位可用</p>
          </div>
          <div style="padding: 30px;font-size: 17px">
          </div>
          <div class="div_seat_map" style="padding: 30px;text-align: center">
            <div class="div_seat_row" style="width:100%;font-size: 35px;display: flex;align-items: center; justify-content: space-between;" v-for="m in seat_row" :key="m">
              <div class="div_seat_col" v-for="n in seat_col" :key="n" v-on:click="chooseSeat(m,n)">
                <i class="el-icon-user" :style="{color: seats[(m-1)][(n-1)].stat===-1?'#7070ff':seats[(m-1)][(n-1)].stat===2?'#fdfdfe':seats[(m-1)][(n-1)].stat===0?'#cccccc':'#33ee33'}"></i>
              </div>
            </div>
            <div  style="margin-top: 30px">
              <p>您的座位在：第{{seat_choose.row}}排 第{{seat_choose.col}}列 {{seat_choose.number}}号</p>
            </div>
          </div>
        </div>
      </el-dialog>
    </div>
</template>

<script>
  import Cookies from "js-cookie"
  import API from "~/api";
    export default {
        name: "Activity",
        props: {
            id: Number,
            status: Number,
            name: String,
            place:String,
            time_signup: String,
            time_start: String,
            capacity: Number,
            detail:String,
            notice:Array,
            seat_row:Number,
            seat_col:Number,
            seats:Array,
        },
        data(){
            return{
                user_id:Cookies.get('userid'),
                act_dialog: false,
              seat_dialog: false,
              seat_dialog2: false,
                act_info_form:{
                    id: this.id,
                    status: this.status,
                    name: this.name,
                    place: this.place,
                    time_signup: this.time_signup,
                    time_start: this.time_start,
                    capacity: this.capacity,
                    detail: this.detail,
                    notice: this.notice,
                    seat_row: this.seat_row,
                    seat_col: this.seat_col,
                    seats: this.seats,
                },
                seat_choose:{row:0, col:0, number:0},
                ticket:false,
            }
        },
        methods:{
            showActDialog(){
              if(this.status===0){return}
              API.participantGetTicket({
                actID: this.act_info_form.id,
                userID: this.user_id
              }).then(res=>{
                if(res.code===200){
                  console.log(res.data%this.seat_col+1);
                  this.$set(this.seat_choose, 'number', res.data);
                  this.$set(this.seat_choose, 'row', parseInt(res.data/this.seat_col)+1);
                  this.$set(this.seat_choose, 'col', res.data%this.seat_col);
                  this.$set(this.seats[this.seat_choose.row-1][this.seat_choose.col-1], 'stat',-1);
                  this.ticket=true;
                  this.seat_dialog2 = true;
                }else{
                  this.act_dialog = true;
                }
              });
            },
            signUpAct(){
              API.participantJoinAct({
                id_act: this.act_info_form.id,
                id_user: this.user_id
              }).then(res=>{
                this.seat_dialog = true;
              });
            },
            chooseSeat(m,n){
              if(this.ticket===true){return}
              if(this.seats[m-1][n-1].stat===0){
                if(this.seat_choose.number !== 0){
                  this.$set(this.seats[this.seat_choose.row-1][this.seat_choose.col-1], 'stat', 0);
                }
                this.seat_choose.row = m;
                this.seat_choose.col = n;
                this.seat_choose.number = (m-1) * this.seat_col+n;
                this.$set(this.seats[this.seat_choose.row-1][this.seat_choose.col-1], 'stat', -1);
              }
            },
          getSeatMap(){
            API.participantGetSeatMap({
              id_act: this.act_info_form.id,
            }).then(res=>{
              for(let i=0;i<this.seat_row;i++){
                for(let j=0;j<this.seat_col;j++){
                  this.$set(this.seats[i][j], 'stat', Number(res.data.seat_map[i*this.seat_row+j]));
                }
              }
            });
          },
          confirmSeat(){
              API.participantChooseSeat({
                id_activity: this.act_info_form.id,
                id_user:this.user_id,
                seat: this.seat_choose.number,
              }).then(res=>{
                this.$message.success("操作成功");
                location.reload();
              })
          }
        }
    }
</script>

<style scoped>
    .activity-item{
        width: 100%;
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
        width: 75px;
        background-color: #409eff;
        margin-top: 2px;
    }
    .activity-title-line2{
        height: 1px;
        background-color: #409eff;
        margin-top: 1px;
        margin-bottom: 3px;
    }
    .activity-info{
        color: #606266;
        padding-top: 5px;
    }
    .items_img{
        position: relative;
        display: block;
        overflow: hidden;
        margin-right: 20px;
        float: left;
    }
    .items_txt{
        line-height: 24px;
        float: left;
    }
</style>
