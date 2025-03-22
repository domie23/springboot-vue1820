package com.dao;

import com.entity.ZhuanjiediEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhuanjiediView;

/**
 * 转接地 Dao 接口
 *
 * @author 
 */
public interface ZhuanjiediDao extends BaseMapper<ZhuanjiediEntity> {

   List<ZhuanjiediView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
