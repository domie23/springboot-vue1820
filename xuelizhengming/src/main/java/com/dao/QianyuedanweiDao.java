package com.dao;

import com.entity.QianyuedanweiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.QianyuedanweiView;

/**
 * 签约单位 Dao 接口
 *
 * @author 
 */
public interface QianyuedanweiDao extends BaseMapper<QianyuedanweiEntity> {

   List<QianyuedanweiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
