<script>
import {ElMessageBox} from "element-plus";
import router from "@/router";

export default {
  name: 'HeaderPage',
  data() {
    return {
      user_name: this.$route.query.param
    }
  },
  methods: {
    handleCommand(command) {
      switch (command) {
        case "logout":
          this.logout();
          break;
        default:
          break;
      }
    },
    logout() {
      ElMessageBox.confirm('确定注销并退出系统吗？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        console.log("退出")
        router.push({path: '/'})
      }).catch(() => { });
    }
  }
}

</script>

<template>
  <div>
    <div class="head">
      <div>
        <span>123{{user_name}}</span>
      </div>
      <div class="avatar-container">
        <el-dropdown @command="handleCommand" class="right-menu-item hover-effect" trigger="click">
          <div class="avatar-wrapper">
            <img src="@/assets/user.png" alt="userlogo" class="user-avatar">
            <el-icon><caret-bottom /></el-icon>
          </div>
          <template #dropdown>
            <el-dropdown-menu>
              <router-link to="/ProFile">
                <el-dropdown-item>User Profile</el-dropdown-item>
              </router-link>
              <el-dropdown-item divided command="logout">
                <span>Logout</span>
              </el-dropdown-item>
            </el-dropdown-menu>
          </template>
        </el-dropdown>
      </div>
    </div>
    <div class="line" />
  </div>
</template>

<style scoped>
.head {
  display: flex;
  align-items: center;
  justify-content: right;
  height: 50px;
  background-color: #222832;
}
.head > div {
  display: flex;
  align-items: center;
  margin-right: 20px;
}
.head span {
  font-size: 15px;
  color: #ffffff;
}
.line {
  border-top: 1px solid hsla(0,0%,100%,.05);
  border-bottom: 1px solid rgba(0,0,0,.2);
}
.user-avatar {
  cursor: pointer;
  width: 25px;
  height: 25px;
  border-radius: 10px;
}
</style>
