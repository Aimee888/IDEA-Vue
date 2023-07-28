<template>
  <div class="layout">
    <el-container class="container">
      <el-aside class="aside">
        <div class="head">
          <div>
            <span>后台管理系统</span>
          </div>
        </div>
        <div class="line" />
        <el-menu
            background-color="#222832"
            text-color="#fff"
            :router="true"
            :default-openeds="state.defaultOpen"
            :default-active='state.currentPath'
        >
            <el-menu-item index="/Hometest">
            <el-icon><HomeFilled /></el-icon>
            <span><strong>首页</strong></span>
          </el-menu-item>
          <el-sub-menu index="2">
            <template #title>
              <el-icon><Menu /></el-icon>
              <span><strong>系统管理</strong></span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="/Role"><el-icon><Avatar /></el-icon>角色管理</el-menu-item>
              <el-menu-item index="/AboutTest"><el-icon><QuestionFilled /></el-icon>关于</el-menu-item>
            </el-menu-item-group>
          </el-sub-menu>
        </el-menu>
      </el-aside>
      <el-container class="content">
        <HeaderTest />
        <div class="main">
          <router-view />
        </div>
        <FooterTest />
      </el-container>
    </el-container>
  </div>
</template>

<script setup>
import { reactive } from 'vue'
import { useRouter } from 'vue-router'
import HeaderTest from "@/views/HeaderTest.vue"
import FooterTest from "@/views/FooterTest.vue"

const noMenu = ['/LoginPage']
const router = useRouter()
const state = reactive({
  showMenu: true,
  defaultOpen: ['1', '2', '3', '4'],
  currentPath: '/',
})

router.afterEach((to) => {
  state.showMenu = !noMenu.includes(to.path)
})

router.beforeEach((to) => {
  state.currentPath = to.path
  document.title = to.name
})
</script>

<style scoped>
.layout {
  min-height: 100vh;
  background-color: #ffffff;
}
.container {
  height: 100vh;
}
.aside {
  width: 200px!important;
  background-color: #222832;
}
.head {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 50px;
}
.head > div {
  display: flex;
  align-items: center;
}

.head img {
  width: 50px;
  height: 50px;
  margin-right: 10px;
}
.head span {
  font-size: 20px;
  color: #ffffff;
}
.line {
  border-top: 1px solid hsla(0,0%,100%,.05);
  border-bottom: 1px solid rgba(0,0,0,.2);
}
.content {
  display: flex;
  flex-direction: column;
  max-height: 100vh;
  overflow: hidden;
}
.main {
  height: calc(100vh - 100px);
  overflow: auto;
  padding: 10px;
}
</style>

<style>
body {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}
.el-menu {
  border-right: none!important;
}
.el-submenu {
  border-top: 1px solid hsla(0, 0%, 100%, .05);
  border-bottom: 1px solid rgba(0, 0, 0, .2);
}
.el-submenu:first-child {
  border-top: none;
}
.el-submenu [class^="el-icon-"] {
  vertical-align: -1px!important;
}
a {
  color: #409eff;
  text-decoration: none;
}
.el-pagination {
  text-align: center;
  margin-top: 20px;
}
.el-popper__arrow {
  display: none;
}
</style>
