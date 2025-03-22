<template>
    <div class="main-content">
        <el-dialog title="审核" :visible.sync="xueliYesnoTypesVisible">
            <el-form :model="form">
                <input type="hidden" v-model="form.id">
                <el-form-item label="审核" >
                    <el-select v-model="form.xueliYesnoTypes" placeholder="请选择审核类型">
                        <el-option label="通过" value="2"></el-option>
                        <el-option label="拒绝" value="3"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="审核意见">
                    <el-input type="textarea" v-model="form.xueliYesnoText" placeholder="审核意见"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="xueliYesnoTypesVisible = false">取 消</el-button>
                <el-button type="primary" @click="xueliYesnoTypesShenhe">提 交</el-button>
            </div>
        </el-dialog>

        <!--

                _this.renzhengForm.xueliRenzhengbianhaoNumber = "";//认证编号
                _this.renzhengForm.xueliZhengshuNumber = "";//证书编号
                _this.renzhengForm.xueliIdNumber = "";//身份证号
        -->


        <el-dialog title="认证证书模态框" :visible.sync="renzhengVisible">
            <el-form :model="renzhengForm">
                <el-form-item label="认证编号">
                    <el-input v-model="renzhengForm.xueliRenzhengbianhaoNumber" placeholder="认证编号" style="width: 90%"></el-input>
                </el-form-item>
                <el-form-item label="证书编号">
                    <el-input v-model="renzhengForm.xueliZhengshuNumber" placeholder="证书编号" style="width: 90%"></el-input>
                </el-form-item>
                <el-form-item label="身份证号">
                    <el-input v-model="renzhengForm.xueliIdNumber" placeholder="身份证号" style="width: 90%"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="renzhengVisible = false">取 消</el-button>
                <el-button type="primary" @click="renzhengShenhe">认 证</el-button>
            </div>
        </el-dialog>




        <!-- 条件查询 -->
        <div v-if="showFlag">
            <el-form :inline="true" :model="searchForm" class="form-content">
                <el-row :gutter="20" class="slt" :style="{justifyContent:contents.searchBoxPosition=='1'?'flex-start':contents.searchBoxPosition=='2'?'center':'flex-end'}">
                                 
                     <el-form-item :label="contents.inputTitle == 1 ? '学历编号' : ''" v-if="sessionTable != '用户'">
                         <el-input prefix-icon="el-icon-search" v-model="searchForm.xueliUuidNumber" placeholder="学历编号" clearable></el-input>
                     </el-form-item>
                 
                     <el-form-item :label="contents.inputTitle == 1 ? '证书上的姓名' : ''" v-if="sessionTable != '用户'">
                         <el-input prefix-icon="el-icon-search" v-model="searchForm.xueliName" placeholder="姓名" clearable></el-input>
                     </el-form-item>
         
                     <el-form-item :label="contents.inputTitle == 1 ? '证书上的身份证号' : ''" v-if="sessionTable != '用户'">
                         <el-input prefix-icon="el-icon-search" v-model="searchForm.xueliIdNumber" placeholder="身份证号" clearable></el-input>
                     </el-form-item>
         
                     <el-form-item :label="contents.inputTitle == 1 ? '证书上的证书编号' : ''">
                         <el-input prefix-icon="el-icon-search" v-model="searchForm.xueliZhengshuNumber" placeholder="证书编号" clearable></el-input>
                     </el-form-item>
                                                 
                     <el-form-item :label="contents.inputTitle == 1 ? '学历性质' : ''" v-if="sessionTable != '用户'">
                        <el-select v-model="searchForm.xuelixingzhiTypes" placeholder="请选择学历性质">
                            <el-option label="=-请选择-=" value=""></el-option>
                            <el-option
                               v-for="(item,index) in xuelixingzhiTypesSelectSearch"
                               v-bind:key="index"
                               :label="item.indexName"
                               :value="item.codeIndex">
                            <!--lable是要展示的名称-->
                            <!--value是值-->
                            </el-option>
                        </el-select>
                     </el-form-item>

                                                                                 
                     <el-form-item :label="contents.inputTitle == 1 ? '审核状态' : ''" v-if="sessionTable != '用户'">
                        <el-select v-model="searchForm.xueliYesnoTypes" placeholder="请选择审核状态">
                            <el-option label="=-请选择-=" value=""></el-option>
                            <el-option
                               v-for="(item,index) in xueliYesnoTypesSelectSearch"
                               v-bind:key="index"
                               :label="item.indexName"
                               :value="item.codeIndex">
                            <!--lable是要展示的名称-->
                            <!--value是值-->
                            </el-option>
                        </el-select>
                     </el-form-item>

                                
                                         
                    <el-form-item :label="contents.inputTitle == 1 ? '用户姓名' : ''" v-if="sessionTable != '用户'">
                        <el-input prefix-icon="el-icon-search" v-model="searchForm.yonghuName" placeholder="用户姓名" clearable></el-input>
                    </el-form-item>
                                                                                                                                                                 
                    <el-form-item :label="contents.inputTitle == 1 ? '转接地编号' : ''" v-if="sessionTable != '用户'">
                        <el-input prefix-icon="el-icon-search" v-model="searchForm.zhuanjiediUuidNumber" placeholder="转接地编号" clearable></el-input>
                    </el-form-item>
                     
                    <el-form-item :label="contents.inputTitle == 1 ? '转接地名称' : ''" v-if="sessionTable != '用户'">
                        <el-input prefix-icon="el-icon-search" v-model="searchForm.zhuanjiediName" placeholder="转接地名称" clearable></el-input>
                    </el-form-item>
                                         
                    <el-form-item :label="contents.inputTitle == 1 ? '转接地类型' : ''" v-if="sessionTable != '用户'">
                        <el-select v-model="searchForm.zhuanjiediTypes" placeholder="请选择转接地类型">
                            <el-option label="=-请选择-=" value=""></el-option>
                            <el-option
                                    v-for="(item,index) in zhuanjiediTypesSelectSearch"
                                    v-bind:key="index"
                                    :label="item.indexName"
                                    :value="item.codeIndex">
                                <!--lable是要展示的名称-->
                                <!--value是值-->
                            </el-option>
                        </el-select>
                    </el-form-item>
                     
                    <el-form-item :label="contents.inputTitle == 1 ? '二级类型' : ''" v-if="sessionTable != '用户'">
                        <el-select v-model="searchForm.zhuanjiediErjiTypes" placeholder="请选择二级类型">
                            <el-option label="=-请选择-=" value=""></el-option>
                            <el-option
                                    v-for="(item,index) in zhuanjiediErjiTypesSelectSearch"
                                    v-bind:key="index"
                                    :label="item.indexName"
                                    :value="item.codeIndex">
                                <!--lable是要展示的名称-->
                                <!--value是值-->
                            </el-option>
                        </el-select>
                    </el-form-item>
                                                                                

                    <el-form-item>
                        <el-button type="success" @click="search()">查询<i class="el-icon-search el-icon--right"/></el-button>
                    </el-form-item>
                </el-row>
                <el-row class="ad" :style="{justifyContent:contents.btnAdAllBoxPosition=='1'?'flex-start':contents.btnAdAllBoxPosition=='2'?'center':'flex-end'}">
                    <el-form-item>
                        <el-button
                                v-if="isAuth('xueli','新增')"
                                type="success"
                                icon="el-icon-plus"
                                @click="addOrUpdateHandler()"
                        >新增</el-button>
                        &nbsp;
                        <el-button
                                v-if="isAuth('xueli','删除')"
                                :disabled="dataListSelections.length <= 0"
                                type="danger"
                                icon="el-icon-delete"
                                @click="deleteHandler()"
                        >删除</el-button>
                        &nbsp;
                        <el-button
                                v-if="isAuth('xueli','报表')"
                                type="success"
                                icon="el-icon-pie-chart"
                                @click="chartDialog()"
                        >报表</el-button>
                        &nbsp;
                        <a style="text-decoration:none" class="el-button el-button--success"
                           v-if="isAuth('xueli','导入导出')"
                           icon="el-icon-download"
                           href="http://localhost:8080/xuelizhengming/upload/xueliMuBan.xls"
                        >批量导入学历数据模板</a>
                        &nbsp;
                        <el-upload
                                v-if="isAuth('xueli','导入导出')"
                                style="display: inline-block"
                                action="xuelizhengming/file/upload"
                                :on-success="xueliUploadSuccess"
                                :on-error="xueliUploadError"
                                :show-file-list = false>
                            <el-button
                                    v-if="isAuth('xueli','导入导出')"
                                    type="success"
                                    icon="el-icon-upload2"
                            >批量导入学历数据</el-button>
                        </el-upload>
                        &nbsp;
                        <!-- 导出excel -->
                        <download-excel v-if="isAuth('xueli','导入导出')" style="display: inline-block" class = "export-excel-wrapper" :data = "dataList" :fields = "json_fields" name = "xueli.xls">
                            <!-- 导出excel -->
                            <el-button
                                    type="success"
                                    icon="el-icon-download"
                            >导出</el-button>
                        </download-excel>
                        &nbsp;
                    </el-form-item>
                </el-row>
            </el-form>
            <div class="table-content">
                <el-table class="tables" :size="contents.tableSize" :show-header="contents.tableShowHeader"
                          :header-row-style="headerRowStyle" :header-cell-style="headerCellStyle"
                          :border="contents.tableBorder"
                          :fit="contents.tableFit"
                          :stripe="contents.tableStripe"
                          :row-style="rowStyle"
                          :cell-style="cellStyle"
                          :style="{width: '100%',fontSize:contents.tableContentFontSize,color:contents.tableContentFontColor}"
                          v-if="isAuth('xueli','查看')"
                          :data="dataList"
                          v-loading="dataListLoading"
                          @selection-change="selectionChangeHandler">
                    <el-table-column  v-if="contents.tableSelection"
                                      type="selection"
                                      header-align="center"
                                      align="center"
                                      width="50">
                    </el-table-column>
                    <el-table-column label="索引" v-if="contents.tableIndex" type="index" width="50" />
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="yonghuName"
                                      header-align="center"
                                      label="用户姓名">
                        <template slot-scope="scope">
                            {{scope.row.yonghuName}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="yonghuPhone"
                                      header-align="center"
                                      label="用户手机号">
                        <template slot-scope="scope">
                            {{scope.row.yonghuPhone}}
                        </template>
                    </el-table-column>
                    <el-table-column :sortable="contents.tableSortable" :align="contents.tableAlign" prop="yonghuPhoto"
                               header-align="center"
                               width="200"
                               label="用户头像">
                        <template slot-scope="scope">
                            <div v-if="scope.row.yonghuPhoto">
                                <img :src="scope.row.yonghuPhoto" width="100" height="100">
                            </div>
                            <div v-else>无图片</div>
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="zhuanjiediUuidNumber"
                                      header-align="center"
                                      label="转接地编号">
                        <template slot-scope="scope">
                            {{scope.row.zhuanjiediUuidNumber}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="zhuanjiediName"
                                      header-align="center"
                                      label="转接地名称">
                        <template slot-scope="scope">
                            {{scope.row.zhuanjiediName}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="zhuanjiediTypes"
                                      header-align="center"
                                      label="转接地类型">
                        <template slot-scope="scope">
                            {{scope.row.zhuanjiediValue}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="zhuanjiediErjiTypes"
                                      header-align="center"
                                      label="二级类型">
                        <template slot-scope="scope">
                            {{scope.row.zhuanjiediErjiValue}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="xueliUuidNumber"
                                   header-align="center"
                                   label="学历编号">
                        <template slot-scope="scope">
                            {{scope.row.xueliUuidNumber}}
                        </template>
                    </el-table-column>
                    <el-table-column :sortable="contents.tableSortable" :align="contents.tableAlign" prop="zhengjianPhoto"
                                     header-align="center"
                                     width="200"
                                     label="证件照">
                        <template slot-scope="scope">
                            <div v-if="scope.row.zhengjianPhoto">
                                <img :src="scope.row.zhengjianPhoto" width="100" height="100">
                            </div>
                            <div v-else>无图片</div>
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="xueliName"
                                   header-align="center"
                                   label="姓名">
                        <template slot-scope="scope">
                            {{scope.row.xueliName}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="xueliIdNumber"
                                   header-align="center"
                                   label="身份证号">
                        <template slot-scope="scope">
                            {{scope.row.xueliIdNumber}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="xueliZhengshuNumber"
                                   header-align="center"
                                   label="证书编号">
                        <template slot-scope="scope">
                            {{scope.row.xueliZhengshuNumber}}
                        </template>
                    </el-table-column>

                    <el-table-column v-if="sessionTable != 'yonghu'"  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="xueliRenzhengbianhaoNumber"
                                   header-align="center"
                                   label="认证编号">
                        <template slot-scope="scope">
                            {{scope.row.xueliRenzhengbianhaoNumber}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="xuelixingbieTypes"
                                      header-align="center"
                                      label="性别">
                        <template slot-scope="scope">
                            {{scope.row.xuelixingbieValue}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="xueliChushengnianyue"
                                   header-align="center"
                                   label="出生年月">
                        <template slot-scope="scope">
                            {{scope.row.xueliChushengnianyue}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="xueliGuoji"
                                   header-align="center"
                                   label="国籍">
                        <template slot-scope="scope">
                            {{scope.row.xueliGuoji}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="xueliMinzu"
                                   header-align="center"
                                   label="民族">
                        <template slot-scope="scope">
                            {{scope.row.xueliMinzu}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="xuelixingzhiTypes"
                                      header-align="center"
                                      label="学历性质">
                        <template slot-scope="scope">
                            {{scope.row.xuelixingzhiValue}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="xueliXuezhiTypes"
                                      header-align="center"
                                      label="学制">
                        <template slot-scope="scope">
                            {{scope.row.xueliXuezhiValue}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="xueliXuexixingshiTypes"
                                      header-align="center"
                                      label="学习形式">
                        <template slot-scope="scope">
                            {{scope.row.xueliXuexixingshiValue}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="xueliBiyeyuanxiao"
                                   header-align="center"
                                   label="毕业院校">
                        <template slot-scope="scope">
                            {{scope.row.xueliBiyeyuanxiao}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="xueliZhuanyeTypes"
                                      header-align="center"
                                      label="专业">
                        <template slot-scope="scope">
                            {{scope.row.xueliZhuanyeValue}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="xueliBanjiTypes"
                                      header-align="center"
                                      label="班级">
                        <template slot-scope="scope">
                            {{scope.row.xueliBanjiValue}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="xueliRuxiaonianyue"
                                   header-align="center"
                                   label="入校年月">
                        <template slot-scope="scope">
                            {{scope.row.xueliRuxiaonianyue}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="xueliBiyenianyue"
                                   header-align="center"
                                   label="毕业年月">
                        <template slot-scope="scope">
                            {{scope.row.xueliBiyenianyue}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="xueliChengfenTypes"
                                      header-align="center"
                                      label="成分">
                        <template slot-scope="scope">
                            {{scope.row.xueliChengfenValue}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="xueliLianxifangshiPhone"
                                   header-align="center"
                                   label="联系方式">
                        <template slot-scope="scope">
                            {{scope.row.xueliLianxifangshiPhone}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="xueliYesnoTypes"
                                      header-align="center"
                                      label="审核状态">
                        <template slot-scope="scope">
                            {{scope.row.xueliYesnoValue}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="xueliYesnoText"
                                      header-align="center"
                                      label="审核意见">
                        <template slot-scope="scope">
                            <span v-if="scope.row.xueliYesnoText != null &&scope.row.xueliYesnoText.length>10">
                                {{scope.row.xueliYesnoText.slice(0,10)}}...
                            </span>
                            <span v-else>
                                {{scope.row.xueliYesnoText}}
                            </span>
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="insertTime"
                                   header-align="center"
                                   label="录入时间">
                        <template slot-scope="scope">
                            {{scope.row.insertTime}}
                        </template>
                    </el-table-column>

                    <el-table-column width="300" :align="contents.tableAlign"
                                     header-align="center"
                                     label="操作">
                        <template slot-scope="scope">
                            <el-button v-if="isAuth('xueli','查看')" type="success" icon="el-icon-tickets" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">详情</el-button>
                            <el-button v-if="isAuth('xueli','修改')" type="primary" icon="el-icon-edit" size="mini" @click="addOrUpdateHandler(scope.row.id)">修改</el-button>
                            <el-button v-if="sessionTable == 'yonghu' && scope.row.yonghuId == null" type="primary" icon="el-icon-edit" size="mini" @click="openRenzheng(scope.row.id)">认证</el-button>
                            <el-button v-if="sessionTable == 'yonghu' && scope.row.yonghuId ==userId && scope.row.xueliYesnoTypes !=2" type="primary" icon="el-icon-edit" size="mini" @click="addOrUpdateHandler(scope.row.id,'qianyue')">签约转接地</el-button>

                            <el-button v-if="isAuth('xueli','删除')" type="danger" icon="el-icon-delete" size="mini" @click="deleteHandler(scope.row.id)">删除</el-button>
                            <el-button v-if="isAuth('xueli','审核') && scope.row.xueliYesnoTypes == 1 " type="primary" icon="el-icon-thumb" size="mini" @click="openYesnoTypes(scope.row.id)">审核</el-button>

                        </template>
                    </el-table-column>
                </el-table>
                <el-pagination
                        clsss="pages"
                        :layout="layouts"
                        @size-change="sizeChangeHandle"
                        @current-change="currentChangeHandle"
                        :current-page="pageIndex"
                        :page-sizes="[10, 20, 50, 100]"
                        :page-size="Number(contents.pageEachNum)"
                        :total="totalPage"
                        :small="contents.pageStyle"
                        class="pagination-content"
                        :background="contents.pageBtnBG"
                        :style="{textAlign:contents.pagePosition==1?'left':contents.pagePosition==2?'center':'right'}"
                ></el-pagination>
            </div>
        </div>
        <!-- 添加/修改页面  将父组件的search方法传递给子组件-->
        <add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>



        <el-dialog title="统计报表" :visible.sync="chartVisiable" width="800">
            <el-date-picker
                    v-model="echartsDate"
                    type="year"
                    placeholder="选择年">
            </el-date-picker>
            <el-button @click="chartDialog()">查询</el-button>
            <div id="statistic" style="width:100%;height:600px;"></div>
            <span slot="footer" class="dialog-footer">
				<el-button @click="chartVisiable = false">关闭</el-button>
			</span>
        </el-dialog>

    </div>
</template>
<script>
    import AddOrUpdate from "./add-or-update";
    import styleJs from "../../../utils/style.js";
    import utilsJs from "../../../utils/utils.js";

    export default {
        data() {
        return {
            searchForm: {
                key: ""
            },
            sessionTable : "",//登录账户所在表名
            role : "",//权限
            userId:"",//当前登录人的id
    //级联表下拉框搜索条件
              zhuanjiediTypesSelectSearch : [],
              zhuanjiediErjiTypesSelectSearch : [],
    //当前表下拉框搜索条件
              xuelixingzhiTypesSelectSearch : [],
              xueliYesnoTypesSelectSearch : [],
            form:{
                id : null,
                yonghuId : null,
                zhuanjiediId : null,
                xueliUuidNumber : null,
                zhengjianPhoto : null,
                xueliName : null,
                xueliIdNumber : null,
                xueliZhengshuNumber : null,
                xueliRenzhengbianhaoNumber : null,
                xuelixingbieTypes : null,
                xueliChushengnianyue : null,
                xueliGuoji : null,
                xueliMinzu : null,
                xuelixingzhiTypes : null,
                xueliXuezhiTypes : null,
                xueliXuexixingshiTypes : null,
                xueliBiyeyuanxiao : null,
                xueliZhuanyeTypes : null,
                xueliBanjiTypes : null,
                xueliRuxiaonianyue : null,
                xueliBiyenianyue : null,
                xueliChengfenTypes : null,
                xueliLianxifangshiPhone : null,
                xueliYesnoTypes : null,
                xueliYesnoText : null,
                xueliDelete : null,
                insertTime : null,
                createTime : null,
            },
            renzhengForm:{
                id : null,
                yonghuId : null,
                zhuanjiediId : null,
                xueliUuidNumber : null,
                zhengjianPhoto : null,
                xueliName : null,
                xueliIdNumber : null,
                xueliZhengshuNumber : null,
                xueliRenzhengbianhaoNumber : null,
                xuelixingbieTypes : null,
                xueliChushengnianyue : null,
                xueliGuoji : null,
                xueliMinzu : null,
                xuelixingzhiTypes : null,
                xueliXuezhiTypes : null,
                xueliXuexixingshiTypes : null,
                xueliBiyeyuanxiao : null,
                xueliZhuanyeTypes : null,
                xueliBanjiTypes : null,
                xueliRuxiaonianyue : null,
                xueliBiyenianyue : null,
                xueliChengfenTypes : null,
                xueliLianxifangshiPhone : null,
                xueliYesnoTypes : null,
                xueliYesnoText : null,
                xueliDelete : null,
                insertTime : null,
                createTime : null,
            },
            dataList: [],
            pageIndex: 1,
            pageSize: 10,
            totalPage: 0,
            dataListLoading: false,
            dataListSelections: [],
            showFlag: true,
            sfshVisiable: false,
            shForm: {},
            chartVisiable: false,
            echartsDate: new Date(),//echarts的时间查询字段
            addOrUpdateFlag:false,
            contents:null,
            layouts: '',

            xueliYesnoTypesVisible : false,
            renzhengVisible : false,

            //导出excel
            json_fields: {
                //级联表字段
                     '用户姓名': 'yonghuName',
                     '用户手机号': 'yonghuPhone',
                     '用户身份证号': 'yonghuIdNumber',
                     '用户头像': 'yonghuPhoto',
                     '电子邮箱': 'yonghuEmail',
                     '转接地编号': 'zhuanjiediUuidNumber',
                     '转接地名称': 'zhuanjiediName',
                     '转接地地址': 'zhuanjiediAddress',
                     '转接地类型': 'zhuanjiediTypes',
                     '二级类型': 'zhuanjiediErjiTypes',
                //本表字段
                     '学历编号': "xueliUuidNumber",
                     '证件照': "zhengjianPhoto",
                     '姓名': "xueliName",
                     '身份证号': "xueliIdNumber",
                     '证书编号': "xueliZhengshuNumber",
                     '认证编号': "xueliRenzhengbianhaoNumber",
                     '性别': "xuelixingbieTypes",
                     '出生年月': "xueliChushengnianyue",
                     '国籍': "xueliGuoji",
                     '民族': "xueliMinzu",
                     '学历性质': "xuelixingzhiTypes",
                     '学制': "xueliXuezhiTypes",
                     '学习形式': "xueliXuexixingshiTypes",
                     '毕业院校': "xueliBiyeyuanxiao",
                     '专业': "xueliZhuanyeTypes",
                     '班级': "xueliBanjiTypes",
                     '入校年月': "xueliRuxiaonianyue",
                     '毕业年月': "xueliBiyenianyue",
                     '成分': "xueliChengfenTypes",
                     '联系方式': "xueliLianxifangshiPhone",
                     '审核状态': "xueliYesnoTypes",
                     '审核意见': "xueliYesnoText",
                     '录入时间': "insertTime",
            },

            };
        },
        created() {

            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");

            this.contents = styleJs.listStyle();
            this.init();
            if(this.sessionTable == 'users'){
                this.getDataList();
            }
            this.contentStyleChange()
        },
        mounted() {

            //查询级联表搜索条件所有列表
            this.$http({
                url: "dictionary/page?dicCode=zhuanjiedi_types&page=1&limit=100",
                method: "get",
                page: 1,
                limit: 100,
            }).then(({data}) => {
                if(data && data.code === 0){
                    this.zhuanjiediTypesSelectSearch = data.data.list;
                }
            });
            this.$http({
                url: "dictionary/page?dicCode=zhuanjiedi_erji_types&page=1&limit=100",
                method: "get",
                page: 1,
                limit: 100,
            }).then(({data}) => {
                if(data && data.code === 0){
                    this.zhuanjiediErjiTypesSelectSearch = data.data.list;
                }
            });
            //查询当前表搜索条件所有列表
            //填充下拉框选项
            this.$http({
                url: "dictionary/page?dicCode=xuelixingzhi_types&page=1&limit=100",
                method: "get",
            }).then(({data}) => {
                if(data && data.code === 0){
                    this.xuelixingzhiTypesSelectSearch = data.data.list;
                }
            });
            //填充下拉框选项
            this.$http({
                url: "dictionary/page?dicCode=xueli_yesno_types&page=1&limit=100",
                method: "get",
            }).then(({data}) => {
                if(data && data.code === 0){
                    this.xueliYesnoTypesSelectSearch = data.data.list;
                }
            });

        },
        filters: {
            htmlfilter: function (val) {
                return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
            }
        },
        components: {
            AddOrUpdate,
        },
        computed: {
        },
        methods: {
            chartDialog() {
                let _this = this;
                let params = {
                    dateFormat :"%Y", //%Y-%m
                    riqi :_this.echartsDate.getFullYear(),
                    // riqi :_this.echartsDate.getFullYear()+"-"+(_this.echartsDate.getMonth() + 1 < 10 ? '0' + (_this.echartsDate.getMonth() + 1) : _this.echartsDate.getMonth() + 1),
                    thisTable : {//当前表
                        tableName :'xueli',//当前表表名,
                        sumColum : 'xueli_number', //求和字段
                        date : 'insert_time',//分组日期字段
                        // string : 'xueli_name',//分组字符串字段
                        // types : 'xueli_types',//分组下拉框字段
                    },
                    // joinTable : {//级联表（可以不存在）
                    //     tableName :'yonghu',//级联表表名
                    //     // date : 'insert_time',//分组日期字段
                    //     string : 'yonghu_name',//分组字符串字段
                    //     // types : 'yonghu_types',//分组下拉框字段
                    // }
                }
                _this.chartVisiable = true;
                _this.$nextTick(() => {
                    var statistic = this.$echarts.init(document.getElementById("statistic"), 'macarons');
                    this.$http({
                        url: "barSum",
                        method: "get",
                        params: params
                    }).then(({data}) => {
                        if(data && data.code === 0){

                            //柱状图 求和 已成功使用
                            //start
                            let yAxisName = "数值";//根据查询数据具体改(单列要改,多列不改)
                            let xAxisName = "月份";
                            let series = [];//具体数据值
                            data.data.yAxis.forEach(function (item,index) {
                                let tempMap = {};
                                // tempMap.name= ["数值"];//根据查询数据具体改(单列要改,多列不改)
                                tempMap.name=data.data.legend[index];
                                tempMap.type='bar';
                                tempMap.data=item;
                                series.push(tempMap);

                            })

                            var option = {
                                tooltip: {
                                    trigger: 'axis',
                                    axisPointer: {
                                        type: 'cross',
                                        crossStyle: {
                                            color: '#999'
                                        }
                                    }
                                },
                                toolbox: {
                                    feature: {
                                        // dataView: { show: true, readOnly: false },  // 数据查看
                                        magicType: { show: true, type: ['line', 'bar'] },//切换图形展示方式
                                        // restore: { show: true }, // 刷新
                                        saveAsImage: { show: true }//保存
                                    }
                                },
                                legend: {
                                    data: data.data.legend//标题  可以点击导致某一列数据消失
                                },
                                xAxis: [
                                    {
                                        type: 'category',
                                        name: xAxisName,
                                        data: data.data.xAxis,
                                        axisPointer: {
                                            type: 'shadow'
                                        }
                                    }
                                ],
                                yAxis: [
                                    {
                                        type: 'value',//不能改
                                        name: yAxisName,//y轴单位
                                        axisLabel: {
                                            formatter: '{value}' // 后缀
                                        }
                                    }
                                ],
                                series:series//具体数据
                            };
                            // 使用刚指定的配置项和数据显示图表。
                            statistic.setOption(option,true);
                            //根据窗口的大小变动图表
                            window.onresize = function () {
                                statistic.resize();
                            };
                            //end
                        }else {
                            this.$message({
                                message: "报表未查询到数据",
                                type: "success",
                                duration: 1500,
                                onClose: () => {
                                    this.search();
                                }
                            });
                        }
                    });
                });
                ////饼状图
                //_this.chartVisiable = true;
                // this.$nextTick(()=>{
                //     var statistic = this.$echarts.init(document.getElementById("statistic"),'macarons');
                //     let params = {
                //         tableName: "xueli",
                //         groupColumn: "xueli_types",
                //     }
                //     this.$http({
                //         url: "newSelectGroupCount",
                //         method: "get",
                //         params: params
                //     }).then(({data}) => {
                //         if (data && data.code === 0) {
                //             let res = data.data;
                //             let xAxis = [];
                //             let yAxis = [];
                //             let pArray = []
                //             var option = {};
                //             for(let i=0;i<res.length;i++){
                //                 xAxis.push(res[i].name);
                //                 yAxis.push(res[i].value);
                //                 pArray.push({
                //                     value: res[i].value,
                //                     name: res[i].name
                //                 })
                //                 option = {
                //                     title: {
                //                         text: '保险合同类型统计',
                //                         left: 'center'
                //                     },
                //                     tooltip: {
                //                         trigger: 'item',
                //                         formatter: '{b} : {c} ({d}%)'
                //                     },
                //                     series: [
                //                         {
                //                             type: 'pie',
                //                             radius: '55%',
                //                             center: ['50%', '60%'],
                //                             data: pArray,
                //                             emphasis: {
                //                                 itemStyle: {
                //                                     shadowBlur: 10,
                //                                     shadowOffsetX: 0,
                //                                     shadowColor: 'rgba(0, 0, 0, 0.5)'
                //                                 }
                //                             }
                //                         }
                //                     ]
                //                 };
                //             }
                //                 statistic.setOption(option);
                //                 window.onresize = function() {
                //                     statistic.resize();
                //                 };
                //         }
                //     });
                // })
            },
            contentStyleChange() {
                this.contentSearchStyleChange()
                this.contentBtnAdAllStyleChange()
                this.contentSearchBtnStyleChange()
                this.contentTableBtnStyleChange()
                this.contentPageStyleChange()
            },
            contentSearchStyleChange() {
                this.$nextTick(() => {
                    document.querySelectorAll('.form-content .slt .el-input__inner').forEach(el => {
                        let textAlign = 'left'
                        if(this.contents.inputFontPosition == 2)
                            textAlign = 'center'
                            if (this.contents.inputFontPosition == 3) textAlign = 'right'
                                el.style.textAlign = textAlign
                            el.style.height = this.contents.inputHeight
                            el.style.lineHeight = this.contents.inputHeight
                            el.style.color = this.contents.inputFontColor
                            el.style.fontSize = this.contents.inputFontSize
                            el.style.borderWidth = this.contents.inputBorderWidth
                            el.style.borderStyle = this.contents.inputBorderStyle
                            el.style.borderColor = this.contents.inputBorderColor
                            el.style.borderRadius = this.contents.inputBorderRadius
                            el.style.backgroundColor = this.contents.inputBgColor
                    })
                    if (this.contents.inputTitle) {
                        document.querySelectorAll('.form-content .slt .el-form-item__label').forEach(el => {
                            el.style.color = this.contents.inputTitleColor
                            el.style.fontSize = this.contents.inputTitleSize
                            el.style.lineHeight = this.contents.inputHeight
                        })
                    }
                    setTimeout(() => {
                        document.querySelectorAll('.form-content .slt .el-input__prefix').forEach(el => {
                            el.style.color = this.contents.inputIconColor
                            el.style.lineHeight = this.contents.inputHeight
                        })
                        document.querySelectorAll('.form-content .slt .el-input__suffix').forEach(el => {
                            el.style.color = this.contents.inputIconColor
                            el.style.lineHeight = this.contents.inputHeight
                        })
                        document.querySelectorAll('.form-content .slt .el-input__icon').forEach(el => {
                            el.style.lineHeight = this.contents.inputHeight
                        })
                    }, 10 )
                })
            },
            // 搜索按钮
            contentSearchBtnStyleChange() {
                this.$nextTick(() => {
                    document.querySelectorAll('.form-content .slt .el-button--success').forEach(el => {
                        el.style.height = this.contents.searchBtnHeight
                        el.style.color = this.contents.searchBtnFontColor
                        el.style.fontSize = this.contents.searchBtnFontSize
                        el.style.borderWidth = this.contents.searchBtnBorderWidth
                        el.style.borderStyle = this.contents.searchBtnBorderStyle
                        el.style.borderColor = this.contents.searchBtnBorderColor
                        el.style.borderRadius = this.contents.searchBtnBorderRadius
                        el.style.backgroundColor = this.contents.searchBtnBgColor
                    })
                })
            },
            // 新增、批量删除
            contentBtnAdAllStyleChange() {
                this.$nextTick(() => {
                    document.querySelectorAll('.form-content .ad .el-button--success').forEach(el => {
                        el.style.height = this.contents.btnAdAllHeight
                        el.style.color = this.contents.btnAdAllAddFontColor
                        el.style.fontSize = this.contents.btnAdAllFontSize
                        el.style.borderWidth = this.contents.btnAdAllBorderWidth
                        el.style.borderStyle = this.contents.btnAdAllBorderStyle
                        el.style.borderColor = this.contents.btnAdAllBorderColor
                        el.style.borderRadius = this.contents.btnAdAllBorderRadius
                        el.style.backgroundColor = this.contents.btnAdAllAddBgColor
                    })
                    document.querySelectorAll('.form-content .ad .el-button--danger').forEach(el => {
                        el.style.height = this.contents.btnAdAllHeight
                        el.style.color = this.contents.btnAdAllDelFontColor
                        el.style.fontSize = this.contents.btnAdAllFontSize
                        el.style.borderWidth = this.contents.btnAdAllBorderWidth
                        el.style.borderStyle = this.contents.btnAdAllBorderStyle
                        el.style.borderColor = this.contents.btnAdAllBorderColor
                        el.style.borderRadius = this.contents.btnAdAllBorderRadius
                        el.style.backgroundColor = this.contents.btnAdAllDelBgColor
                    })
                    document.querySelectorAll('.form-content .ad .el-button--warning').forEach(el => {
                        el.style.height = this.contents.btnAdAllHeight
                        el.style.color = this.contents.btnAdAllWarnFontColor
                        el.style.fontSize = this.contents.btnAdAllFontSize
                        el.style.borderWidth = this.contents.btnAdAllBorderWidth
                        el.style.borderStyle = this.contents.btnAdAllBorderStyle
                        el.style.borderColor = this.contents.btnAdAllBorderColor
                        el.style.borderRadius = this.contents.btnAdAllBorderRadius
                        el.style.backgroundColor = this.contents.btnAdAllWarnBgColor
                    })
                })
            },
            // 表格
            rowStyle({row, rowIndex}) {
                if (rowIndex % 2 == 1) {
                    if (this.contents.tableStripe) {
                        return {color: this.contents.tableStripeFontColor}
                    }
                } else {
                    return ''
                }
            },
            cellStyle({row, rowIndex}) {
                if (rowIndex % 2 == 1) {
                    if (this.contents.tableStripe) {
                        return {backgroundColor: this.contents.tableStripeBgColor}
                    }
                } else {
                    return ''
                }
            },
            headerRowStyle({row, rowIndex}) {
                return {color: this.contents.tableHeaderFontColor}
            },
            headerCellStyle({row, rowIndex}) {
                return {backgroundColor: this.contents.tableHeaderBgColor}
            },
            // 表格按钮
            contentTableBtnStyleChange() {
                // this.$nextTick(()=>{
                //   setTimeout(()=>{
                //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--success').forEach(el=>{
                //       el.style.height = this.contents.tableBtnHeight
                //       el.style.color = this.contents.tableBtnDetailFontColor
                //       el.style.fontSize = this.contents.tableBtnFontSize
                //       el.style.borderWidth = this.contents.tableBtnBorderWidth
                //       el.style.borderStyle = this.contents.tableBtnBorderStyle
                //       el.style.borderColor = this.contents.tableBtnBorderColor
                //       el.style.borderRadius = this.contents.tableBtnBorderRadius
                //       el.style.backgroundColor = this.contents.tableBtnDetailBgColor
                //     })
                //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--primary').forEach(el=>{
                //       el.style.height = this.contents.tableBtnHeight
                //       el.style.color = this.contents.tableBtnEditFontColor
                //       el.style.fontSize = this.contents.tableBtnFontSize
                //       el.style.borderWidth = this.contents.tableBtnBorderWidth
                //       el.style.borderStyle = this.contents.tableBtnBorderStyle
                //       el.style.borderColor = this.contents.tableBtnBorderColor
                //       el.style.borderRadius = this.contents.tableBtnBorderRadius
                //       el.style.backgroundColor = this.contents.tableBtnEditBgColor
                //     })
                //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--danger').forEach(el=>{
                //       el.style.height = this.contents.tableBtnHeight
                //       el.style.color = this.contents.tableBtnDelFontColor
                //       el.style.fontSize = this.contents.tableBtnFontSize
                //       el.style.borderWidth = this.contents.tableBtnBorderWidth
                //       el.style.borderStyle = this.contents.tableBtnBorderStyle
                //       el.style.borderColor = this.contents.tableBtnBorderColor
                //       el.style.borderRadius = this.contents.tableBtnBorderRadius
                //       el.style.backgroundColor = this.contents.tableBtnDelBgColor
                //     })

                //   }, 50)
                // })
            },
            // 分页
            contentPageStyleChange() {
                let arr = []
                if (this.contents.pageTotal) arr.push('total')
                if (this.contents.pageSizes) arr.push('sizes')
                if (this.contents.pagePrevNext) {
                    arr.push('prev')
                    if (this.contents.pagePager) arr.push('pager')
                    arr.push('next')
                }
                if (this.contents.pageJumper) arr.push('jumper')
                this.layouts = arr.join()
                this.contents.pageEachNum = 10
            },

            init() {
            },
            search() {
                this.pageIndex = 1;
                this.getDataList();
            },
            // 获取数据列表
            getDataList() {
                this.dataListLoading = true;
                let params = {
                    page: this.pageIndex,
                    limit: this.pageSize,
                    sort: 'id',
                }

                                         
                if (this.searchForm.yonghuName!= '' && this.searchForm.yonghuName!= undefined) {
                    params['yonghuName'] =  this.searchForm.yonghuName
                }
                                                                                                                                                                 
                if (this.searchForm.zhuanjiediUuidNumber!= '' && this.searchForm.zhuanjiediUuidNumber!= undefined) {
                    params['zhuanjiediUuidNumber'] =  this.searchForm.zhuanjiediUuidNumber
                }
                     
                if (this.searchForm.zhuanjiediName!= '' && this.searchForm.zhuanjiediName!= undefined) {
                    params['zhuanjiediName'] =  this.searchForm.zhuanjiediName
                }
                                         
                if (this.searchForm.zhuanjiediTypes!= '' && this.searchForm.zhuanjiediTypes!= undefined) {
                    params['zhuanjiediTypes'] = this.searchForm.zhuanjiediTypes
                }
                     
                if (this.searchForm.zhuanjiediErjiTypes!= '' && this.searchForm.zhuanjiediErjiTypes!= undefined) {
                    params['zhuanjiediErjiTypes'] = this.searchForm.zhuanjiediErjiTypes
                }
                                                                                                                 
                if (this.searchForm.xueliUuidNumber!= '' && this.searchForm.xueliUuidNumber!= undefined) {
                    params['xueliUuidNumber'] =  this.searchForm.xueliUuidNumber
                }
                 
                if (this.searchForm.xueliName!= '' && this.searchForm.xueliName!= undefined) {
                    params['xueliName'] =  this.searchForm.xueliName
                }
         
                if (this.searchForm.xueliIdNumber!= '' && this.searchForm.xueliIdNumber!= undefined) {
                    params['xueliIdNumber'] =  this.searchForm.xueliIdNumber
                }
         
                if (this.searchForm.xueliZhengshuNumber!= '' && this.searchForm.xueliZhengshuNumber!= undefined) {
                    params['xueliZhengshuNumber'] =  this.searchForm.xueliZhengshuNumber
                }
                                                 
                if (this.searchForm.xuelixingzhiTypes!= '' && this.searchForm.xuelixingzhiTypes!= undefined) {
                    params['xuelixingzhiTypes'] = this.searchForm.xuelixingzhiTypes
                }
                                                                                 
                if (this.searchForm.xueliYesnoTypes!= '' && this.searchForm.xueliYesnoTypes!= undefined) {
                    params['xueliYesnoTypes'] = this.searchForm.xueliYesnoTypes
                }
                                
                params['xueliDelete'] = 1// 逻辑删除字段 1 未删除 2 删除


                this.$http({
                    url: "xueli/page",
                    method: "get",
                    params: params
                }).then(({data}) => {
                    if(data && data.code === 0){
                        this.dataList = data.data.list;
                        this.totalPage = data.data.total;
                    }else{
                        this.dataList = [];
                        this.totalPage = 0;
                    }
                    this.dataListLoading = false;
                });
            },
            //每页数
            sizeChangeHandle(val) {
                this.pageSize = val;
                this.pageIndex = 1;
                this.getDataList();
            },
            // 当前页
            currentChangeHandle(val) {
                this.pageIndex = val;
                this.getDataList();
            },
            // 多选
            selectionChangeHandler(val) {
                this.dataListSelections = val;
            },
            // 添加/修改
            addOrUpdateHandler(id, type) {
                this.showFlag = false;
                this.addOrUpdateFlag = true;
                this.crossAddOrUpdateFlag = false;
                if (type != 'info' && type!='qianyue') {
                    type = 'else';
                }
                this.$nextTick(() => {
                    this.$refs.addOrUpdate.init(id, type);
                });
            },
            // 下载
            download(file) {
                window.open(" ${file} ")
            },
            // 删除
            deleteHandler(id) {
                var ids = id ? [Number(id)] : this.dataListSelections.map(item => {
                    return Number(item.id);
                });

                this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
                    confirmButtonText: "确定",
                    cancelButtonText: "取消",
                    type: "warning"
                }).then(() => {
                    this.$http({
                        url: "xueli/delete",
                        method: "post",
                        data: ids
                    }).then(({data}) => {
                        if(data && data.code === 0){
                            this.$message({
                                message: "操作成功",
                                type: "success",
                                duration: 1500,
                                onClose: () => {
                                    this.search();
                                }
                            });
                        }else{
                            this.$message.error(data.msg);
                        }
                    });
                });
            },
            // 导入功能上传文件成功后调用导入方法
            xueliUploadSuccess(data){
                let _this = this;
                _this.$http({
                    url: "xueli/batchInsert?fileName=" + data.file,
                    method: "get"
                }).then(({data}) => {
                    if(data && data.code === 0){
                        _this.$message({
                            message: "导入学历数据成功",
                            type: "success",
                            duration: 1500,
                            onClose: () => {
                                _this.search();
                            }
                        });
                    }else{
                        _this.$message.error(data.msg);
                    }
                });

            },
            // 导入功能上传文件失败后调用导入方法
            xueliUploadError(data){
                this.$message.error('上传失败');
            },
            openRenzheng(id) {
                let _this = this;
                _this.renzhengForm.id = null;
                _this.renzhengForm.id = id;
                _this.renzhengForm.xueliRenzhengbianhaoNumber = "";//认证编号
                _this.renzhengForm.xueliZhengshuNumber = "";//证书编号
                _this.renzhengForm.xueliIdNumber = "";//身份证号
                _this.renzhengVisible = true;
            },

            renzhengShenhe() {
                let _this = this;
                if(_this.renzhengForm.xueliRenzhengbianhaoNumber == "" || _this.renzhengForm.xueliRenzhengbianhaoNumber == null ){
                    _this.$message.error("请输入认证编号");
                    return false;
                }
                if(_this.renzhengForm.xueliZhengshuNumber == "" || _this.renzhengForm.xueliZhengshuNumber == null ){
                    _this.$message.error("请输入证书编号");
                    return false;
                }
                if(_this.renzhengForm.xueliIdNumber == "" || _this.renzhengForm.xueliIdNumber == null ){
                    _this.$message.error("请输入身份证号");
                    return false;
                }
                this.$http({
                    url:`xueli/xuelirenzheng`,
                    method: "post",
                    data: _this.renzhengForm
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.$message({
                            message: "认证成功",
                            type: "success",
                            duration: 1500,
                            onClose: () => {
                                _this.renzhengVisible = false;
                                _this.search();
                            }
                        });
                    } else {
                        this.$message.error(data.msg);
                        _this.renzhengVisible = false;
                    }
                });
            },





            openYesnoTypes(id) {
                let _this = this;
                _this.form.id = null;
                _this.form.id = id;
                            _this.form.xueliYesnoText = null;
                _this.form.xueliYesnoTypes = "请选择审核结果";
                _this.xueliYesnoTypesVisible = true;
            },

            xueliYesnoTypesShenhe() {
                let _this = this;
                if(_this.form.xueliYesnoTypes == "请选择审核结果"){
                    alert("请选择审核结果");
                    return false;
                }
                if(_this.form.xueliYesnoText == null || _this.form.xueliYesnoText == ""){
                        alert("请输入审核原因");
                        return false;
                }
                this.$http({
                    url:`xueli/update`,
                    method: "post",
                    data: _this.form
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.$message({
                            message: "审核成功",
                            type: "success",
                            duration: 1500,
                            onClose: () => {
                                _this.xueliYesnoTypesVisible = false;
                                _this.search();
                            }
                        });
                    } else {
                        this.$message.error(data.msg);
                        _this.xueliYesnoTypesVisible = false;
                    }
                });
            },
        }
    };
</script>
<style lang="scss" scoped>
.slt {
    margin: 0 !important;
    display: flex;
  }

  .ad {
    margin: 0 !important;
    display: flex;
  }

  .pages {
    & /deep/ el-pagination__sizes{
      & /deep/ el-input__inner {
        height: 22px;
        line-height: 22px;
      }
    }
  }
  

  .el-button+.el-button {
    margin:0;
  } 

  .tables {
	& /deep/ .el-button--success {
		height: 30px;
		color: rgba(88, 179, 81, 1);
		font-size: 12px;
		border-width: 1px;
		border-style: none none solid none;
		border-color: rgba(88, 179, 81, 1);
		border-radius: 0px;
		background-color: #fff;
	}
	
	& /deep/ .el-button--primary {
		height: 30px;
		color: rgba(88, 179, 81, 1);
		font-size: 12px;
		border-width: 1px;
		border-style: none none solid none;
		border-color: rgba(88, 179, 81, 1);
		border-radius: 0px;
		background-color: #fff;
	}
	
	& /deep/ .el-button--danger {
		height: 30px;
		color: rgba(88, 179, 81, 1);
		font-size: 12px;
		border-width: 1px;
		border-style: none none solid none;
		border-color: rgba(88, 179, 81, 1);
		border-radius: 0px;
		background-color: #fff;
	}

    & /deep/ .el-button {
      margin: 4px;
    }
  }</style>


