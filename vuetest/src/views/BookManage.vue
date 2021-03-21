<template>
    <div>
        <!-- 里边的prop和label等是和data中的标签对应的 -->
        <el-table
                :data="tableData"
                border
                style="width: 60%">
            <el-table-column
                    fixed
                    prop="id"
                    label="编号"
                    width="150">
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="书名"
                    width="150">
            </el-table-column>
            <el-table-column
                    prop="author"
                    label="作者"
                    width="150">
            </el-table-column>
            <el-table-column
                    fixed="right"
                    label="操作"
                    width="150">
                <template slot-scope="scope">
                    <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
                    <el-button @click="deleteBook(scope.row)" type="text" size="small">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination                background
                layout="prev, pager, next"
                page-size="6"
                :total="total"
                @current-change="page"><!-- 绑定分页事件，page在下边定义-->
            <!-- total的值等于下边定义的那个-->
        </el-pagination>
    </div>
</template>

<script>
    export default {
        methods: {
            deleteBook(row){
                const _this = this
                axios.delete('http://localhost:8181/book/deleteById/'+row.id).then(function (resp) {
                    _this.$alert('《'+row.name+'》删除成功', '', {
                        confirmButtonText: '确定',
                        callback: action => {
                            //因为当前本来就处于BookManage界面，所以不需要跳转，让他动态刷新一下即可
                            window.location.reload()//js语法，不是vue特有
                        }
                    });
                })
            },
            edit(row) {
                this.$router.push({
                    path: '/update',
                    query: {
                        id: row.id
                    }
                })
            },
            page(currentPage){
                const _this = this
                axios.get('http://localhost:8181/book/findAll/'+currentPage+'/6').then(function (resp) {
                    _this.tableData = resp.data.content
                    _this.total = resp.data.totalElements
                })
            }
        },
        created(){//动态获取后台数据显示在页面上，安装axios组件
            //解决this的作用域问题
            const _this = this
            axios.get('http://localhost:8181/book/findAll/1/6').then(function (resp) {
                _this.tableData = resp.data.content
                _this.total = resp.data.totalElements
            })
        },
        data() {
            return {
                total: null,//总记录数
                tableData: null
            }
        }
    }
</script>
