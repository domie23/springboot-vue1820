package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.XueliEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * 学历
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xueli")
public class XueliView extends XueliEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 性别的值
		*/
		private String xuelixingbieValue;
		/**
		* 学历性质的值
		*/
		private String xuelixingzhiValue;
		/**
		* 学制的值
		*/
		private String xueliXuezhiValue;
		/**
		* 学习形式的值
		*/
		private String xueliXuexixingshiValue;
		/**
		* 专业的值
		*/
		private String xueliZhuanyeValue;
		/**
		* 班级的值
		*/
		private String xueliBanjiValue;
		/**
		* 成分的值
		*/
		private String xueliChengfenValue;
		/**
		* 审核状态的值
		*/
		private String xueliYesnoValue;



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

		//级联表 zhuanjiedi
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
				* 转接地类型的值
				*/
				private String zhuanjiediValue;
			/**
			* 二级类型
			*/
			private Integer zhuanjiediErjiTypes;
				/**
				* 二级类型的值
				*/
				private String zhuanjiediErjiValue;
			/**
			* 转接地详情
			*/
			private String zhuanjiediContent;
			/**
			* 签约备注
			*/
			private String shangdianShouyinContent;

	public XueliView() {

	}

	public XueliView(XueliEntity xueliEntity) {
		try {
			BeanUtils.copyProperties(this, xueliEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 性别的值
			*/
			public String getXuelixingbieValue() {
				return xuelixingbieValue;
			}
			/**
			* 设置： 性别的值
			*/
			public void setXuelixingbieValue(String xuelixingbieValue) {
				this.xuelixingbieValue = xuelixingbieValue;
			}
			/**
			* 获取： 学历性质的值
			*/
			public String getXuelixingzhiValue() {
				return xuelixingzhiValue;
			}
			/**
			* 设置： 学历性质的值
			*/
			public void setXuelixingzhiValue(String xuelixingzhiValue) {
				this.xuelixingzhiValue = xuelixingzhiValue;
			}
			/**
			* 获取： 学制的值
			*/
			public String getXueliXuezhiValue() {
				return xueliXuezhiValue;
			}
			/**
			* 设置： 学制的值
			*/
			public void setXueliXuezhiValue(String xueliXuezhiValue) {
				this.xueliXuezhiValue = xueliXuezhiValue;
			}
			/**
			* 获取： 学习形式的值
			*/
			public String getXueliXuexixingshiValue() {
				return xueliXuexixingshiValue;
			}
			/**
			* 设置： 学习形式的值
			*/
			public void setXueliXuexixingshiValue(String xueliXuexixingshiValue) {
				this.xueliXuexixingshiValue = xueliXuexixingshiValue;
			}
			/**
			* 获取： 专业的值
			*/
			public String getXueliZhuanyeValue() {
				return xueliZhuanyeValue;
			}
			/**
			* 设置： 专业的值
			*/
			public void setXueliZhuanyeValue(String xueliZhuanyeValue) {
				this.xueliZhuanyeValue = xueliZhuanyeValue;
			}
			/**
			* 获取： 班级的值
			*/
			public String getXueliBanjiValue() {
				return xueliBanjiValue;
			}
			/**
			* 设置： 班级的值
			*/
			public void setXueliBanjiValue(String xueliBanjiValue) {
				this.xueliBanjiValue = xueliBanjiValue;
			}
			/**
			* 获取： 成分的值
			*/
			public String getXueliChengfenValue() {
				return xueliChengfenValue;
			}
			/**
			* 设置： 成分的值
			*/
			public void setXueliChengfenValue(String xueliChengfenValue) {
				this.xueliChengfenValue = xueliChengfenValue;
			}
			/**
			* 获取： 审核状态的值
			*/
			public String getXueliYesnoValue() {
				return xueliYesnoValue;
			}
			/**
			* 设置： 审核状态的值
			*/
			public void setXueliYesnoValue(String xueliYesnoValue) {
				this.xueliYesnoValue = xueliYesnoValue;
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




				//级联表的get和set zhuanjiedi

					/**
					* 获取： 转接地编号
					*/
					public String getZhuanjiediUuidNumber() {
						return zhuanjiediUuidNumber;
					}
					/**
					* 设置： 转接地编号
					*/
					public void setZhuanjiediUuidNumber(String zhuanjiediUuidNumber) {
						this.zhuanjiediUuidNumber = zhuanjiediUuidNumber;
					}

					/**
					* 获取： 转接地名称
					*/
					public String getZhuanjiediName() {
						return zhuanjiediName;
					}
					/**
					* 设置： 转接地名称
					*/
					public void setZhuanjiediName(String zhuanjiediName) {
						this.zhuanjiediName = zhuanjiediName;
					}

					/**
					* 获取： 转接地地址
					*/
					public String getZhuanjiediAddress() {
						return zhuanjiediAddress;
					}
					/**
					* 设置： 转接地地址
					*/
					public void setZhuanjiediAddress(String zhuanjiediAddress) {
						this.zhuanjiediAddress = zhuanjiediAddress;
					}

					/**
					* 获取： 转接地类型
					*/
					public Integer getZhuanjiediTypes() {
						return zhuanjiediTypes;
					}
					/**
					* 设置： 转接地类型
					*/
					public void setZhuanjiediTypes(Integer zhuanjiediTypes) {
						this.zhuanjiediTypes = zhuanjiediTypes;
					}


						/**
						* 获取： 转接地类型的值
						*/
						public String getZhuanjiediValue() {
							return zhuanjiediValue;
						}
						/**
						* 设置： 转接地类型的值
						*/
						public void setZhuanjiediValue(String zhuanjiediValue) {
							this.zhuanjiediValue = zhuanjiediValue;
						}

					/**
					* 获取： 二级类型
					*/
					public Integer getZhuanjiediErjiTypes() {
						return zhuanjiediErjiTypes;
					}
					/**
					* 设置： 二级类型
					*/
					public void setZhuanjiediErjiTypes(Integer zhuanjiediErjiTypes) {
						this.zhuanjiediErjiTypes = zhuanjiediErjiTypes;
					}


						/**
						* 获取： 二级类型的值
						*/
						public String getZhuanjiediErjiValue() {
							return zhuanjiediErjiValue;
						}
						/**
						* 设置： 二级类型的值
						*/
						public void setZhuanjiediErjiValue(String zhuanjiediErjiValue) {
							this.zhuanjiediErjiValue = zhuanjiediErjiValue;
						}

					/**
					* 获取： 转接地详情
					*/
					public String getZhuanjiediContent() {
						return zhuanjiediContent;
					}
					/**
					* 设置： 转接地详情
					*/
					public void setZhuanjiediContent(String zhuanjiediContent) {
						this.zhuanjiediContent = zhuanjiediContent;
					}

					/**
					* 获取： 签约备注
					*/
					public String getShangdianShouyinContent() {
						return shangdianShouyinContent;
					}
					/**
					* 设置： 签约备注
					*/
					public void setShangdianShouyinContent(String shangdianShouyinContent) {
						this.shangdianShouyinContent = shangdianShouyinContent;
					}



}
