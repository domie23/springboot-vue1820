package com.entity.model;

import com.entity.QianyuedanweiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 签约单位
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class QianyuedanweiModel implements Serializable {
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
     * 签约编号
     */
    private String qianyuedanweiUuidNumber;


    /**
     * 单位名称
     */
    private String qianyuedanweiName;


    /**
     * 单位地址
     */
    private String qianyuedanweiAddress;


    /**
     * 部门
     */
    private Integer qianyuedanweiBumenTypes;


    /**
     * 职位
     */
    private Integer qianyuedanweiZhiweiTypes;


    /**
     * 月薪
     */
    private Double qianyuedanweiYuexin;


    /**
     * 合同文件
     */
    private String qianyuedanweiFile;


    /**
     * 签约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date qianyueTime;


    /**
     * 合同开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date qianyueKaishiTime;


    /**
     * 合同结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date qianyueJieshuTime;


    /**
     * 签约备注
     */
    private String qianyuedanweiContent;


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
	 * 获取：签约编号
	 */
    public String getQianyuedanweiUuidNumber() {
        return qianyuedanweiUuidNumber;
    }


    /**
	 * 设置：签约编号
	 */
    public void setQianyuedanweiUuidNumber(String qianyuedanweiUuidNumber) {
        this.qianyuedanweiUuidNumber = qianyuedanweiUuidNumber;
    }
    /**
	 * 获取：单位名称
	 */
    public String getQianyuedanweiName() {
        return qianyuedanweiName;
    }


    /**
	 * 设置：单位名称
	 */
    public void setQianyuedanweiName(String qianyuedanweiName) {
        this.qianyuedanweiName = qianyuedanweiName;
    }
    /**
	 * 获取：单位地址
	 */
    public String getQianyuedanweiAddress() {
        return qianyuedanweiAddress;
    }


    /**
	 * 设置：单位地址
	 */
    public void setQianyuedanweiAddress(String qianyuedanweiAddress) {
        this.qianyuedanweiAddress = qianyuedanweiAddress;
    }
    /**
	 * 获取：部门
	 */
    public Integer getQianyuedanweiBumenTypes() {
        return qianyuedanweiBumenTypes;
    }


    /**
	 * 设置：部门
	 */
    public void setQianyuedanweiBumenTypes(Integer qianyuedanweiBumenTypes) {
        this.qianyuedanweiBumenTypes = qianyuedanweiBumenTypes;
    }
    /**
	 * 获取：职位
	 */
    public Integer getQianyuedanweiZhiweiTypes() {
        return qianyuedanweiZhiweiTypes;
    }


    /**
	 * 设置：职位
	 */
    public void setQianyuedanweiZhiweiTypes(Integer qianyuedanweiZhiweiTypes) {
        this.qianyuedanweiZhiweiTypes = qianyuedanweiZhiweiTypes;
    }
    /**
	 * 获取：月薪
	 */
    public Double getQianyuedanweiYuexin() {
        return qianyuedanweiYuexin;
    }


    /**
	 * 设置：月薪
	 */
    public void setQianyuedanweiYuexin(Double qianyuedanweiYuexin) {
        this.qianyuedanweiYuexin = qianyuedanweiYuexin;
    }
    /**
	 * 获取：合同文件
	 */
    public String getQianyuedanweiFile() {
        return qianyuedanweiFile;
    }


    /**
	 * 设置：合同文件
	 */
    public void setQianyuedanweiFile(String qianyuedanweiFile) {
        this.qianyuedanweiFile = qianyuedanweiFile;
    }
    /**
	 * 获取：签约时间
	 */
    public Date getQianyueTime() {
        return qianyueTime;
    }


    /**
	 * 设置：签约时间
	 */
    public void setQianyueTime(Date qianyueTime) {
        this.qianyueTime = qianyueTime;
    }
    /**
	 * 获取：合同开始时间
	 */
    public Date getQianyueKaishiTime() {
        return qianyueKaishiTime;
    }


    /**
	 * 设置：合同开始时间
	 */
    public void setQianyueKaishiTime(Date qianyueKaishiTime) {
        this.qianyueKaishiTime = qianyueKaishiTime;
    }
    /**
	 * 获取：合同结束时间
	 */
    public Date getQianyueJieshuTime() {
        return qianyueJieshuTime;
    }


    /**
	 * 设置：合同结束时间
	 */
    public void setQianyueJieshuTime(Date qianyueJieshuTime) {
        this.qianyueJieshuTime = qianyueJieshuTime;
    }
    /**
	 * 获取：签约备注
	 */
    public String getQianyuedanweiContent() {
        return qianyuedanweiContent;
    }


    /**
	 * 设置：签约备注
	 */
    public void setQianyuedanweiContent(String qianyuedanweiContent) {
        this.qianyuedanweiContent = qianyuedanweiContent;
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
