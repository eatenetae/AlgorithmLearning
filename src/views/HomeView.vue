<template>
  <div style="height: 100%">
    <el-container style="height: 100vh">
      <el-aside :width="sideWidth + 'px'" style="background-color: rgb(238, 241, 246);">
        <el-menu :default-openeds="['1', '3']" style = "min-height: 100%; overflow-x:hidden "
                 background-color="rgb(48,65,86)" text-color="#fff" active-text-color = "#ffd04b"
                 :collapse-transition="false"
        >

          <div style="width: 120px;line-height: 60px;text-align: center">
            <!--<img src="src/assets/Logo.png" alt="" style="width: 10px">-->
            <b style="color: aliceblue">
              ALGO
            </b>
          </div>
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-message"></i><span slot="title">导航一</span></template>
            <el-menu-item-group>
              <template slot="title">分组一</template>
              <el-menu-item index="1-1">选项1</el-menu-item>
              <el-menu-item index="1-2">选项2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="分组2">
              <el-menu-item index="1-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="1-4">
              <template slot="title">选项4</template>
              <el-menu-item index="1-4-1">选项4-1</el-menu-item>
            </el-submenu>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title"><i class="el-icon-menu"></i><span slot="title">导航二</span></template>
            <el-menu-item-group>
              <template slot="title">分组一</template>
              <el-menu-item index="2-1">选项1</el-menu-item>
              <el-menu-item index="2-2">选项2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="分组2">
              <el-menu-item index="2-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="2-4">
              <template slot="title">选项4</template>
              <el-menu-item index="2-4-1">选项4-1</el-menu-item>
            </el-submenu>
          </el-submenu>
          <el-submenu index="3">
            <template slot="title"><i class="el-icon-setting"></i><span slot="title">导航三</span></template>
            <el-menu-item-group>
              <template slot="title">分组一</template>
              <el-menu-item index="3-1">选项1</el-menu-item>
              <el-menu-item index="3-2">选项2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="分组2">
              <el-menu-item index="3-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="3-4">
              <template slot="title">选项4</template>
              <el-menu-item index="3-4-1">选项4-1</el-menu-item>
            </el-submenu>
          </el-submenu>
        </el-menu>
      </el-aside>

      <el-container>
        <el-header style=" font-size: 12px; border-bottom: 1px solid#ccc; line-height: 60px; display: flex">
          <div style = "flex : 1;font-size: 18px ">
            <span :class="collapseBtnClass" style="cursor:pointer" @click = "collapse"></span>
          </div>
          <el-dropdown style="text-align:right; width: 200px;cursor: pointer">


            <span>胡嘉辉</span><i class = "el-icon-arrow-down" style ="margin-left: 5px"></i>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>个人信息</el-dropdown-item>
              <el-dropdown-item>退出</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>

        </el-header>

        <el-main>
          <div style="padding: 10px 0">
            <el-input style="width: 250px" placeholder="请输入名称" suffix-icon="el-icon-search " v-model="username"></el-input>
            <el-button style="margin-left: 5px" @click="load">搜索</el-button>
          </div>

          <div style="padding: 10px 0">
            <el-button type="primary">新增<i class="el-icon-circle-plus-outline"></i></el-button>
            <el-button type="primary">批量删除<i class="el-icon-remove-outline"></i></el-button>
            <el-button type="primary">导入</el-button>
            <el-button type="primary">导出</el-button>
          </div>

          <el-table :data="tableData" border stripe:header-cell-class-name="headerBg">
            <el-table-column prop="id" label="ID" width="80">
            </el-table-column>
            <el-table-column prop="username" label="用户名" width="140">
            </el-table-column>
            <el-table-column prop="nickname" label="昵称" width="120">
            </el-table-column>
            <el-table-column prop="email" label="邮箱" width="120">
            </el-table-column>
            <el-table-column prop="phone" label="电话" width="120">
            </el-table-column>
            <el-table-column prop="address" label="地址" >
            </el-table-column>

            <el-table-column label="操作" >
              <template slot-scope="scope">
                <el-button type="success">编辑<i class="el-icon-edit"></i></el-button>
                <el-button type="danger">删除<i class="el-icon-remove-outline"></i></el-button>
              </template>
            </el-table-column>
          </el-table>

          <div style="padding: 10px 0">
            <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="pageNum"
                :page-sizes="[2, 5, 10, 20]"
                :page-size="pageSize"
                layout="total, sizes, prev, pager, next, jumper"
                :total="total">
            </el-pagination>
          </div>

        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
// import request from "@/utils/request";

export default {
  data() {
    return {
      tableData: [],
      total: 0,
      msg:"hello,内大",
      collapseBtnClass:'el-icon-s-fold',
      isCollapsed:false,
      sideWidth: 200,
      pageNum: 1,
      pageSize: 5,
      username: ""
    }
  },

  created() {
    //请求分页查询数据
    this.load()
  },

  methods:{
    collapse(){ //点击收缩按钮
      this.isCollapsed=!this.isCollapsed
      if(this.isCollapsed){
        this.sideWidth = 64
        this.collapseBtnClass = 'el-icon-s-unfold'
      }
      else {
        this.sideWidth = 200
        this.collapseBtnClass = 'el-icon-s-fold'
      }
    },
    load(){
      // request.get("http://localhost:9090/user/page?pageNum="+this.pageNum+"&pageSize="+this.pageSize+"&username="+this.username).then(res =>{
      //   console.log(res)
      //
      //   this.tableData = res.data
      //   this.total = res.total
      // })

      fetch("http://localhost:9090/user/page?pageNum="+this.pageNum+"&pageSize="+this.pageSize+"&username="+this.username).then(res=>res.json()).then(res => {
        console.log(res)
        this.tableData = res.data
        this.total = res.total

      })
    },
    handleSizeChange(pageSize){
      this.pageSize = pageSize
      this.load()
    },
    handleCurrentChange(pageNum){
      this.pageNum = pageNum
      this.load()
    }

  }
};
</script>
