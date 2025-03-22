package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.ZhuanjiediEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * 转接地
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("zhuanjiedi")
public class ZhuanjiediView extends ZhuanjiediEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 转接地类型的值
		*/
		private String zhuanjiediValue;
		/**
		* 二级类型的值
		*/
		private String zhuanjiediErjiValue;



	public ZhuanjiediView() {

	}

	public ZhuanjiediView(ZhuanjiediEntity zhuanjiediEntity) {
		try {
			BeanUtils.copyProperties(this, zhuanjiediEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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








}
