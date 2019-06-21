<template>
  <div style="width: 100%;background-color: #F1F1F1">
    <div style="width: 100%;height: 65px;margin-bottom: 20px;background: #409eff;border-radius: 0 0 10px 10px;position: fixed;z-index: 99">
      <p style="color: #ffffff;font-size: 20px;padding: 20px 0 0 20px">Welcome, {{nickname}}</p>
      <div style="position:absolute;right: 20px;top:10px">
        <el-button style="width:42px;height:42px;background: rgba(255,255,255,0);border:#ffffff 1px solid;border-radius:20px;color: white" @click="ToTop"><i class="el-icon-arrow-up" style="font-size: 20px;margin-left: -9px;line-height: 12px"></i></el-button>
      </div>
    </div>
    <div style="width: 100%;height: 65px;margin-bottom: 20px;background: #409eff;border-radius: 0 0 10px 10px;">
    </div>
    <div id="organizer-main">
      <div style="width: 100%">
        <div class="part-line"></div>
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
    import Cookies from "js-cookie"
    export default {
        name: "main.vue",
        components:{
            Activity
        },
        data(){
            return {
              nickname:Cookies.get('nickname'),
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
        },
      methods:{
          ToTop(){
            location.href='#';
          }
      }
    }
</script>

<style scoped>
  #organizer-main{
  }
</style>
