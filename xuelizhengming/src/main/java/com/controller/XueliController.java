
package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.XueliEntity;
import com.entity.YonghuEntity;
import com.entity.ZhuanjiediEntity;
import com.entity.view.XueliView;
import com.service.*;
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
 * 学历
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xueli")
public class XueliController {
    private static final Logger logger = LoggerFactory.getLogger(XueliController.class);

    @Autowired
    private XueliService xueliService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private ZhuanjiediService zhuanjiediService;



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
        params.put("xueliDeleteStart",1);params.put("xueliDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = xueliService.queryPage(params);

        //字典表数据转换
        List<XueliView> list =(List<XueliView>)page.getList();
        for(XueliView c:list){
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
        XueliEntity xueli = xueliService.selectById(id);
        if(xueli !=null){
            //entity转view
            XueliView view = new XueliView();
            BeanUtils.copyProperties( xueli , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(xueli.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                ZhuanjiediEntity zhuanjiedi = zhuanjiediService.selectById(xueli.getZhuanjiediId());
                if(zhuanjiedi != null){
                    BeanUtils.copyProperties( zhuanjiedi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setZhuanjiediId(zhuanjiedi.getId());
                }
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
    public R save(@RequestBody XueliEntity xueli, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xueli:{}",this.getClass().getName(),xueli.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            xueli.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<XueliEntity> queryWrapper = new EntityWrapper<XueliEntity>()
            .eq("yonghu_id", xueli.getYonghuId())
            .eq("zhuanjiedi_id", xueli.getZhuanjiediId())
            .eq("xueli_uuid_number", xueli.getXueliUuidNumber())
            .eq("xueli_name", xueli.getXueliName())
            .eq("xueli_id_number", xueli.getXueliIdNumber())
            .eq("xueli_zhengshu_number", xueli.getXueliZhengshuNumber())
            .eq("xueli_renzhengbianhao_number", xueli.getXueliRenzhengbianhaoNumber())
            .eq("xuelixingbie_types", xueli.getXuelixingbieTypes())
            .eq("xueli_chushengnianyue", xueli.getXueliChushengnianyue())
            .eq("xueli_guoji", xueli.getXueliGuoji())
            .eq("xueli_minzu", xueli.getXueliMinzu())
            .eq("xuelixingzhi_types", xueli.getXuelixingzhiTypes())
            .eq("xueli_xuezhi_types", xueli.getXueliXuezhiTypes())
            .eq("xueli_xuexixingshi_types", xueli.getXueliXuexixingshiTypes())
            .eq("xueli_biyeyuanxiao", xueli.getXueliBiyeyuanxiao())
            .eq("xueli_zhuanye_types", xueli.getXueliZhuanyeTypes())
            .eq("xueli_banji_types", xueli.getXueliBanjiTypes())
            .eq("xueli_ruxiaonianyue", xueli.getXueliRuxiaonianyue())
            .eq("xueli_biyenianyue", xueli.getXueliBiyenianyue())
            .eq("xueli_chengfen_types", xueli.getXueliChengfenTypes())
            .eq("xueli_lianxifangshi_phone", xueli.getXueliLianxifangshiPhone())
            .eq("xueli_yesno_types", xueli.getXueliYesnoTypes())
            .eq("xueli_yesno_text", xueli.getXueliYesnoText())
            .eq("xueli_delete", xueli.getXueliDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XueliEntity xueliEntity = xueliService.selectOne(queryWrapper);
        if(xueliEntity==null){
            xueli.setXueliDelete(1);
            xueli.setInsertTime(new Date());
            xueli.setCreateTime(new Date());
            xueliService.insert(xueli);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XueliEntity xueli, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xueli:{}",this.getClass().getName(),xueli.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            xueli.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<XueliEntity> queryWrapper = new EntityWrapper<XueliEntity>()
            .notIn("id",xueli.getId())
            .andNew()
            .eq("yonghu_id", xueli.getYonghuId())
            .eq("zhuanjiedi_id", xueli.getZhuanjiediId())
            .eq("xueli_uuid_number", xueli.getXueliUuidNumber())
            .eq("xueli_name", xueli.getXueliName())
            .eq("xueli_id_number", xueli.getXueliIdNumber())
            .eq("xueli_zhengshu_number", xueli.getXueliZhengshuNumber())
            .eq("xueli_renzhengbianhao_number", xueli.getXueliRenzhengbianhaoNumber())
            .eq("xuelixingbie_types", xueli.getXuelixingbieTypes())
            .eq("xueli_chushengnianyue", xueli.getXueliChushengnianyue())
            .eq("xueli_guoji", xueli.getXueliGuoji())
            .eq("xueli_minzu", xueli.getXueliMinzu())
            .eq("xuelixingzhi_types", xueli.getXuelixingzhiTypes())
            .eq("xueli_xuezhi_types", xueli.getXueliXuezhiTypes())
            .eq("xueli_xuexixingshi_types", xueli.getXueliXuexixingshiTypes())
            .eq("xueli_biyeyuanxiao", xueli.getXueliBiyeyuanxiao())
            .eq("xueli_zhuanye_types", xueli.getXueliZhuanyeTypes())
            .eq("xueli_banji_types", xueli.getXueliBanjiTypes())
            .eq("xueli_ruxiaonianyue", xueli.getXueliRuxiaonianyue())
            .eq("xueli_biyenianyue", xueli.getXueliBiyenianyue())
            .eq("xueli_chengfen_types", xueli.getXueliChengfenTypes())
            .eq("xueli_lianxifangshi_phone", xueli.getXueliLianxifangshiPhone())
            .eq("xueli_yesno_types", xueli.getXueliYesnoTypes())
            .eq("xueli_yesno_text", xueli.getXueliYesnoText())
            .eq("xueli_delete", xueli.getXueliDelete())
            .eq("insert_time", xueli.getInsertTime())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XueliEntity xueliEntity = xueliService.selectOne(queryWrapper);
        if("".equals(xueli.getZhengjianPhoto()) || "null".equals(xueli.getZhengjianPhoto())){
                xueli.setZhengjianPhoto(null);
        }
        if(xueliEntity==null){
            xueliService.updateById(xueli);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 后端修改
    */
    @RequestMapping("/qianyue")
    public R qianyue(@RequestBody XueliEntity xueli, HttpServletRequest request){
        logger.debug("qianyue方法:,,Controller:{},,xueli:{}",this.getClass().getName(),xueli.toString());
        xueli.setXueliYesnoTypes(1);
        xueliService.updateById(xueli);//根据id更新
        return R.ok();
    }


    /**
    * 后端修改
    */
    @RequestMapping("/xuelirenzheng")
    public R xuelirenzheng(@RequestBody XueliEntity xueli, HttpServletRequest request){
        logger.debug("xuelirenzheng方法:,,Controller:{},,xueli:{}",this.getClass().getName(),xueli.toString());


        XueliEntity xueliEntity = xueliService.selectById(xueli.getId());
        if(xueliEntity == null)
            return R.error("查不到学历");
        if(!xueliEntity.getXueliIdNumber().equals(xueli.getXueliIdNumber()))
            return R.error("认证失败");
        if(!xueliEntity.getXueliZhengshuNumber().equals(xueli.getXueliZhengshuNumber()))
            return R.error("认证失败");
        if(!xueliEntity.getXueliRenzhengbianhaoNumber().equals(xueli.getXueliRenzhengbianhaoNumber()))
            return R.error("认证失败");

        xueliEntity.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        xueliService.updateById(xueliEntity);//根据id更新
        return R.ok();

    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<XueliEntity> list = new ArrayList<>();
        for(Integer id:ids){
            XueliEntity xueliEntity = new XueliEntity();
            xueliEntity.setId(id);
            xueliEntity.setXueliDelete(2);
            list.add(xueliEntity);
        }
        if(list != null && list.size() >0){
            xueliService.updateBatchById(list);
        }
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
            List<XueliEntity> xueliList = new ArrayList<>();//上传的东西
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
                            XueliEntity xueliEntity = new XueliEntity();
//                            xueliEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            xueliEntity.setZhuanjiediId(Integer.valueOf(data.get(0)));   //转接地 要改的
//                            xueliEntity.setXueliUuidNumber(data.get(0));                    //学历编号 要改的
//                            xueliEntity.setZhengjianPhoto("");//详情和图片
//                            xueliEntity.setXueliName(data.get(0));                    //姓名 要改的
//                            xueliEntity.setXueliIdNumber(data.get(0));                    //身份证号 要改的
//                            xueliEntity.setXueliZhengshuNumber(data.get(0));                    //证书编号 要改的
//                            xueliEntity.setXueliRenzhengbianhaoNumber(data.get(0));                    //认证编号 要改的
//                            xueliEntity.setXuelixingbieTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            xueliEntity.setXueliChushengnianyue(data.get(0));                    //出生年月 要改的
//                            xueliEntity.setXueliGuoji(data.get(0));                    //国籍 要改的
//                            xueliEntity.setXueliMinzu(data.get(0));                    //民族 要改的
//                            xueliEntity.setXuelixingzhiTypes(Integer.valueOf(data.get(0)));   //学历性质 要改的
//                            xueliEntity.setXueliXuezhiTypes(Integer.valueOf(data.get(0)));   //学制 要改的
//                            xueliEntity.setXueliXuexixingshiTypes(Integer.valueOf(data.get(0)));   //学习形式 要改的
//                            xueliEntity.setXueliBiyeyuanxiao(data.get(0));                    //毕业院校 要改的
//                            xueliEntity.setXueliZhuanyeTypes(Integer.valueOf(data.get(0)));   //专业 要改的
//                            xueliEntity.setXueliBanjiTypes(Integer.valueOf(data.get(0)));   //班级 要改的
//                            xueliEntity.setXueliRuxiaonianyue(data.get(0));                    //入校年月 要改的
//                            xueliEntity.setXueliBiyenianyue(data.get(0));                    //毕业年月 要改的
//                            xueliEntity.setXueliChengfenTypes(Integer.valueOf(data.get(0)));   //成分 要改的
//                            xueliEntity.setXueliLianxifangshiPhone(data.get(0));                    //联系方式 要改的
//                            xueliEntity.setXueliYesnoTypes(Integer.valueOf(data.get(0)));   //审核状态 要改的
//                            xueliEntity.setXueliYesnoText(data.get(0));                    //审核意见 要改的
//                            xueliEntity.setXueliDelete(1);//逻辑删除字段
//                            xueliEntity.setInsertTime(date);//时间
//                            xueliEntity.setCreateTime(date);//时间
                            xueliList.add(xueliEntity);


                            //把要查询是否重复的字段放入map中
                                //学历编号
                                if(seachFields.containsKey("xueliUuidNumber")){
                                    List<String> xueliUuidNumber = seachFields.get("xueliUuidNumber");
                                    xueliUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xueliUuidNumber = new ArrayList<>();
                                    xueliUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xueliUuidNumber",xueliUuidNumber);
                                }
                                //身份证号
                                if(seachFields.containsKey("xueliIdNumber")){
                                    List<String> xueliIdNumber = seachFields.get("xueliIdNumber");
                                    xueliIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xueliIdNumber = new ArrayList<>();
                                    xueliIdNumber.add(data.get(0));//要改的
                                    seachFields.put("xueliIdNumber",xueliIdNumber);
                                }
                        }

                        //查询是否重复
                         //学历编号
                        List<XueliEntity> xueliEntities_xueliUuidNumber = xueliService.selectList(new EntityWrapper<XueliEntity>().in("xueli_uuid_number", seachFields.get("xueliUuidNumber")).eq("xueli_delete", 1));
                        if(xueliEntities_xueliUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XueliEntity s:xueliEntities_xueliUuidNumber){
                                repeatFields.add(s.getXueliUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [学历编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //身份证号
                        List<XueliEntity> xueliEntities_xueliIdNumber = xueliService.selectList(new EntityWrapper<XueliEntity>().in("xueli_id_number", seachFields.get("xueliIdNumber")).eq("xueli_delete", 1));
                        if(xueliEntities_xueliIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XueliEntity s:xueliEntities_xueliIdNumber){
                                repeatFields.add(s.getXueliIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xueliService.insertBatch(xueliList);
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
