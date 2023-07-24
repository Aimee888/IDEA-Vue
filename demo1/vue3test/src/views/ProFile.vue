<script>
export default {
  name: 'ProFile',
  data() {
    return {
      activeTab: 'userinfo',
      englishname: '',
      password: '',
      phone: '',
      email: '',
      role: '',
      user: {
        oldPassword: '',
        newPassword: '',
        confirmPassword: '',
      },
      rules: {
        oldPassword: [
          {required: true, message: '旧密码不能为空', trigger: 'blur'},
          {
            min: 3,
            max: 15,
            message: '长度在3到15个字符',
            trigger: 'blur'
          }
        ],
        newPassword: [
          {required: true, message: '新密码不能为空', trigger: 'blur'},
          {
            min: 3,
            max: 15,
            message: '长度在3到15个字符',
            trigger: 'blur'
          }
        ],
        confirmPassword: [
          {required: true, message: '确认密码不能为空', trigger: 'blur'},
          {
            min: 3,
            max: 15,
            message: '长度在3到15个字符',
            trigger: 'blur'
          }
        ]
      }
    }
  },
  mounted() {
    this.getuserdata()
  },
  methods: {
    getuserdata() {
      this.$axios
          .get('http://localhost:8081/api/Profile')
          .then(successResponse => {
            console.log(successResponse.data)
            this.englishname = successResponse.data.data.user.user_account
            this.password = successResponse.data.data.user.password
            this.phone = successResponse.data.data.userProfile.phonenumber
            this.email = successResponse.data.data.userProfile.email
            this.role = successResponse.data.data.userProfile.role
          })
          .catch(failResponse => {
            console.log(failResponse)
          })
    },
    passwordsubmit() {

    },
    emailsubmit() {

    },
    close() {

    }
  }
}

</script>

<template>
  <div class="app-container">
    <el-row :gutter="0">
      <el-col :span="7" :xs="24">
        <el-card class="box-card">
          <template v-slot:header>
            <div class="clearfix">
              <span>个人中心</span>
            </div>
          </template>
          <div>
            <ul class="list-group list-group-striped">
              <li class="list-group-item">
                <svg-icon icon-class="sharp" />
                姓名
                <div class="user-item">{{ englishname }}</div>
              </li>
              <li class="list-group-item">
                <svg-icon icon-class="phone" />
                手机号码
                <div class="user-item">{{phone}}</div>
              </li>
              <li class="list-group-item">
                邮箱
                <div class="user-item">{{email}}</div>
              </li>
              <li class="list-group-item">
                所属角色
                <div class="user-item">{{ role }}</div>
              </li>
            </ul>
          </div>
        </el-card>
      </el-col>
      <el-col :span="15" :xs="24">
        <el-card>
          <template v-slot:header>
            <div class="clearfix">
              <span>基本资料</span>
            </div>
          </template>
          <el-tabs v-model="activeTab">
            <el-tab-pane label="基本资料" name="userinfo">
              <el-form ref="userRef" :model="user" :rules="rules" label-width="80px">
                <el-form-item label="用户昵称" prop="englishname">
                  <el-input v-model="englishname" maxlength="30" />
                </el-form-item>
                <el-form-item label="邮箱" prop="Email">
                  <el-input v-model="email" maxlength="30" />
                </el-form-item>
                <el-form-item>
                  <el-button type="primary" @click="emailsubmit">保存</el-button>
                  <el-button type="danger" @click="close">关闭</el-button>
                </el-form-item>
              </el-form>
            </el-tab-pane>
            <el-tab-pane label="密码修改" name="resetPwd">
              <el-form ref="pwdRef" :model="user" :rules="rules" label-width="138px">
                <el-form-item label="旧密码" prop="oldPassword">
                  <el-input v-model="user.oldPassword" placeholder="请输入旧密码" type="password" show-password/>
                </el-form-item>
                <el-form-item label="新密码" prop="newPassword">
                  <el-input v-model="user.newPassword" placeholder="请输入新密码" type="password" show-password />
                </el-form-item>
                <el-form-item label="确认密码" prop="confirmPassword">
                  <el-input v-model="user.confirmPassword" placeholder="请确认新密码" type="password" show-password/>
                </el-form-item>
                <el-form-item>
                  <el-button type="primary" @click="passwordsubmit">保存</el-button>
                  <el-button type="danger" @click="close">关闭</el-button>
                </el-form-item>
              </el-form>
            </el-tab-pane>
          </el-tabs>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<style>
.el-col {
  padding: 10px;
}
.list-group-item {
  text-align: left;
  display: list-item;
  height: 20px;
  border-bottom: 1px solid #cccccc;
  padding: 10px;
  font-size: 16px;
}
.user-item {
  float: right;
}
.clearfix {
  font-size: 24px;
  font-weight: bold;
}
.el-tabs__item {
  font-size: 16px !important;
}

</style>
