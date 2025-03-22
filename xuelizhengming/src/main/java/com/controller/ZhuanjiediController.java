
package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.ZhuanjiediEntity;
import com.entity.view.ZhuanjiediView;
import com.service.DictionaryService;
import com.service.TokenService;
import com.service.YonghuService;
import com.service.ZhuanjiediService;
import com.utils.PageUtils;
import com.utils.PoiUtil;
import com.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 转接地
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhuanjiedi")
public class ZhuanjiediController {
    private static final Logger logger = LoggerFactory.getLogger(ZhuanjiediController.class);

    @Autowired
    private ZhuanjiediService zhuanjiediService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = zhuanjiediService.queryPage(params);

        //字典表数据转换
        List<ZhuanjiediView> list =(List<ZhuanjiediView>)page.getList();
        for(ZhuanjiediView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZhuanjiediEntity zhuanjiedi = zhuanjiediService.selectById(id);
        if(zhuanjiedi !=null){
            //entity转view
            ZhuanjiediView view = new ZhuanjiediView();
            BeanUtils.copyProperties( zhuanjiedi , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ZhuanjiediEntity zhuanjiedi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhuanjiedi:{}",this.getClass().getName(),zhuanjiedi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ZhuanjiediEntity> queryWrapper = new EntityWrapper<ZhuanjiediEntity>()
            .eq("zhuanjiedi_uuid_number", zhuanjiedi.getZhuanjiediUuidNumber())
            .eq("zhuanjiedi_name", zhuanjiedi.getZhuanjiediName())
            .eq("zhuanjiedi_address", zhuanjiedi.getZhuanjiediAddress())
            .eq("zhuanjiedi_types", zhuanjiedi.getZhuanjiediTypes())
            .eq("zhuanjiedi_erji_types", zhuanjiedi.getZhuanjiediErjiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhuanjiediEntity zhuanjiediEntity = zhuanjiediService.selectOne(queryWrapper);
        if(zhuanjiediEntity==null){
            zhuanjiedi.setInsertTime(new Date());
            zhuanjiedi.setCreateTime(new Date());
            zhuanjiediService.insert(zhuanjiedi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhuanjiediEntity zhuanjiedi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,zhuanjiedi:{}",this.getClass().getName(),zhuanjiedi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<ZhuanjiediEntity> queryWrapper = new EntityWrapper<ZhuanjiediEntity>()
            .notIn("id",zhuanjiedi.getId())
            .andNew()
            .eq("zhuanjiedi_uuid_number", zhuanjiedi.getZhuanjiediUuidNumber())
            .eq("zhuanjiedi_name", zhuanjiedi.getZhuanjiediName())
            .eq("zhuanjiedi_address", zhuanjiedi.getZhuanjiediAddress())
            .eq("zhuanjiedi_types", zhuanjiedi.getZhuanjiediTypes())
            .eq("zhuanjiedi_erji_types", zhuanjiedi.getZhuanjiediErjiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhuanjiediEntity zhuanjiediEntity = zhuanjiediService.selectOne(queryWrapper);
        if(zhuanjiediEntity==null){
            zhuanjiediService.updateById(zhuanjiedi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        zhuanjiediService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save(String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<ZhuanjiediEntity> zhuanjiediList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ZhuanjiediEntity zhuanjiediEntity = new ZhuanjiediEntity();
//                            zhuanjiediEntity.setZhuanjiediUuidNumber(data.get(0));                    //转接地编号 要改的
//                            zhuanjiediEntity.setZhuanjiediName(data.get(0));                    //转接地名称 要改的
//                            zhuanjiediEntity.setZhuanjiediAddress(data.get(0));                    //转接地地址 要改的
//                            zhuanjiediEntity.setZhuanjiediTypes(Integer.valueOf(data.get(0)));   //转接地类型 要改的
//                            zhuanjiediEntity.setZhuanjiediErjiTypes(Integer.valueOf(data.get(0)));   //二级类型 要改的
//                            zhuanjiediEntity.setZhuanjiediContent("");//详情和图片
//                            zhuanjiediEntity.setShangdianShouyinContent("");//详情和图片
//                            zhuanjiediEntity.setInsertTime(date);//时间
//                            zhuanjiediEntity.setCreateTime(date);//时间
                            zhuanjiediList.add(zhuanjiediEntity);


                            //把要查询是否重复的字段放入map中
                                //转接地编号
                                if(seachFields.containsKey("zhuanjiediUuidNumber")){
                                    List<String> zhuanjiediUuidNumber = seachFields.get("zhuanjiediUuidNumber");
                                    zhuanjiediUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> zhuanjiediUuidNumber = new ArrayList<>();
                                    zhuanjiediUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("zhuanjiediUuidNumber",zhuanjiediUuidNumber);
                                }
                        }

                        //查询是否重复
                         //转接地编号
                        List<ZhuanjiediEntity> zhuanjiediEntities_zhuanjiediUuidNumber = zhuanjiediService.selectList(new EntityWrapper<ZhuanjiediEntity>().in("zhuanjiedi_uuid_number", seachFields.get("zhuanjiediUuidNumber")));
                        if(zhuanjiediEntities_zhuanjiediUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhuanjiediEntity s:zhuanjiediEntities_zhuanjiediUuidNumber){
                                repeatFields.add(s.getZhuanjiediUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [转接地编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zhuanjiediService.insertBatch(zhuanjiediList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
