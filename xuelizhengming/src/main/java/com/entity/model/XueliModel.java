package com.entity.model;

import com.entity.XueliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 学历
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XueliModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 转接地
     */
    private Integer zhuanjiediId;


    /**
     * 学历编号
     */
    private String xueliUuidNumber;


    /**
     * 证件照
     */
    private String zhengjianPhoto;


    /**
     * 姓名
     */
    private String xueliName;


    /**
     * 身份证号
     */
    private String xueliIdNumber;


    /**
     * 证书编号
     */
    private String xueliZhengshuNumber;


    /**
     * 认证编号
     */
    private String xueliRenzhengbianhaoNumber;


    /**
     * 性别
     */
    private Integer xuelixingbieTypes;


    /**
     * 出生年月
     */
    private String xueliChushengnianyue;


    /**
     * 国籍
     */
    private String xueliGuoji;


    /**
     * 民族
     */
    private String xueliMinzu;


    /**
     * 学历性质
     */
    private Integer xuelixingzhiTypes;


    /**
     * 学制
     */
    private Integer xueliXuezhiTypes;


    /**
     * 学习形式
     */
    private Integer xueliXuexixingshiTypes;


    /**
     * 毕业院校
     */
    private String xueliBiyeyuanxiao;


    /**
     * 专业
     */
    private Integer xueliZhuanyeTypes;


    /**
     * 班级
     */
    private Integer xueliBanjiTypes;


    /**
     * 入校年月
     */
    private String xueliRuxiaonianyue;


    /**
     * 毕业年月
     */
    private String xueliBiyenianyue;


    /**
     * 成分
     */
    private Integer xueliChengfenTypes;


    /**
     * 联系方式
     */
    private String xueliLianxifangshiPhone;


    /**
     * 审核状态
     */
    private Integer xueliYesnoTypes;


    /**
     * 审核意见
     */
    private String xueliYesnoText;


    /**
     * 逻辑删除
     */
    private Integer xueliDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：转接地
	 */
    public Integer getZhuanjiediId() {
        return zhuanjiediId;
    }


    /**
	 * 设置：转接地
	 */
    public void setZhuanjiediId(Integer zhuanjiediId) {
        this.zhuanjiediId = zhuanjiediId;
    }
    /**
	 * 获取：学历编号
	 */
    public String getXueliUuidNumber() {
        return xueliUuidNumber;
    }


    /**
	 * 设置：学历编号
	 */
    public void setXueliUuidNumber(String xueliUuidNumber) {
        this.xueliUuidNumber = xueliUuidNumber;
    }
    /**
	 * 获取：证件照
	 */
    public String getZhengjianPhoto() {
        return zhengjianPhoto;
    }


    /**
	 * 设置：证件照
	 */
    public void setZhengjianPhoto(String zhengjianPhoto) {
        this.zhengjianPhoto = zhengjianPhoto;
    }
    /**
	 * 获取：姓名
	 */
    public String getXueliName() {
        return xueliName;
    }


    /**
	 * 设置：姓名
	 */
    public void setXueliName(String xueliName) {
        this.xueliName = xueliName;
    }
    /**
	 * 获取：身份证号
	 */
    public String getXueliIdNumber() {
        return xueliIdNumber;
    }


    /**
	 * 设置：身份证号
	 */
    public void setXueliIdNumber(String xueliIdNumber) {
        this.xueliIdNumber = xueliIdNumber;
    }
    /**
	 * 获取：证书编号
	 */
    public String getXueliZhengshuNumber() {
        return xueliZhengshuNumber;
    }


    /**
	 * 设置：证书编号
	 */
    public void setXueliZhengshuNumber(String xueliZhengshuNumber) {
        this.xueliZhengshuNumber = xueliZhengshuNumber;
    }
    /**
	 * 获取：认证编号
	 */
    public String getXueliRenzhengbianhaoNumber() {
        return xueliRenzhengbianhaoNumber;
    }


    /**
	 * 设置：认证编号
	 */
    public void setXueliRenzhengbianhaoNumber(String xueliRenzhengbianhaoNumber) {
        this.xueliRenzhengbianhaoNumber = xueliRenzhengbianhaoNumber;
    }
    /**
	 * 获取：性别
	 */
    public Integer getXuelixingbieTypes() {
        return xuelixingbieTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setXuelixingbieTypes(Integer xuelixingbieTypes) {
        this.xuelixingbieTypes = xuelixingbieTypes;
    }
    /**
	 * 获取：出生年月
	 */
    public String getXueliChushengnianyue() {
        return xueliChushengnianyue;
    }


    /**
	 * 设置：出生年月
	 */
    public void setXueliChushengnianyue(String xueliChushengnianyue) {
        this.xueliChushengnianyue = xueliChushengnianyue;
    }
    /**
	 * 获取：国籍
	 */
    public String getXueliGuoji() {
        return xueliGuoji;
    }


    /**
	 * 设置：国籍
	 */
    public void setXueliGuoji(String xueliGuoji) {
        this.xueliGuoji = xueliGuoji;
    }
    /**
	 * 获取：民族
	 */
    public String getXueliMinzu() {
        return xueliMinzu;
    }


    /**
	 * 设置：民族
	 */
    public void setXueliMinzu(String xueliMinzu) {
        this.xueliMinzu = xueliMinzu;
    }
    /**
	 * 获取：学历性质
	 */
    public Integer getXuelixingzhiTypes() {
        return xuelixingzhiTypes;
    }


    /**
	 * 设置：学历性质
	 */
    public void setXuelixingzhiTypes(Integer xuelixingzhiTypes) {
        this.xuelixingzhiTypes = xuelixingzhiTypes;
    }
    /**
	 * 获取：学制
	 */
    public Integer getXueliXuezhiTypes() {
        return xueliXuezhiTypes;
    }


    /**
	 * 设置：学制
	 */
    public void setXueliXuezhiTypes(Integer xueliXuezhiTypes) {
        this.xueliXuezhiTypes = xueliXuezhiTypes;
    }
    /**
	 * 获取：学习形式
	 */
    public Integer getXueliXuexixingshiTypes() {
        return xueliXuexixingshiTypes;
    }


    /**
	 * 设置：学习形式
	 */
    public void setXueliXuexixingshiTypes(Integer xueliXuexixingshiTypes) {
        this.xueliXuexixingshiTypes = xueliXuexixingshiTypes;
    }
    /**
	 * 获取：毕业院校
	 */
    public String getXueliBiyeyuanxiao() {
        return xueliBiyeyuanxiao;
    }


    /**
	 * 设置：毕业院校
	 */
    public void setXueliBiyeyuanxiao(String xueliBiyeyuanxiao) {
        this.xueliBiyeyuanxiao = xueliBiyeyuanxiao;
    }
    /**
	 * 获取：专业
	 */
    public Integer getXueliZhuanyeTypes() {
        return xueliZhuanyeTypes;
    }


    /**
	 * 设置：专业
	 */
    public void setXueliZhuanyeTypes(Integer xueliZhuanyeTypes) {
        this.xueliZhuanyeTypes = xueliZhuanyeTypes;
    }
    /**
	 * 获取：班级
	 */
    public Integer getXueliBanjiTypes() {
        return xueliBanjiTypes;
    }


    /**
	 * 设置：班级
	 */
    public void setXueliBanjiTypes(Integer xueliBanjiTypes) {
        this.xueliBanjiTypes = xueliBanjiTypes;
    }
    /**
	 * 获取：入校年月
	 */
    public String getXueliRuxiaonianyue() {
        return xueliRuxiaonianyue;
    }


    /**
	 * 设置：入校年月
	 */
    public void setXueliRuxiaonianyue(String xueliRuxiaonianyue) {
        this.xueliRuxiaonianyue = xueliRuxiaonianyue;
    }
    /**
	 * 获取：毕业年月
	 */
    public String getXueliBiyenianyue() {
        return xueliBiyenianyue;
    }


    /**
	 * 设置：毕业年月
	 */
    public void setXueliBiyenianyue(String xueliBiyenianyue) {
        this.xueliBiyenianyue = xueliBiyenianyue;
    }
    /**
	 * 获取：成分
	 */
    public Integer getXueliChengfenTypes() {
        return xueliChengfenTypes;
    }


    /**
	 * 设置：成分
	 */
    public void setXueliChengfenTypes(Integer xueliChengfenTypes) {
        this.xueliChengfenTypes = xueliChengfenTypes;
    }
    /**
	 * 获取：联系方式
	 */
    public String getXueliLianxifangshiPhone() {
        return xueliLianxifangshiPhone;
    }


    /**
	 * 设置：联系方式
	 */
    public void setXueliLianxifangshiPhone(String xueliLianxifangshiPhone) {
        this.xueliLianxifangshiPhone = xueliLianxifangshiPhone;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getXueliYesnoTypes() {
        return xueliYesnoTypes;
    }


    /**
	 * 设置：审核状态
	 */
    public void setXueliYesnoTypes(Integer xueliYesnoTypes) {
        this.xueliYesnoTypes = xueliYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getXueliYesnoText() {
        return xueliYesnoText;
    }


    /**
	 * 设置：审核意见
	 */
    public void setXueliYesnoText(String xueliYesnoText) {
        this.xueliYesnoText = xueliYesnoText;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getXueliDelete() {
        return xueliDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setXueliDelete(Integer xueliDelete) {
        this.xueliDelete = xueliDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
