import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import qianyuedanwei from '@/views/modules/qianyuedanwei/list'
    import xueli from '@/views/modules/xueli/list'
    import yonghu from '@/views/modules/yonghu/list'
    import zhuanjiedi from '@/views/modules/zhuanjiedi/list'
    import dictionaryQianyuedanweiBumen from '@/views/modules/dictionaryQianyuedanweiBumen/list'
    import dictionaryQianyuedanweiZhiwei from '@/views/modules/dictionaryQianyuedanweiZhiwei/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryXueliBanji from '@/views/modules/dictionaryXueliBanji/list'
    import dictionaryXueliChengfen from '@/views/modules/dictionaryXueliChengfen/list'
    import dictionaryXueliXuexixingshi from '@/views/modules/dictionaryXueliXuexixingshi/list'
    import dictionaryXueliXuezhi from '@/views/modules/dictionaryXueliXuezhi/list'
    import dictionaryXueliZhuanye from '@/views/modules/dictionaryXueliZhuanye/list'
    import dictionaryXuelixingbie from '@/views/modules/dictionaryXuelixingbie/list'
    import dictionaryXuelixingzhi from '@/views/modules/dictionaryXuelixingzhi/list'
    import dictionaryZhuanjiedi from '@/views/modules/dictionaryZhuanjiedi/list'
    import dictionaryZhuanjiediErji from '@/views/modules/dictionaryZhuanjiediErji/list'
        import dictionaryZhuanjiediErjiAddOrUpdate from '@/views/modules/dictionaryZhuanjiediErji/add-or-update'//二级





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryQianyuedanweiBumen',
        name: '部门',
        component: dictionaryQianyuedanweiBumen
    }
    ,{
        path: '/dictionaryQianyuedanweiZhiwei',
        name: '职位',
        component: dictionaryQianyuedanweiZhiwei
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryXueliBanji',
        name: '班级',
        component: dictionaryXueliBanji
    }
    ,{
        path: '/dictionaryXueliChengfen',
        name: '成分',
        component: dictionaryXueliChengfen
    }
    ,{
        path: '/dictionaryXueliXuexixingshi',
        name: '学习形式',
        component: dictionaryXueliXuexixingshi
    }
    ,{
        path: '/dictionaryXueliXuezhi',
        name: '学制',
        component: dictionaryXueliXuezhi
    }
    ,{
        path: '/dictionaryXueliZhuanye',
        name: '专业',
        component: dictionaryXueliZhuanye
    }
    ,{
        path: '/dictionaryXuelixingbie',
        name: '性别',
        component: dictionaryXuelixingbie
    }
    ,{
        path: '/dictionaryXuelixingzhi',
        name: '学历性质',
        component: dictionaryXuelixingzhi
    }
    ,{
        path: '/dictionaryZhuanjiedi',
        name: '转接地类型',
        component: dictionaryZhuanjiedi
    }
    ,{
        path: '/dictionaryZhuanjiediErji',
        name: '二级类型',
        component: dictionaryZhuanjiediErji
    }
    ,{
        path: '/dictionaryZhuanjiediErjiAddOrUpdate',
        name: '二级类型的新增修改页面',
        component: dictionaryZhuanjiediErjiAddOrUpdate
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/qianyuedanwei',
        name: '签约单位',
        component: qianyuedanwei
      }
    ,{
        path: '/xueli',
        name: '学历',
        component: xueli
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }
    ,{
        path: '/zhuanjiedi',
        name: '转接地',
        component: zhuanjiedi
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
