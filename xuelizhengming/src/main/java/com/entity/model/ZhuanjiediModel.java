package com.entity.model;

import com.entity.ZhuanjiediEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 转接地
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhuanjiediModel implements Serializable {
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
     * 转接地编号
     */
    private String zhuanjiediUuidNumber;


    /**
     * 转接地名称
     */
    private String zhuanjiediName;


    /**
     * 转接地地址
     */
    private String zhuanjiediAddress;


    /**
     * 转接地类型
     */
    private Integer zhuanjiediTypes;


    /**
     * 二级类型
     */
    private Integer zhuanjiediErjiTypes;


    /**
     * 转接地详情
     */
    private String zhuanjiediContent;


    /**
     * 签约备注
     */
    private String shangdianShouyinContent;


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
	 * 获取：转接地编号
	 */
    public String getZhuanjiediUuidNumber() {
        return zhuanjiediUuidNumber;
    }


    /**
	 * 设置：转接地编号
	 */
    public void setZhuanjiediUuidNumber(String zhuanjiediUuidNumber) {
        this.zhuanjiediUuidNumber = zhuanjiediUuidNumber;
    }
    /**
	 * 获取：转接地名称
	 */
    public String getZhuanjiediName() {
        return zhuanjiediName;
    }


    /**
	 * 设置：转接地名称
	 */
    public void setZhuanjiediName(String zhuanjiediName) {
        this.zhuanjiediName = zhuanjiediName;
    }
    /**
	 * 获取：转接地地址
	 */
    public String getZhuanjiediAddress() {
        return zhuanjiediAddress;
    }


    /**
	 * 设置：转接地地址
	 */
    public void setZhuanjiediAddress(String zhuanjiediAddress) {
        this.zhuanjiediAddress = zhuanjiediAddress;
    }
    /**
	 * 获取：转接地类型
	 */
    public Integer getZhuanjiediTypes() {
        return zhuanjiediTypes;
    }


    /**
	 * 设置：转接地类型
	 */
    public void setZhuanjiediTypes(Integer zhuanjiediTypes) {
        this.zhuanjiediTypes = zhuanjiediTypes;
    }
    /**
	 * 获取：二级类型
	 */
    public Integer getZhuanjiediErjiTypes() {
        return zhuanjiediErjiTypes;
    }


    /**
	 * 设置：二级类型
	 */
    public void setZhuanjiediErjiTypes(Integer zhuanjiediErjiTypes) {
        this.zhuanjiediErjiTypes = zhuanjiediErjiTypes;
    }
    /**
	 * 获取：转接地详情
	 */
    public String getZhuanjiediContent() {
        return zhuanjiediContent;
    }


    /**
	 * 设置：转接地详情
	 */
    public void setZhuanjiediContent(String zhuanjiediContent) {
        this.zhuanjiediContent = zhuanjiediContent;
    }
    /**
	 * 获取：签约备注
	 */
    public String getShangdianShouyinContent() {
        return shangdianShouyinContent;
    }


    /**
	 * 设置：签约备注
	 */
    public void setShangdianShouyinContent(String shangdianShouyinContent) {
        this.shangdianShouyinContent = shangdianShouyinContent;
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
