package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.QianyuedanweiEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * 签约单位
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("qianyuedanwei")
public class QianyuedanweiView extends QianyuedanweiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 部门的值
		*/
		private String qianyuedanweiBumenValue;
		/**
		* 职位的值
		*/
		private String qianyuedanweiZhiweiValue;



		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;

	public QianyuedanweiView() {

	}

	public QianyuedanweiView(QianyuedanweiEntity qianyuedanweiEntity) {
		try {
			BeanUtils.copyProperties(this, qianyuedanweiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 部门的值
			*/
			public String getQianyuedanweiBumenValue() {
				return qianyuedanweiBumenValue;
			}
			/**
			* 设置： 部门的值
			*/
			public void setQianyuedanweiBumenValue(String qianyuedanweiBumenValue) {
				this.qianyuedanweiBumenValue = qianyuedanweiBumenValue;
			}
			/**
			* 获取： 职位的值
			*/
			public String getQianyuedanweiZhiweiValue() {
				return qianyuedanweiZhiweiValue;
			}
			/**
			* 设置： 职位的值
			*/
			public void setQianyuedanweiZhiweiValue(String qianyuedanweiZhiweiValue) {
				this.qianyuedanweiZhiweiValue = qianyuedanweiZhiweiValue;
			}










				//级联表的get和set yonghu

					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}

					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}




}
