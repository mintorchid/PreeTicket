<template>
  <div style="width: 100%;background-color: #F1F1F1">
    <div style="width: 100%;height: 120px;margin-bottom: 20px;border-bottom: #606266 2px solid">

    </div>
    <div id="organizer-main">
      <div style="height: 700px;position: fixed;top:150px">
        <el-steps direction="vertical" :active="1">
          <el-step title="已开始的活动"></el-step>
          <el-step title="未开始的活动"></el-step>
        </el-steps>
      </div>

      <div style="width: 100%">
        <div class="part-line"></div>
        <CreateAct />
        <div id="activity-list">
          <Activity v-for="(act, index) in activities_ready" :key="index"
                    v-bind="act" />
        </div>
        <div class="part-line-down"></div>
      </div>
    </div>
  </div>
</template>

<script>
  import Activity from '~/components/participant/Activity.vue'
    export default {
        name: "main.vue",
      components:{
        CreateAct,
        Activity
      },
      data(){
          return {
            activeIndex: 1,
            activities_ready: [
              {id: 0, status: true,title: "test",time:"2019-8-8 17:33"},
              {id: 1, status: true,title: "test2",time:"2019-8-8 17:33"},
              {id: 2, status: false,title: "test3",time:"2019-8-8 17:33"},
              {id: 3, status: true,title: "test4",time:"2019-8-8 17:33"},
              ],
          }
      }
    }
</script>

<style scoped>
  #organizer-main{
    padding: 0 120px;
  }
  .part-title{
    padding-left: 15%;
  }
</style>
