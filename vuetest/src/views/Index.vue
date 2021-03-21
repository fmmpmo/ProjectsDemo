<template>
    <el-container style="height: 500px; border: 1px solid #eee">
        <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
            <el-menu router :default-openeds="['0','1']">
                <!-- item是获取router中的对象，index是其对应的索引 -->
                <el-submenu v-for="(item,index) in $router.options.routes" v-bind:index="index+''">
                    <template slot="title"><i class="el-icon-setting"></i>{{item.name}}</template>
                    <!-- 要跳转的路径由index值决定，动态绑定，实现动态跳转，class样式用来实现当前在哪个页面时，哪个按钮变色，被选中
                     route.path指的是地址栏里的路径，item2.path指的是index中配置的路由-->
                    <el-menu-item v-for="(item2,index2) in item.children" v-bind:index="item2.path"
                                  :class="$route.path==item2.path?'is-active':''">{{item2.name}}</el-menu-item>
                </el-submenu>
            </el-menu>
        </el-aside>

        <el-container>
            <el-header style="text-align: right; font-size: 12px">
                <el-dropdown>
                    <i class="el-icon-setting" style="margin-right: 15px"></i>
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item>查看</el-dropdown-item>
                        <el-dropdown-item>新增</el-dropdown-item>
                        <el-dropdown-item>删除</el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
                <span>王小虎</span>
            </el-header>

            <el-main>
                <router-view></router-view>
            </el-main>
        </el-container>
    </el-container>
</template>

<script>
    export default {
        name: "Index"
    }
</script>

<style scoped>

</style>
