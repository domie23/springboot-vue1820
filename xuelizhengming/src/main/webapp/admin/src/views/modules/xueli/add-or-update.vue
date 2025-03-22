<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="80px"
                :style="{backgroundColor:addEditForm.addEditBoxColor}">
            <el-row>
                <el-col :span="12"  v-if="sessionTable !='yonghu' && type=='info'">
                    <el-form-item class="select" v-if="type!='info'"  label="用户" prop="yonghuId">
                        <el-select v-model="ruleForm.yonghuId" :disabled="ro.yonghuId" filterable placeholder="请选择用户" @change="yonghuChange">
                            <el-option
                                    v-for="(item,index) in yonghuOptions"
                                    v-bind:key="item.id"
                                    :label="item.yonghuName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='yonghu' && type=='info' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户姓名" prop="yonghuName">
                        <el-input v-model="yonghuForm.yonghuName"
                                  placeholder="用户姓名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="用户姓名" prop="yonghuName">
                            <el-input v-model="ruleForm.yonghuName"
                                      placeholder="用户姓名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yonghu' && type=='info' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户手机号" prop="yonghuPhone">
                        <el-input v-model="yonghuForm.yonghuPhone"
                                  placeholder="用户手机号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="用户手机号" prop="yonghuPhone">
                            <el-input v-model="ruleForm.yonghuPhone"
                                      placeholder="用户手机号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="24" v-if="sessionTable !='yonghu' && type=='info' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.yonghuPhoto" label="用户头像" prop="yonghuPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (yonghuForm.yonghuPhoto || '').split(',')" :src="item" width="100" height="100">
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.yonghuPhoto" label="用户头像" prop="yonghuPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.yonghuPhoto || '').split(',')" :src="item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="type=='qianyue'">
                    <el-form-item class="select" v-if="type!='info'"  label="转接地" prop="zhuanjiediId">
                        <el-select v-model="ruleForm.zhuanjiediId" :disabled="ro.zhuanjiediId" filterable placeholder="请选择转接地" @change="zhuanjiediChange">
                            <el-option
                                    v-for="(item,index) in zhuanjiediOptions"
                                    v-bind:key="item.id"
                                    :label="item.zhuanjiediName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='zhuanjiedi' && (type=='info' || type=='qianyue')">
                    <el-form-item class="input" v-if="type!='info'"  label="转接地编号" prop="zhuanjiediUuidNumber">
                        <el-input v-model="zhuanjiediForm.zhuanjiediUuidNumber"
                                  placeholder="转接地编号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="转接地编号" prop="zhuanjiediUuidNumber">
                            <el-input v-model="ruleForm.zhuanjiediUuidNumber"
                                      placeholder="转接地编号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='zhuanjiedi' && (type=='info' || type=='qianyue')">
                    <el-form-item class="input" v-if="type!='info'"  label="转接地名称" prop="zhuanjiediName">
                        <el-input v-model="zhuanjiediForm.zhuanjiediName"
                                  placeholder="转接地名称" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="转接地名称" prop="zhuanjiediName">
                            <el-input v-model="ruleForm.zhuanjiediName"
                                      placeholder="转接地名称" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='zhuanjiedi' && (type=='info' || type=='qianyue')">
                    <el-form-item class="input" v-if="type!='info'"  label="转接地类型" prop="zhuanjiediValue">
                        <el-input v-model="zhuanjiediForm.zhuanjiediValue"
                                  placeholder="转接地类型" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="转接地类型" prop="zhuanjiediValue">
                            <el-input v-model="ruleForm.zhuanjiediValue"
                                      placeholder="转接地类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='zhuanjiedi' && (type=='info' || type=='qianyue')">
                    <el-form-item class="input" v-if="type!='info'"  label="二级类型" prop="zhuanjiediErjiValue">
                        <el-input v-model="zhuanjiediForm.zhuanjiediErjiValue"
                                  placeholder="二级类型" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="二级类型" prop="zhuanjiediErjiValue">
                            <el-input v-model="ruleForm.zhuanjiediErjiValue"
                                      placeholder="二级类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <input id="updateId" name="id" type="hidden">
            <input id="yonghuId" name="yonghuId" type="hidden">
            <input id="zhuanjiediId" name="zhuanjiediId" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info' && type!='qianyue'"  label="学历编号" prop="xueliUuidNumber">
                       <el-input v-model="ruleForm.xueliUuidNumber"
                                 placeholder="学历编号" clearable  :readonly="ro.xueliUuidNumber"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="学历编号" prop="xueliUuidNumber">
                           <el-input v-model="ruleForm.xueliUuidNumber"
                                     placeholder="学历编号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="24">
                    <el-form-item class="upload" v-if="type!='info' && !ro.zhengjianPhoto && type!='qianyue'" label="证件照" prop="zhengjianPhoto">
                        <file-upload
                            tip="点击上传证件照"
                            action="file/upload"
                            :limit="3"
                            :multiple="true"
                            :fileUrls="ruleForm.zhengjianPhoto?ruleForm.zhengjianPhoto:''"
                            @change="zhengjianPhotoUploadChange"
                        ></file-upload>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.zhengjianPhoto" label="证件照" prop="zhengjianPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.zhengjianPhoto || '').split(',')" :src="item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info' && type!='qianyue'"  label="姓名" prop="xueliName">
                       <el-input v-model="ruleForm.xueliName"
                                 placeholder="姓名" clearable  :readonly="ro.xueliName"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="姓名" prop="xueliName">
                           <el-input v-model="ruleForm.xueliName"
                                     placeholder="姓名" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info' && type!='qianyue'"  label="身份证号" prop="xueliIdNumber">
                       <el-input v-model="ruleForm.xueliIdNumber"
                                 placeholder="身份证号" clearable  :readonly="ro.xueliIdNumber"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="身份证号" prop="xueliIdNumber">
                           <el-input v-model="ruleForm.xueliIdNumber"
                                     placeholder="身份证号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info' && type!='qianyue'"  label="证书编号" prop="xueliZhengshuNumber">
                       <el-input v-model="ruleForm.xueliZhengshuNumber"
                                 placeholder="证书编号" clearable  :readonly="ro.xueliZhengshuNumber"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="证书编号" prop="xueliZhengshuNumber">
                           <el-input v-model="ruleForm.xueliZhengshuNumber"
                                     placeholder="证书编号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12" v-if="sessionTable != 'yonghu' && type!='qianyue'">
                   <el-form-item class="input" v-if="type!='info'"  label="认证编号" prop="xueliRenzhengbianhaoNumber">
                       <el-input v-model="ruleForm.xueliRenzhengbianhaoNumber"
                                 placeholder="认证编号" clearable  :readonly="ro.xueliRenzhengbianhaoNumber"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="认证编号" prop="xueliRenzhengbianhaoNumber">
                           <el-input v-model="ruleForm.xueliRenzhengbianhaoNumber"
                                     placeholder="认证编号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info' && type!='qianyue'"  label="性别" prop="xuelixingbieTypes">
                        <el-select v-model="ruleForm.xuelixingbieTypes" :disabled="ro.xuelixingbieTypes" placeholder="请选择性别">
                            <el-option
                                v-for="(item,index) in xuelixingbieTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="性别" prop="xuelixingbieValue">
                        <el-input v-model="ruleForm.xuelixingbieValue"
                            placeholder="性别" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info' && type!='qianyue'"  label="出生年月" prop="xueliChushengnianyue">
                       <el-input type="month" v-model="ruleForm.xueliChushengnianyue"
                                 placeholder="出生年月" clearable  :readonly="ro.xueliChushengnianyue"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="出生年月" prop="xueliChushengnianyue">
                           <el-input v-model="ruleForm.xueliChushengnianyue"
                                     placeholder="出生年月" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info' && type!='qianyue'"  label="国籍" prop="xueliGuoji">
                       <el-input v-model="ruleForm.xueliGuoji"
                                 placeholder="国籍" clearable  :readonly="ro.xueliGuoji"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="国籍" prop="xueliGuoji">
                           <el-input v-model="ruleForm.xueliGuoji"
                                     placeholder="国籍" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info' && type!='qianyue'"  label="民族" prop="xueliMinzu">
                       <el-input v-model="ruleForm.xueliMinzu"
                                 placeholder="民族" clearable  :readonly="ro.xueliMinzu"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="民族" prop="xueliMinzu">
                           <el-input v-model="ruleForm.xueliMinzu"
                                     placeholder="民族" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info' && type!='qianyue'"  label="学历性质" prop="xuelixingzhiTypes">
                        <el-select v-model="ruleForm.xuelixingzhiTypes" :disabled="ro.xuelixingzhiTypes" placeholder="请选择学历性质">
                            <el-option
                                v-for="(item,index) in xuelixingzhiTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="学历性质" prop="xuelixingzhiValue">
                        <el-input v-model="ruleForm.xuelixingzhiValue"
                            placeholder="学历性质" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info' && type!='qianyue'"  label="学制" prop="xueliXuezhiTypes">
                        <el-select v-model="ruleForm.xueliXuezhiTypes" :disabled="ro.xueliXuezhiTypes" placeholder="请选择学制">
                            <el-option
                                v-for="(item,index) in xueliXuezhiTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="学制" prop="xueliXuezhiValue">
                        <el-input v-model="ruleForm.xueliXuezhiValue"
                            placeholder="学制" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info' && type!='qianyue'"  label="学习形式" prop="xueliXuexixingshiTypes">
                        <el-select v-model="ruleForm.xueliXuexixingshiTypes" :disabled="ro.xueliXuexixingshiTypes" placeholder="请选择学习形式">
                            <el-option
                                v-for="(item,index) in xueliXuexixingshiTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="学习形式" prop="xueliXuexixingshiValue">
                        <el-input v-model="ruleForm.xueliXuexixingshiValue"
                            placeholder="学习形式" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info' && type!='qianyue'"  label="毕业院校" prop="xueliBiyeyuanxiao">
                       <el-input v-model="ruleForm.xueliBiyeyuanxiao"
                                 placeholder="毕业院校" clearable  :readonly="ro.xueliBiyeyuanxiao"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="毕业院校" prop="xueliBiyeyuanxiao">
                           <el-input v-model="ruleForm.xueliBiyeyuanxiao"
                                     placeholder="毕业院校" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info' && type!='qianyue'"  label="专业" prop="xueliZhuanyeTypes">
                        <el-select v-model="ruleForm.xueliZhuanyeTypes" :disabled="ro.xueliZhuanyeTypes" placeholder="请选择专业">
                            <el-option
                                v-for="(item,index) in xueliZhuanyeTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="专业" prop="xueliZhuanyeValue">
                        <el-input v-model="ruleForm.xueliZhuanyeValue"
                            placeholder="专业" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info' && type!='qianyue'"  label="班级" prop="xueliBanjiTypes">
                        <el-select v-model="ruleForm.xueliBanjiTypes" :disabled="ro.xueliBanjiTypes" placeholder="请选择班级">
                            <el-option
                                v-for="(item,index) in xueliBanjiTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="班级" prop="xueliBanjiValue">
                        <el-input v-model="ruleForm.xueliBanjiValue"
                            placeholder="班级" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info' && type!='qianyue'"  label="入校年月" prop="xueliRuxiaonianyue">
                       <el-input type="month" v-model="ruleForm.xueliRuxiaonianyue"
                                 placeholder="入校年月" clearable  :readonly="ro.xueliRuxiaonianyue"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="入校年月" prop="xueliRuxiaonianyue">
                           <el-input v-model="ruleForm.xueliRuxiaonianyue"
                                     placeholder="入校年月" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info' && type!='qianyue'"  label="毕业年月" prop="xueliBiyenianyue">
                       <el-input type="month" v-model="ruleForm.xueliBiyenianyue"
                                 placeholder="毕业年月" clearable  :readonly="ro.xueliBiyenianyue"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="毕业年月" prop="xueliBiyenianyue">
                           <el-input v-model="ruleForm.xueliBiyenianyue"
                                     placeholder="毕业年月" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info' && type!='qianyue'"  label="成分" prop="xueliChengfenTypes">
                        <el-select v-model="ruleForm.xueliChengfenTypes" :disabled="ro.xueliChengfenTypes" placeholder="请选择成分">
                            <el-option
                                v-for="(item,index) in xueliChengfenTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="成分" prop="xueliChengfenValue">
                        <el-input v-model="ruleForm.xueliChengfenValue"
                            placeholder="成分" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info' && type!='qianyue'"  label="联系方式" prop="xueliLianxifangshiPhone">
                       <el-input v-model="ruleForm.xueliLianxifangshiPhone"
                                 placeholder="联系方式" clearable  :readonly="ro.xueliLianxifangshiPhone"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="联系方式" prop="xueliLianxifangshiPhone">
                           <el-input v-model="ruleForm.xueliLianxifangshiPhone"
                                     placeholder="联系方式" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
            <el-col :span="12" v-if="type=='info'">
                <div>
                    <el-form-item v-if="ruleForm.xueliYesnoTypes" label="审核状态" prop="xueliYesnoTypes">
                        <el-input v-model="ruleForm.xueliYesnoValue" placeholder="审核状态" readonly></el-input>
                    </el-form-item>
                </div>
            </el-col>
            <el-col :span="12" v-if="type=='info'">
                <div>
                    <el-form-item v-if="ruleForm.xueliYesnoText" label="审核意见" prop="xueliYesnoText">
                        <span v-html="ruleForm.xueliYesnoText"></span>
                    </el-form-item>
                </div>
            </el-col>
            </el-row>
            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
                <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
                <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    import styleJs from "../../../utils/style.js";
    // 数字，邮件，手机，url，身份证校验
    import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
    export default {
        data() {
            return {
                addEditForm:null,
                id: '',
                type: '',
                sessionTable : "",//登录账户所在表名
                role : "",//权限
                userId:"",//当前登录人的id
                yonghuForm: {},
                zhuanjiediForm: {},
                ro:{
                    yonghuId: false,
                    zhuanjiediId: false,
                    xueliUuidNumber: false,
                    zhengjianPhoto: false,
                    xueliName: false,
                    xueliIdNumber: false,
                    xueliZhengshuNumber: false,
                    xueliRenzhengbianhaoNumber: false,
                    xuelixingbieTypes: false,
                    xueliChushengnianyue: false,
                    xueliGuoji: false,
                    xueliMinzu: false,
                    xuelixingzhiTypes: false,
                    xueliXuezhiTypes: false,
                    xueliXuexixingshiTypes: false,
                    xueliBiyeyuanxiao: false,
                    xueliZhuanyeTypes: false,
                    xueliBanjiTypes: false,
                    xueliRuxiaonianyue: false,
                    xueliBiyenianyue: false,
                    xueliChengfenTypes: false,
                    xueliLianxifangshiPhone: false,
                    xueliYesnoTypes: false,
                    xueliYesnoText: false,
                    xueliDelete: false,
                    insertTime: false,
                },
                ruleForm: {
                    yonghuId: '',
                    zhuanjiediId: '',
                    xueliUuidNumber: new Date().getTime(),
                    zhengjianPhoto: '',
                    xueliName: '',
                    xueliIdNumber: '',
                    xueliZhengshuNumber: '',
                    xueliRenzhengbianhaoNumber: '',
                    xuelixingbieTypes: '',
                    xueliChushengnianyue: '',
                    xueliGuoji: '',
                    xueliMinzu: '',
                    xuelixingzhiTypes: '',
                    xueliXuezhiTypes: '',
                    xueliXuexixingshiTypes: '',
                    xueliBiyeyuanxiao: '',
                    xueliZhuanyeTypes: '',
                    xueliBanjiTypes: '',
                    xueliRuxiaonianyue: '',
                    xueliBiyenianyue: '',
                    xueliChengfenTypes: '',
                    xueliLianxifangshiPhone: '',
                    xueliYesnoTypes: '',
                    xueliYesnoText: '',
                    xueliDelete: '',
                    insertTime: '',
                },
                xuelixingbieTypesOptions : [],
                xuelixingzhiTypesOptions : [],
                xueliXuezhiTypesOptions : [],
                xueliXuexixingshiTypesOptions : [],
                xueliZhuanyeTypesOptions : [],
                xueliBanjiTypesOptions : [],
                xueliChengfenTypesOptions : [],
                xueliYesnoTypesOptions : [],
                yonghuOptions : [],
                zhuanjiediOptions : [],
                rules: {
                   yonghuId: [
                              { required: true, message: '用户不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   zhuanjiediId: [
                              { required: true, message: '转接地不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   xueliUuidNumber: [
                              { required: true, message: '学历编号不能为空', trigger: 'blur' },
                          ],
                   zhengjianPhoto: [
                              { required: true, message: '证件照不能为空', trigger: 'blur' },
                          ],
                   xueliName: [
                              { required: true, message: '姓名不能为空', trigger: 'blur' },
                          ],
                   xueliIdNumber: [
                              { required: true, message: '身份证号不能为空', trigger: 'blur' },
                              { pattern: /^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/,
                                message: '身份证号格式有误！',
                                trigger: 'blur'
                              }
                          ],
                   xueliZhengshuNumber: [
                              { required: true, message: '证书编号不能为空', trigger: 'blur' },
                          ],
                   xueliRenzhengbianhaoNumber: [
                              { required: true, message: '认证编号不能为空', trigger: 'blur' },
                          ],
                   xuelixingbieTypes: [
                              { required: true, message: '性别不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   xueliChushengnianyue: [
                              { required: true, message: '出生年月不能为空', trigger: 'blur' },
                          ],
                   xueliGuoji: [
                              { required: true, message: '国籍不能为空', trigger: 'blur' },
                          ],
                   xueliMinzu: [
                              { required: true, message: '民族不能为空', trigger: 'blur' },
                          ],
                   xuelixingzhiTypes: [
                              { required: true, message: '学历性质不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   xueliXuezhiTypes: [
                              { required: true, message: '学制不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   xueliXuexixingshiTypes: [
                              { required: true, message: '学习形式不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   xueliBiyeyuanxiao: [
                              { required: true, message: '毕业院校不能为空', trigger: 'blur' },
                          ],
                   xueliZhuanyeTypes: [
                              { required: true, message: '专业不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   xueliBanjiTypes: [
                              { required: true, message: '班级不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   xueliRuxiaonianyue: [
                              { required: true, message: '入校年月不能为空', trigger: 'blur' },
                          ],
                   xueliBiyenianyue: [
                              { required: true, message: '毕业年月不能为空', trigger: 'blur' },
                          ],
                   xueliChengfenTypes: [
                              { required: true, message: '成分不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   xueliLianxifangshiPhone: [
                              { required: true, message: '联系方式不能为空', trigger: 'blur' },
                          ],
                   xueliYesnoTypes: [
                              { required: true, message: '审核状态不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   xueliYesnoText: [
                              { required: true, message: '审核意见不能为空', trigger: 'blur' },
                          ],
                   xueliDelete: [
                              { required: true, message: '逻辑删除不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   insertTime: [
                              { required: true, message: '录入时间不能为空', trigger: 'blur' },
                          ],
                }
            };
        },
        props: ["parent"],
        computed: {
        },
        created() {
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");


            if (this.role != "管理员"){
            }
            this.addEditForm = styleJs.addStyle();
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
            //获取下拉框信息
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=xuelixingbie_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.xuelixingbieTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=xuelixingzhi_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.xuelixingzhiTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=xueli_xuezhi_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.xueliXuezhiTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=xueli_xuexixingshi_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.xueliXuexixingshiTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=xueli_zhuanye_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.xueliZhuanyeTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=xueli_banji_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.xueliBanjiTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=xueli_chengfen_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.xueliChengfenTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=xueli_yesno_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.xueliYesnoTypesOptions = data.data.list;
                    }
                });

         this.$http({
             url: `yonghu/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.yonghuOptions = data.data.list;
            }
         });
         this.$http({
             url: `zhuanjiedi/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.zhuanjiediOptions = data.data.list;
            }
         });

        },
        mounted() {
        },
        methods: {
            // 下载
            download(file){
                window.open(`${file}`)
            },
            // 初始化
            init(id,type) {
                if (id) {
                    this.id = id;
                    this.type = type;
                }
                if(this.type=='info'||this.type=='else'||this.type=='qianyue'){
                    this.info(id);
                }
                // 获取用户信息
                this.$http({
                    url:`${this.$storage.get("sessionTable")}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        var json = data.data;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            },
            yonghuChange(id){
                this.$http({
                    url: `yonghu/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.yonghuForm = data.data;
                    }
                });
            },
            zhuanjiediChange(id){
                this.$http({
                    url: `zhuanjiedi/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.zhuanjiediForm = data.data;
                    }
                });
            },
            // 多级联动参数
            info(id) {
                let _this =this;
                _this.$http({
                    url: `xueli/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.ruleForm = data.data;
                        _this.yonghuChange(data.data.yonghuId)
                        _this.zhuanjiediChange(data.data.zhuanjiediId)
                    } else {
                        _this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        let name = "";
                        // ${!this.ruleForm.id ? "save" : "update"}
                        if(this.ruleForm.id == null ||this.ruleForm.id == "" ){
                            name = "save"
                        }else if(this.ruleForm.id != null){
                            if(this.type =="qianyue"){
                                name = "qianyue"
                            }else{
                                name = "update"
                            }
                        }

                        this.$http({
                            url:'xueli/'+name,
                            method: "post",
                            data: this.ruleForm
                        }).then(({ data }) => {
                            if (data && data.code === 0) {
                                this.$message({
                                    message: "操作成功",
                                    type: "success",
                                    duration: 1500,
                                    onClose: () => {
                                        this.parent.showFlag = true;
                                        this.parent.addOrUpdateFlag = false;
                                        this.parent.xueliCrossAddOrUpdateFlag = false;
                                        this.parent.search();
                                        this.parent.contentStyleChange();
                                    }
                                });
                            } else {
                                this.$message.error(data.msg);
                            }
                        });
                    }
                });
            },
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            // 返回
            back() {
                this.parent.showFlag = true;
                this.parent.addOrUpdateFlag = false;
                this.parent.xueliCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            //图片
            zhengjianPhotoUploadChange(fileUrls){
                this.ruleForm.zhengjianPhoto = fileUrls;
                this.addEditUploadStyleChange()
            },

            addEditStyleChange() {
                this.$nextTick(()=>{
                    // input
                    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputFontColor
                        el.style.fontSize = this.addEditForm.inputFontSize
                        el.style.borderWidth = this.addEditForm.inputBorderWidth
                        el.style.borderStyle = this.addEditForm.inputBorderStyle
                        el.style.borderColor = this.addEditForm.inputBorderColor
                        el.style.borderRadius = this.addEditForm.inputBorderRadius
                        el.style.backgroundColor = this.addEditForm.inputBgColor
                    })
                    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputLableColor
                        el.style.fontSize = this.addEditForm.inputLableFontSize
                    })
                    // select
                    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectFontColor
                        el.style.fontSize = this.addEditForm.selectFontSize
                        el.style.borderWidth = this.addEditForm.selectBorderWidth
                        el.style.borderStyle = this.addEditForm.selectBorderStyle
                        el.style.borderColor = this.addEditForm.selectBorderColor
                        el.style.borderRadius = this.addEditForm.selectBorderRadius
                        el.style.backgroundColor = this.addEditForm.selectBgColor
                    })
                    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectLableColor
                        el.style.fontSize = this.addEditForm.selectLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
                        el.style.color = this.addEditForm.selectIconFontColor
                        el.style.fontSize = this.addEditForm.selectIconFontSize
                    })
                    // date
                    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateFontColor
                        el.style.fontSize = this.addEditForm.dateFontSize
                        el.style.borderWidth = this.addEditForm.dateBorderWidth
                        el.style.borderStyle = this.addEditForm.dateBorderStyle
                        el.style.borderColor = this.addEditForm.dateBorderColor
                        el.style.borderRadius = this.addEditForm.dateBorderRadius
                        el.style.backgroundColor = this.addEditForm.dateBgColor
                    })
                    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateLableColor
                        el.style.fontSize = this.addEditForm.dateLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
                        el.style.color = this.addEditForm.dateIconFontColor
                        el.style.fontSize = this.addEditForm.dateIconFontSize
                        el.style.lineHeight = this.addEditForm.dateHeight
                    })
                    // upload
                    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
                    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.uploadHeight
                        el.style.color = this.addEditForm.uploadLableColor
                        el.style.fontSize = this.addEditForm.uploadLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
                        el.style.color = this.addEditForm.uploadIconFontColor
                        el.style.fontSize = this.addEditForm.uploadIconFontSize
                        el.style.lineHeight = iconLineHeight
                        el.style.display = 'block'
                    })
                    // 多文本输入框
                    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
                        el.style.height = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaFontColor
                        el.style.fontSize = this.addEditForm.textareaFontSize
                        el.style.borderWidth = this.addEditForm.textareaBorderWidth
                        el.style.borderStyle = this.addEditForm.textareaBorderStyle
                        el.style.borderColor = this.addEditForm.textareaBorderColor
                        el.style.borderRadius = this.addEditForm.textareaBorderRadius
                        el.style.backgroundColor = this.addEditForm.textareaBgColor
                    })
                    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
                        // el.style.lineHeight = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaLableColor
                        el.style.fontSize = this.addEditForm.textareaLableFontSize
                    })
                    // 保存
                    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
                        el.style.width = this.addEditForm.btnSaveWidth
                        el.style.height = this.addEditForm.btnSaveHeight
                        el.style.color = this.addEditForm.btnSaveFontColor
                        el.style.fontSize = this.addEditForm.btnSaveFontSize
                        el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
                        el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
                        el.style.borderColor = this.addEditForm.btnSaveBorderColor
                        el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnSaveBgColor
                    })
                    // 返回
                    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
                        el.style.width = this.addEditForm.btnCancelWidth
                        el.style.height = this.addEditForm.btnCancelHeight
                        el.style.color = this.addEditForm.btnCancelFontColor
                        el.style.fontSize = this.addEditForm.btnCancelFontSize
                        el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
                        el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
                        el.style.borderColor = this.addEditForm.btnCancelBorderColor
                        el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnCancelBgColor
                    })
                })
            },
            addEditUploadStyleChange() {
                this.$nextTick(()=>{
                    document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                })
            },
        }
    };
</script>
<style lang="scss">
.editor{
  height: 500px;

  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
}
.btn .el-button {
  padding: 0;
}</style>

