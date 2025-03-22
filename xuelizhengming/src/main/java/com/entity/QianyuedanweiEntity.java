package com.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * 签约单位
 *
 * @author 
 * @email
 */
@TableName("qianyuedanwei")
public class QianyuedanweiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public QianyuedanweiEntity() {

	}

	public QianyuedanweiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 签约编号
     */
    @TableField(value = "qianyuedanwei_uuid_number")

    private String qianyuedanweiUuidNumber;


    /**
     * 单位名称
     */
    @TableField(value = "qianyuedanwei_name")

    private String qianyuedanweiName;


    /**
     * 单位地址
     */
    @TableField(value = "qianyuedanwei_address")

    private String qianyuedanweiAddress;


    /**
     * 部门
     */
    @TableField(value = "qianyuedanwei_bumen_types")

    private Integer qianyuedanweiBumenTypes;


    /**
     * 职位
     */
    @TableField(value = "qianyuedanwei_zhiwei_types")

    private Integer qianyuedanweiZhiweiTypes;


    /**
     * 月薪
     */
    @TableField(value = "qianyuedanwei_yuexin")

    private Double qianyuedanweiYuexin;


    /**
     * 合同文件
     */
    @TableField(value = "qianyuedanwei_file")

    private String qianyuedanweiFile;


    /**
     * 签约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "qianyue_time")

    private Date qianyueTime;


    /**
     * 合同开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "qianyue_kaishi_time")

    private Date qianyueKaishiTime;


    /**
     * 合同结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "qianyue_jieshu_time")

    private Date qianyueJieshuTime;


    /**
     * 签约备注
     */
    @TableField(value = "qianyuedanwei_content")

    private String qianyuedanweiContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：签约编号
	 */
    public String getQianyuedanweiUuidNumber() {
        return qianyuedanweiUuidNumber;
    }
    /**
	 * 获取：签约编号
	 */

    public void setQianyuedanweiUuidNumber(String qianyuedanweiUuidNumber) {
        this.qianyuedanweiUuidNumber = qianyuedanweiUuidNumber;
    }
    /**
	 * 设置：单位名称
	 */
    public String getQianyuedanweiName() {
        return qianyuedanweiName;
    }
    /**
	 * 获取：单位名称
	 */

    public void setQianyuedanweiName(String qianyuedanweiName) {
        this.qianyuedanweiName = qianyuedanweiName;
    }
    /**
	 * 设置：单位地址
	 */
    public String getQianyuedanweiAddress() {
        return qianyuedanweiAddress;
    }
    /**
	 * 获取：单位地址
	 */

    public void setQianyuedanweiAddress(String qianyuedanweiAddress) {
        this.qianyuedanweiAddress = qianyuedanweiAddress;
    }
    /**
	 * 设置：部门
	 */
    public Integer getQianyuedanweiBumenTypes() {
        return qianyuedanweiBumenTypes;
    }
    /**
	 * 获取：部门
	 */

    public void setQianyuedanweiBumenTypes(Integer qianyuedanweiBumenTypes) {
        this.qianyuedanweiBumenTypes = qianyuedanweiBumenTypes;
    }
    /**
	 * 设置：职位
	 */
    public Integer getQianyuedanweiZhiweiTypes() {
        return qianyuedanweiZhiweiTypes;
    }
    /**
	 * 获取：职位
	 */

    public void setQianyuedanweiZhiweiTypes(Integer qianyuedanweiZhiweiTypes) {
        this.qianyuedanweiZhiweiTypes = qianyuedanweiZhiweiTypes;
    }
    /**
	 * 设置：月薪
	 */
    public Double getQianyuedanweiYuexin() {
        return qianyuedanweiYuexin;
    }
    /**
	 * 获取：月薪
	 */

    public void setQianyuedanweiYuexin(Double qianyuedanweiYuexin) {
        this.qianyuedanweiYuexin = qianyuedanweiYuexin;
    }
    /**
	 * 设置：合同文件
	 */
    public String getQianyuedanweiFile() {
        return qianyuedanweiFile;
    }
    /**
	 * 获取：合同文件
	 */

    public void setQianyuedanweiFile(String qianyuedanweiFile) {
        this.qianyuedanweiFile = qianyuedanweiFile;
    }
    /**
	 * 设置：签约时间
	 */
    public Date getQianyueTime() {
        return qianyueTime;
    }
    /**
	 * 获取：签约时间
	 */

    public void setQianyueTime(Date qianyueTime) {
        this.qianyueTime = qianyueTime;
    }
    /**
	 * 设置：合同开始时间
	 */
    public Date getQianyueKaishiTime() {
        return qianyueKaishiTime;
    }
    /**
	 * 获取：合同开始时间
	 */

    public void setQianyueKaishiTime(Date qianyueKaishiTime) {
        this.qianyueKaishiTime = qianyueKaishiTime;
    }
    /**
	 * 设置：合同结束时间
	 */
    public Date getQianyueJieshuTime() {
        return qianyueJieshuTime;
    }
    /**
	 * 获取：合同结束时间
	 */

    public void setQianyueJieshuTime(Date qianyueJieshuTime) {
        this.qianyueJieshuTime = qianyueJieshuTime;
    }
    /**
	 * 设置：签约备注
	 */
    public String getQianyuedanweiContent() {
        return qianyuedanweiContent;
    }
    /**
	 * 获取：签约备注
	 */

    public void setQianyuedanweiContent(String qianyuedanweiContent) {
        this.qianyuedanweiContent = qianyuedanweiContent;
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

    @Override
    public String toString() {
        return "Qianyuedanwei{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", qianyuedanweiUuidNumber=" + qianyuedanweiUuidNumber +
            ", qianyuedanweiName=" + qianyuedanweiName +
            ", qianyuedanweiAddress=" + qianyuedanweiAddress +
            ", qianyuedanweiBumenTypes=" + qianyuedanweiBumenTypes +
            ", qianyuedanweiZhiweiTypes=" + qianyuedanweiZhiweiTypes +
            ", qianyuedanweiYuexin=" + qianyuedanweiYuexin +
            ", qianyuedanweiFile=" + qianyuedanweiFile +
            ", qianyueTime=" + qianyueTime +
            ", qianyueKaishiTime=" + qianyueKaishiTime +
            ", qianyueJieshuTime=" + qianyueJieshuTime +
            ", qianyuedanweiContent=" + qianyuedanweiContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
