<template>
  <div class="activity-item">
    <div class="activity-title">
      <div id="create-activity-div">
        <p>+</p>
      </div>
    </div>
  </div>
</template>

<script>
    export default {
        name: "createActivity"
    }
</script>

<style scoped>
  #create-activity-div>p{
    font-size: 35px;
  }
  .activity-item{
    width: 50%;
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
