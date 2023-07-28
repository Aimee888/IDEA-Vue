<script>
export default {
  name: 'Role',
  data() {
    return {
      currentPage: 1,
      pageSize: 10,
      total:0,
      userlist: [
        {
          'name': 'lili',
          'sex': 'boy',
          'age': 18,
          'native': '汉',
          'hobby': '打羽毛球'
        },
        {
          'name': 'lili',
          'sex': 'boy',
          'age': 18,
          'native': '汉',
          'hobby': '打羽毛球'
        },
        {
          'name': 'lili',
          'sex': 'boy',
          'age': 18,
          'native': '汉',
          'hobby': '打羽毛球'
        },
        {
          'name': 'lili',
          'sex': 'boy',
          'age': 18,
          'native': '汉',
          'hobby': '打羽毛球'
        },
        {
          'name': 'lili',
          'sex': 'boy',
          'age': 18,
          'native': '汉',
          'hobby': '打羽毛球'
        },
        {
          'name': 'lili',
          'sex': 'boy',
          'age': 18,
          'native': '汉',
          'hobby': '打羽毛球'
        },
        {
          'name': 'lili',
          'sex': 'boy',
          'age': 18,
          'native': '汉',
          'hobby': '打羽毛球'
        },
        {
          'name': 'lili',
          'sex': 'boy',
          'age': 18,
          'native': '汉',
          'hobby': '打羽毛球'
        },
        {
          'name': 'lili',
          'sex': 'boy',
          'age': 18,
          'native': '汉',
          'hobby': '打羽毛球'
        },
        {
          'name': 'lili',
          'sex': 'boy',
          'age': 18,
          'native': '汉',
          'hobby': '打羽毛球'
        },
        {
          'name': 'lili',
          'sex': 'boy',
          'age': 18,
          'native': '汉',
          'hobby': '打羽毛球'
        },
        {
          'name': 'lili',
          'sex': 'boy',
          'age': 18,
          'native': '汉',
          'hobby': '打羽毛球'
        },
        {
          'name': 'lili',
          'sex': 'boy',
          'age': 18,
          'native': '汉',
          'hobby': '打羽毛球'
        },
        {
          'name': 'lili',
          'sex': 'boy',
          'age': 18,
          'native': '汉',
          'hobby': '打羽毛球'
        },
        {
          'name': 'lili',
          'sex': 'boy',
          'age': 18,
          'native': '汉',
          'hobby': '打羽毛球'
        },
        {
          'name': 'lili',
          'sex': 'boy',
          'age': 18,
          'native': '汉',
          'hobby': '打羽毛球'
        },
        {
          'name': 'lili',
          'sex': 'boy',
          'age': 18,
          'native': '汉',
          'hobby': '打羽毛球'
        },
        {
          'name': 'lili',
          'sex': 'boy',
          'age': 18,
          'native': '汉',
          'hobby': '打羽毛球'
        },
        {
          'name': 'lili',
          'sex': 'boy',
          'age': 18,
          'native': '汉',
          'hobby': '打羽毛球'
        },
        {
          'name': 'lili',
          'sex': 'boy',
          'age': 18,
          'native': '汉',
          'hobby': '打羽毛球'
        },
        {
          'name': 'lili',
          'sex': 'boy',
          'age': 18,
          'native': '汉',
          'hobby': '打羽毛球'
        },
        {
          'name': 'lili',
          'sex': 'boy',
          'age': 18,
          'native': '汉',
          'hobby': '打羽毛球'
        },
        {
          'name': 'lili',
          'sex': 'boy',
          'age': 18,
          'native': '汉',
          'hobby': '打羽毛球'
        }
      ]
    }
  },
  mounted() {
    this.getdata()
  },
  methods: {
    getdata() {
      // 获取数据列表，可以从后台获取
      this.$axios.get("http://localhost:8081/api/roles")
          .then(successResponse => {
            console.log(successResponse.data)
            this.total = successResponse.data.data.total
            // this.pageSize = this.total
            const start = (this.currentPage - 1) * this.pageSize
            const end = start + this.pageSize
            this.userlist = successResponse.data.data.role.slice(start, end)
          })
          .catch(failResponse => {
            console.log(failResponse)
          })
    },
    handleCurrentChange(page){
      this.currentPage = page;
      // this.pageSize = this.total
      this.getdata();
    }
  }
}
</script>

<template>
  <div>
  <el-card>
      <div class="app-container">
        <!-- 表格数据 -->
        <el-table
            :data="userlist"
            :header-cell-style="{background:'#f8f8ff'}"
            style="width: 100%"
            border
            stripe
            max-height="660px"
        >
          <el-table-column label="姓名" prop="name" min-width="15%" />
          <el-table-column label="性别" prop="sex" :show-overflow-tooltip="true" min-width="15%" />
          <el-table-column label="年龄" prop="age" :show-overflow-tooltip="true" min-width="15%" />
          <el-table-column label="籍贯" prop="native" min-width="15%" />
          <el-table-column label="兴趣爱好" prop="hobby" min-width="40%" />
        </el-table>
        <el-pagination
            @current-change="handleCurrentChange"
            :current-page="currentPage"
            :page-size="pageSize"
            :total="total">
        </el-pagination>
      </div>
    </el-card>
  </div>
</template>

<style lang="less">
.el-table {
  text-align: left;
}
//.el-tabs--card {
//  height: calc(100vh - 230px);
//}
//.el-tab-pane {
//  height: calc(100vh - 230px);
//  overflow: auto;
//}
</style>
