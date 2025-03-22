const base = {
    get() {
        return {
            url : "http://localhost:8080/xuelizhengming/",
            name: "xuelizhengming",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/xuelizhengming/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "毕业生学历证明系统"
        } 
    }
}
export default base
