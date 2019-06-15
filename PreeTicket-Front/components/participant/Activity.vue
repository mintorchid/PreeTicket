<template>
    <div class="activity-item" v-on:click="showActDialog">
        <a class="items_img">
            <img src="@/assets/img/qwe.jpg" style="width: 40%;height: 40%;"/>
        </a>
        <div class="items_txt">
            <div class="activity-title">
                <h1>{{ name }}</h1>
            </div>
            <div class="activity-title-line"></div>
            <div class="activity-title-line2"></div>
            <div class="activity-info">
                <p>活动时间：<i class="el-icon-time" style="color: #1a77ce"></i>{{ time_start }}</p>
                <p>举办地点：<i class="el-icon-map-location" style="color: #1a77ce"></i> {{ place }}</p>
                <p style="padding-top: 15px">最新通知：</p>
                <div style="width: 100%;padding: 9px 0;background: #f3f3f3;border-top: #dddddd 1px solid">
                    <div style="float: left;width: 200px">
                        <p>{{ notice[0].time }}</p>
                    </div>
                    <div style="margin-left: 200px">
                        <p>{{ notice[0].content }}</p>
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
                <el-form-item label="活动报名时间:" prop="time_signup">
                    <p><i class="el-icon-time"></i> {{ act_info_form.time_signup }}</p>
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


            <el-dialog
                    :visible.sync="seat_dialog"
                    :fullscreen="true"
                    append-to-body
                    center>
                <div style="">
                    <el-form label-width="100px" ref="act_info_form" :model="act_info_form">
                    </el-form>
                    <div style="float: right;padding-right: 30px;">
                        <p> <span  style="font-size: 20px;"><i class="el-icon-user" style="color: #33ee33"></i></span>：座位被占用</p>
                        <p> <span  style="font-size: 20px;"><i class="el-icon-user" style="color: #999999"></i></span>：座位可用</p>
                    </div>
                    <div style="padding: 30px;font-size: 17px">
                    </div>
                    <div class="div_seat_map" style="padding: 30px;">
                        <div class="div_seat_row" style="font-size: 30px;display: flex" v-for="m in seat_row" :key="m">
                            <div class="div_seat_col" v-for="n in seat_col" :key="n" v-on:click="chooseSeat(m,n)">
                                <i class="el-icon-user" :style="{color: seats[(m-1)][(n-1)]===2?'#fdfdfe':seats[(m-1)][(n-1)]===0?'#cccccc':'#33ee33'}"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </el-dialog>
        </el-dialog>
    </div>
</template>

<script>
    import $ from 'jquery'
    import Vue from 'vue'
    export default {
        name: "Activity",
        props: {
            id: Number,
            status: Boolean,
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
                act_dialog: false,
                seat_dialog: false,
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
            }
        },
        methods:{
            showActDialog(){
                this.act_dialog = true;
                console.log("wedawdawd");
            },
            signUpAct(){
                // todo
                this.seat_dialog = true;
            },
            chooseSeat(m,n){
                if(this.seat_choose.number != 0){
                    console.log(this.seat_choose);
                    $(".div_seat_row:eq("+ (this.seat_choose.row-1) + ")>.div_seat_col:eq("+ (this.seat_choose.col-1) +")>i").css("color","#cccccc");
                }
                this.seat_choose.row = m;
                this.seat_choose.col = n;
                this.seat_choose.number = m*n;
                $(".div_seat_row:eq("+ (m-1) + ")>.div_seat_col:eq("+ (n-1) +")>i").css("color","#7070ff");
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
