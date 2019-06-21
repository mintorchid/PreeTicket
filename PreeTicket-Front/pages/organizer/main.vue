<template>
  <div style="width: 100%;background-color: #F1F1F1">
    <div style="width: 100%;height: 70px;margin-bottom: 20px;border-bottom: #606266 2px solid">

    </div>
    <div id="organizer-main">
      <div style="height: 400px;position: fixed;top:150px;left:5%">
        <el-steps direction="vertical" :active="1">
          <el-step title="未开始的活动"></el-step>
          <el-step title="已开始的活动"></el-step>
          <el-step title="已结束活动"></el-step>
        </el-steps>
      </div>

      <div style="width: 100%">
        <div class="part-line"></div>
        <CreateAct />
        <div id="activity-list">
          <Activity v-for="(act, index) in activities_ready" :key="index"
                    v-bind="act" :index="index" />
        </div>
        <div class="part-line-down"></div>
      </div>
    </div>
  </div>
</template>

<script>
  import CreateAct from '~/components/organizer/createActivity.vue'
  import Activity from '~/components/organizer/Activity.vue'
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
              {id: 0, status: false,name: "test",place:"here",time_start:"2019-8-8 17:33",time_signup:"2019-8-8 17:33",capacity:12,seat_row:9,seat_col:13,seats:[[{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},],[{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},],[{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},],[{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},],[{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},],[{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},],[{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},],[{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},],[{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},{stat: 0},],],
                detail:"qweseasdadawesjetssergesrrgesd阿瑟热伤风荣获微软忒热被窝二万人vwe为对方v为v为qweseasdadawesjetssergesrrgesd阿瑟热伤风荣获微软忒热被窝二万人vwe为对方v为v为qweseasdadawesjetssergesrrgesd阿瑟热伤风荣获微软忒热被窝二万人vwe为对方v为v为qweseasdadawesjetssergesrrgesd阿瑟热伤风荣获微软忒热被窝二万人vwe为对方v为v为qweseasdadawesjetssergesrrgesd阿瑟热伤风荣获微软忒热被窝二万人vwe为对方v为v为qweseasdadawesjetssergesrrgesd阿瑟热伤风荣获微软忒热被窝二万人vwe为对方v为v为",
                notice:[{time:"2019-8-8 11:23", content:"qwedfgbnmuretfgrgerg"},{time:"2019-8-9 11:23", content:"qwedfgbnawedfgbna wedfgbnawedf gbnawedfgbnawedfg bnawedfgbnawedfgbnawedfg bnawedfgbnawedfgbnasdawrgerg"},{time:"2019-8-10 11:23", content:"qwedfgbnmuretfgrgerg"}],
              },
              {id: 1, status: true,name: "test1",place:"here",time_start:"2019-8-8 17:33",time_signup:"2019-8-8 17:33",capacity:12,seat_row:3,seat_col:3,seats:[[{stat: 0}, {stat:2}, {stat:1},],[{stat: 0}, {stat:2}, {stat:1},],[{stat: 0}, {stat:2}, {stat:1},],],
                detail:"qweseasdadawesjetssergesrrgesd阿瑟热伤风荣获微软忒热被窝二万人vwe为对方v为v为qweseasdadawesjetssergesrrgesd阿瑟热伤风荣获微软忒热被窝二万人vwe为对方v为v为qweseasdadawesjetssergesrrgesd阿瑟热伤风荣获微软忒热被窝二万人vwe为对方v为v为qweseasdadawesjetssergesrrgesd阿瑟热伤风荣获微软忒热被窝二万人vwe为对方v为v为qweseasdadawesjetssergesrrgesd阿瑟热伤风荣获微软忒热被窝二万人vwe为对方v为v为qweseasdadawesjetssergesrrgesd阿瑟热伤风荣获微软忒热被窝二万人vwe为对方v为v为",
                notice:[{time:"2019-8-8 11:23", content:"qwedfgbnmuretfgrgerg"},{time:"2019-8-9 11:23", content:"qwedfgbnasdawrgerg"},{time:"2019-8-10 11:23", content:"qwedfgbnmuretfgrgerg"}],
              },
              {id: 2, status: true,name: "test2",place:"here",time_start:"2019-8-8 17:33",time_signup:"2019-8-8 17:33",capacity:12,seat_row:3,seat_col:3,seats:[[{stat: 0}, {stat:2}, {stat:1},],[{stat: 0}, {stat:2}, {stat:1},],[{stat: 0}, {stat:2}, {stat:1},],],
                detail:"qweseasdadawesjetssergesrrgesd阿瑟热伤风荣获微软忒热被窝二万人vwe为对方v为v为qweseasdadawesjetssergesrrgesd阿瑟热伤风荣获微软忒热被窝二万人vwe为对方v为v为qweseasdadawesjetssergesrrgesd阿瑟热伤风荣获微软忒热被窝二万人vwe为对方v为v为qweseasdadawesjetssergesrrgesd阿瑟热伤风荣获微软忒热被窝二万人vwe为对方v为v为qweseasdadawesjetssergesrrgesd阿瑟热伤风荣获微软忒热被窝二万人vwe为对方v为v为qweseasdadawesjetssergesrrgesd阿瑟热伤风荣获微软忒热被窝二万人vwe为对方v为v为",
                notice:[{time:"2019-8-8 11:23", content:"qwedfgbnmuretfgrgerg"},{time:"2019-8-9 11:23", content:"qwedfgbnasdawrgerg"},{time:"2019-8-10 11:23", content:"qwedfgbnmuretfgrgerg"}],
              },
              {id: 3, status: true,name: "test3",place:"here",time_start:"2019-8-8 17:33",time_signup:"2019-8-8 17:33",capacity:12,seat_row:3,seat_col:3,seats:[[{stat: 0}, {stat:2}, {stat:1},],[{stat: 0}, {stat:2}, {stat:1},],[{stat: 0}, {stat:2}, {stat:1},],],
                detail:"qweseasdadawesjetssergesrrgesd阿瑟热伤风荣获微软忒热被窝二万人vwe为对方v为v为qweseasdadawesjetssergesrrgesd阿瑟热伤风荣获微软忒热被窝二万人vwe为对方v为v为qweseasdadawesjetssergesrrgesd阿瑟热伤风荣获微软忒热被窝二万人vwe为对方v为v为qweseasdadawesjetssergesrrgesd阿瑟热伤风荣获微软忒热被窝二万人vwe为对方v为v为qweseasdadawesjetssergesrrgesd阿瑟热伤风荣获微软忒热被窝二万人vwe为对方v为v为qweseasdadawesjetssergesrrgesd阿瑟热伤风荣获微软忒热被窝二万人vwe为对方v为v为",
                notice:[{time:"2019-8-8 11:23", content:"qwedfgbnmuretfgrgerg"},{time:"2019-8-9 11:23", content:"qwedfgbnasdawrgerg"},{time:"2019-8-10 11:23", content:"qwedfgbnmuretfgrgerg"}],
              },
              {id: 4, status: true,name: "test4",place:"here",time_start:"2019-8-8 17:33",time_signup:"2019-8-8 17:33",capacity:12,seat_row:3,seat_col:3,seats:[[{stat: 0}, {stat:2}, {stat:1},],[{stat: 0}, {stat:2}, {stat:1},],[{stat: 0}, {stat:2}, {stat:1},],],
                detail:"qweseasdadawesjetssergesrrgesd阿瑟热伤风荣获微软忒热被窝二万人vwe为对方v为v为qweseasdadawesjetssergesrrgesd阿瑟热伤风荣获微软忒热被窝二万人vwe为对方v为v为qweseasdadawesjetssergesrrgesd阿瑟热伤风荣获微软忒热被窝二万人vwe为对方v为v为qweseasdadawesjetssergesrrgesd阿瑟热伤风荣获微软忒热被窝二万人vwe为对方v为v为qweseasdadawesjetssergesrrgesd阿瑟热伤风荣获微软忒热被窝二万人vwe为对方v为v为qweseasdadawesjetssergesrrgesd阿瑟热伤风荣获微软忒热被窝二万人vwe为对方v为v为",
                notice:[{time:"2019-8-8 11:23", content:"qwedfgbnmuretfgrgerg"},{time:"2019-8-9 11:23", content:"qwedfgbnasdawrgerg"},{time:"2019-8-10 11:23", content:"qwedfgbnmuretfgrgerg"}],
              },
              ],
          }
      }
    }
</script>

<style scoped>
  html body{

    min-width: 1000px;
  }
  #organizer-main{
    padding: 0 120px;
  }
  .part-title{
    padding-left: 15%;
  }
</style>
