<!--<template>
    <div class="page">
        <h2>Home Page</h2>
       <li class="fa fa-home fa-lg"></li>
        <el-button type="primary" @click="testAxios()">测试Axios调用</el-button>
        <el-button type="primary" @click="getUser()">获取用户信息</el-button>
        <el-button type="primary" @click="getMenu()">获取菜单信息</el-button>
    </div>
</template>

 <script>-->
<!--import axios from "axios"
import mock from '@/mock/index.js'
export default {
    name:"Home",
    methods: {
        testAxios() {
            axios.get('http://localhost:8080').then(res=> {alert(res.data)})
        },
        getUser() {
            axios.get('http://localhost:8080/user').then(res=> {alert(JSON.stringify(res.data))})
        },
        getMenu() {
            axios.get('http://localhost:8080/menu').then(res=> {alert(JSON.stringify(res.data))})
        },
    }
}
 </script>-->

 <template>
  <div class="container">
      <!-- 导航菜单栏 -->
      <nav-bar></nav-bar>
      <!-- 头部区域 -->
      <head-bar></head-bar>
      <!-- 主内容区域 -->
      <main-content></main-content>
  </div>
</template>

<script>
import HeadBar from "./HeadBar"
import NavBar from "./NavBar"
import MainContent from "./MainContent"
export default {
  components:{
        HeadBar,
        NavBar,
        MainContent
  }
};
</script>

<style scoped lang="scss">
  .container {
    position:absolute;
    top: 0px;
    left: 0px;
    right: 0px;
    bottom: 0px;
    // background: rgba(224, 234, 235, 0.1);
  }
</style>  