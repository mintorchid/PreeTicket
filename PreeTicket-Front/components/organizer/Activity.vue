<template>
    <div class="activity-item">
        <a class="items_img">
            <img src="@/assets/img/qwe.jpg" style="width: 100%;height: 100%;"/>
        </a>
        <div class="items_txt">
            <div class="activity-title">
                <h1>{{ name }}</h1>
            </div>
            <div class="activity-title-line"></div>
            <div class="activity-title-line2"></div>
            <div class="activity-info">
                <p>报名时间：<i class="el-icon-alarm-clock" style="color: #1a77ce"></i>{{ time_signup }}</p>
                <p>活动时间：<i class="el-icon-alarm-clock" style="color: #1a77ce"></i>{{ time_start }}</p>
                <p>举办地点：<i class="el-icon-map-location" style="color: #1a77ce"></i> {{ place }}</p>
            </div>
            <div class="activity-detail">
                <p>{{detail}}</p>
            </div>
        </div>
        <div style="padding: 40px;text-align: right">
            <el-button type="primary" @click="seat_dialog = true" plain>设置座位图</el-button>
            <el-button type="primary" @click="act_dialog = true" plain>修改活动信息</el-button>
            <el-button type="primary" @click="notice_dialog = true" plain>管理活动通知</el-button>
        </div>
        <el-dialog
                :title="name"
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
                    <el-input-number v-model="act_info_form.seat_row" type="number" :disabled="!status"></el-input-number>
                </el-form-item>
                <el-form-item label="座位列数">
                    <el-input-number v-model="act_info_form.seat_col" type="number" :disabled="!status"></el-input-number>
                </el-form-item>
                <el-form-item label="活动细节" prop="detail">
                    <el-input v-model="act_info_form.detail" type="textarea"></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button type="primary" @click="submitChange" plain>提交修改</el-button>
                <el-button @click="act_dialog = false">取消</el-button>
            </span>
        </el-dialog>
        <el-dialog
                :visible.sync="seat_dialog"
                width="50%"
                append-to-body
                center>
            <div style="">
                <el-form label-width="100px" ref="act_info_form" :model="act_info_form">
                </el-form>
                <div style="float: right;padding-right: 30px;">
                    <p> <span  style="font-size: 20px;"><i class="el-icon-user" style="color: #ff3333"></i></span>：座位禁用</p>
                    <p> <span  style="font-size: 20px;"><i class="el-icon-user" style="color: #999999"></i></span>：座位可用</p>
                </div>
                <div style="padding: 30px;font-size: 17px">
                    <p>点击目标座位改变可用状态</p>
                </div>
                <div class="div_seat_map" style="padding: 30px;">
                    <div class="div_seat_row" style="font-size: 30px;display: flex" v-for="m in seat_row" :key="m">
                        <div class="div_seat_col" v-for="n in seat_col" :key="n" onclick="changeSeatStat(m,n)">
                            <i class="el-icon-user" :style="{color: seats[(m-1)][(n-1)]===2?'#ff3333':'#999999'}"></i>
                        </div>
                    </div>
                </div>
            </div>
        </el-dialog>
        <el-dialog
                :visible.sync="notice_dialog"
                title="通知管理"
                width="50%"
                :before-close="submitSeats()">
                append-to-body
                center>
            <div class="items_notice" style="">
                <div style="padding: 10px">
                    <p style="font-size: 15px;padding-bottom: 10px;">发布新通知:</p>
                    <el-input type="textarea" v-model="act_new_notice"></el-input>
                    <div  style="padding-top: 10px">
                        <el-button @click="newNotice()" type="primary">发布</el-button>
                    </div>
                </div>
                <div class="activity-notice" style="padding: 10px">
                    <p style="font-size: 15px;padding-bottom: 10px;">已发布的通知：</p>
                    <div class="activity-notice-item" v-for="(n,index) in notice" :key="index" style="width: 100%;padding: 6px 0;border-bottom: aqua 1px dotted">
                        <div style="float: left;width: 200px">
                            <p>{{ n.time }}</p>
                        </div>
                        <div style="margin-left: 200px">
                            <p>{{ n.content }}</p>
                        </div>
                    </div>
                </div>
            </div>
        </el-dialog>
    </div>
</template>

<script>
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
                seat_dialog:false,
                notice_dialog:false,
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
                act_new_notice: "",
            }
        },
        methods:{
            showActDialog(){
                this.act_dialog = true;
            },
            submitChange(){
                // todo
            },
            newNotice(){
                // todo
            },
            changeSeatStat(m,n){
                // todo
            },
            submitSeats(){
                // todo
            }
        }
    }
</script>

<style scoped>
    .activity-item{
        width: 60%;
        max-width: 650px;
        border-top-right-radius: 6px;
        border-bottom-right-radius: 6px;
        border-bottom: #409eff 1px dotted;
        margin: 0 auto;
        padding: 20px 20px;
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
        width: 380px;
        line-height: 24px;
        float: left;
    }
    .items_notice{
        position: relative;
        width: 100%;
        padding: 10px 3px;
    }
</style>
