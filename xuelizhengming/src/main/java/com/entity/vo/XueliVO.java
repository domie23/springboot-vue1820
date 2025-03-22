package com.entity.vo;

import com.entity.XueliEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 学历
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xueli")
public class XueliVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 转接地
     */

    @TableField(value = "zhuanjiedi_id")
    private Integer zhuanjiediId;


    /**
     * 学历编号
     */

    @TableField(value = "xueli_uuid_number")
    private String xueliUuidNumber;


    /**
     * 证件照
     */

    @TableField(value = "zhengjian_photo")
    private String zhengjianPhoto;


    /**
     * 姓名
     */

    @TableField(value = "xueli_name")
    private String xueliName;


    /**
     * 身份证号
     */

    @TableField(value = "xueli_id_number")
    private String xueliIdNumber;


    /**
     * 证书编号
     */

    @TableField(value = "xueli_zhengshu_number")
    private String xueliZhengshuNumber;


    /**
     * 认证编号
     */

    @TableField(value = "xueli_renzhengbianhao_number")
    private String xueliRenzhengbianhaoNumber;


    /**
     * 性别
     */

    @TableField(value = "xuelixingbie_types")
    private Integer xuelixingbieTypes;


    /**
     * 出生年月
     */

    @TableField(value = "xueli_chushengnianyue")
    private String xueliChushengnianyue;


    /**
     * 国籍
     */

    @TableField(value = "xueli_guoji")
    private String xueliGuoji;


    /**
     * 民族
     */

    @TableField(value = "xueli_minzu")
    private String xueliMinzu;


    /**
     * 学历性质
     */

    @TableField(value = "xuelixingzhi_types")
    private Integer xuelixingzhiTypes;


    /**
     * 学制
     */

    @TableField(value = "xueli_xuezhi_types")
    private Integer xueliXuezhiTypes;


    /**
     * 学习形式
     */

    @TableField(value = "xueli_xuexixingshi_types")
    private Integer xueliXuexixingshiTypes;


    /**
     * 毕业院校
     */

    @TableField(value = "xueli_biyeyuanxiao")
    private String xueliBiyeyuanxiao;


    /**
     * 专业
     */

    @TableField(value = "xueli_zhuanye_types")
    private Integer xueliZhuanyeTypes;


    /**
     * 班级
     */

    @TableField(value = "xueli_banji_types")
    private Integer xueliBanjiTypes;


    /**
     * 入校年月
     */

    @TableField(value = "xueli_ruxiaonianyue")
    private String xueliRuxiaonianyue;


    /**
     * 毕业年月
     */

    @TableField(value = "xueli_biyenianyue")
    private String xueliBiyenianyue;


    /**
     * 成分
     */

    @TableField(value = "xueli_chengfen_types")
    private Integer xueliChengfenTypes;


    /**
     * 联系方式
     */

    @TableField(value = "xueli_lianxifangshi_phone")
    private String xueliLianxifangshiPhone;


    /**
     * 审核状态
     */

    @TableField(value = "xueli_yesno_types")
    private Integer xueliYesnoTypes;


    /**
     * 审核意见
     */

    @TableField(value = "xueli_yesno_text")
    private String xueliYesnoText;


    /**
     * 逻辑删除
     */

    @TableField(value = "xueli_delete")
    private Integer xueliDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：转接地
	 */
    public Integer getZhuanjiediId() {
        return zhuanjiediId;
    }


    /**
	 * 获取：转接地
	 */

    public void setZhuanjiediId(Integer zhuanjiediId) {
        this.zhuanjiediId = zhuanjiediId;
    }
    /**
	 * 设置：学历编号
	 */
    public String getXueliUuidNumber() {
        return xueliUuidNumber;
    }


    /**
	 * 获取：学历编号
	 */

    public void setXueliUuidNumber(String xueliUuidNumber) {
        this.xueliUuidNumber = xueliUuidNumber;
    }
    /**
	 * 设置：证件照
	 */
    public String getZhengjianPhoto() {
        return zhengjianPhoto;
    }


    /**
	 * 获取：证件照
	 */

    public void setZhengjianPhoto(String zhengjianPhoto) {
        this.zhengjianPhoto = zhengjianPhoto;
    }
    /**
	 * 设置：姓名
	 */
    public String getXueliName() {
        return xueliName;
    }


    /**
	 * 获取：姓名
	 */

    public void setXueliName(String xueliName) {
        this.xueliName = xueliName;
    }
    /**
	 * 设置：身份证号
	 */
    public String getXueliIdNumber() {
        return xueliIdNumber;
    }


    /**
	 * 获取：身份证号
	 */

    public void setXueliIdNumber(String xueliIdNumber) {
        this.xueliIdNumber = xueliIdNumber;
    }
    /**
	 * 设置：证书编号
	 */
    public String getXueliZhengshuNumber() {
        return xueliZhengshuNumber;
    }


    /**
	 * 获取：证书编号
	 */

    public void setXueliZhengshuNumber(String xueliZhengshuNumber) {
        this.xueliZhengshuNumber = xueliZhengshuNumber;
    }
    /**
	 * 设置：认证编号
	 */
    public String getXueliRenzhengbianhaoNumber() {
        return xueliRenzhengbianhaoNumber;
    }


    /**
	 * 获取：认证编号
	 */

    public void setXueliRenzhengbianhaoNumber(String xueliRenzhengbianhaoNumber) {
        this.xueliRenzhengbianhaoNumber = xueliRenzhengbianhaoNumber;
    }
    /**
	 * 设置：性别
	 */
    public Integer getXuelixingbieTypes() {
        return xuelixingbieTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setXuelixingbieTypes(Integer xuelixingbieTypes) {
        this.xuelixingbieTypes = xuelixingbieTypes;
    }
    /**
	 * 设置：出生年月
	 */
    public String getXueliChushengnianyue() {
        return xueliChushengnianyue;
    }


    /**
	 * 获取：出生年月
	 */

    public void setXueliChushengnianyue(String xueliChushengnianyue) {
        this.xueliChushengnianyue = xueliChushengnianyue;
    }
    /**
	 * 设置：国籍
	 */
    public String getXueliGuoji() {
        return xueliGuoji;
    }


    /**
	 * 获取：国籍
	 */

    public void setXueliGuoji(String xueliGuoji) {
        this.xueliGuoji = xueliGuoji;
    }
    /**
	 * 设置：民族
	 */
    public String getXueliMinzu() {
        return xueliMinzu;
    }


    /**
	 * 获取：民族
	 */

    public void setXueliMinzu(String xueliMinzu) {
        this.xueliMinzu = xueliMinzu;
    }
    /**
	 * 设置：学历性质
	 */
    public Integer getXuelixingzhiTypes() {
        return xuelixingzhiTypes;
    }


    /**
	 * 获取：学历性质
	 */

    public void setXuelixingzhiTypes(Integer xuelixingzhiTypes) {
        this.xuelixingzhiTypes = xuelixingzhiTypes;
    }
    /**
	 * 设置：学制
	 */
    public Integer getXueliXuezhiTypes() {
        return xueliXuezhiTypes;
    }


    /**
	 * 获取：学制
	 */

    public void setXueliXuezhiTypes(Integer xueliXuezhiTypes) {
        this.xueliXuezhiTypes = xueliXuezhiTypes;
    }
    /**
	 * 设置：学习形式
	 */
    public Integer getXueliXuexixingshiTypes() {
        return xueliXuexixingshiTypes;
    }


    /**
	 * 获取：学习形式
	 */

    public void setXueliXuexixingshiTypes(Integer xueliXuexixingshiTypes) {
        this.xueliXuexixingshiTypes = xueliXuexixingshiTypes;
    }
    /**
	 * 设置：毕业院校
	 */
    public String getXueliBiyeyuanxiao() {
        return xueliBiyeyuanxiao;
    }


    /**
	 * 获取：毕业院校
	 */

    public void setXueliBiyeyuanxiao(String xueliBiyeyuanxiao) {
        this.xueliBiyeyuanxiao = xueliBiyeyuanxiao;
    }
    /**
	 * 设置：专业
	 */
    public Integer getXueliZhuanyeTypes() {
        return xueliZhuanyeTypes;
    }


    /**
	 * 获取：专业
	 */

    public void setXueliZhuanyeTypes(Integer xueliZhuanyeTypes) {
        this.xueliZhuanyeTypes = xueliZhuanyeTypes;
    }
    /**
	 * 设置：班级
	 */
    public Integer getXueliBanjiTypes() {
        return xueliBanjiTypes;
    }


    /**
	 * 获取：班级
	 */

    public void setXueliBanjiTypes(Integer xueliBanjiTypes) {
        this.xueliBanjiTypes = xueliBanjiTypes;
    }
    /**
	 * 设置：入校年月
	 */
    public String getXueliRuxiaonianyue() {
        return xueliRuxiaonianyue;
    }


    /**
	 * 获取：入校年月
	 */

    public void setXueliRuxiaonianyue(String xueliRuxiaonianyue) {
        this.xueliRuxiaonianyue = xueliRuxiaonianyue;
    }
    /**
	 * 设置：毕业年月
	 */
    public String getXueliBiyenianyue() {
        return xueliBiyenianyue;
    }


    /**
	 * 获取：毕业年月
	 */

    public void setXueliBiyenianyue(String xueliBiyenianyue) {
        this.xueliBiyenianyue = xueliBiyenianyue;
    }
    /**
	 * 设置：成分
	 */
    public Integer getXueliChengfenTypes() {
        return xueliChengfenTypes;
    }


    /**
	 * 获取：成分
	 */

    public void setXueliChengfenTypes(Integer xueliChengfenTypes) {
        this.xueliChengfenTypes = xueliChengfenTypes;
    }
    /**
	 * 设置：联系方式
	 */
    public String getXueliLianxifangshiPhone() {
        return xueliLianxifangshiPhone;
    }


    /**
	 * 获取：联系方式
	 */

    public void setXueliLianxifangshiPhone(String xueliLianxifangshiPhone) {
        this.xueliLianxifangshiPhone = xueliLianxifangshiPhone;
    }
    /**
	 * 设置：审核状态
	 */
    public Integer getXueliYesnoTypes() {
        return xueliYesnoTypes;
    }


    /**
	 * 获取：审核状态
	 */

    public void setXueliYesnoTypes(Integer xueliYesnoTypes) {
        this.xueliYesnoTypes = xueliYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getXueliYesnoText() {
        return xueliYesnoText;
    }


    /**
	 * 获取：审核意见
	 */

    public void setXueliYesnoText(String xueliYesnoText) {
        this.xueliYesnoText = xueliYesnoText;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getXueliDelete() {
        return xueliDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setXueliDelete(Integer xueliDelete) {
        this.xueliDelete = xueliDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
