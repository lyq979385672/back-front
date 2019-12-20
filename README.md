# back-front
基于VUE和Springboot前后端分离的一个简单DEMO


##前端VUE配置

1、为了省事，直接npm安装一个vue-cli的脚手架；

2、然后vue init webpack javalsj-vue新建一个vue项目；

3、在src文件中新建一个login.vue文件，写好登录界面，约定的接口是前端发送表单里的username和password字段，然后后端返回状态码和消息字段；

4、由于需要用到axios，在main.s中进行声明；

    var axios = require('axios')
    axios.defaults.baseURL = 'http://localhost:8443/api'
    // 全局注册，之后可在其他组件中通过 this.$axios 发送数据
    Vue.prototype.$axios = axios
    Vue.config.productionTip = false
    
5、配置路由，修改src\router\index.js：

6、在config\index.js proxyTable下进行跨域配置：

    proxyTable: {
      '/api': {
        target: 'http://localhost:8443',
        changeOrigin: true,
        pathRewrite: {
          '^/api': ''
        }
      }
    }
    
7、npm dev run命令运行，然后打开localhost:8080/#/login查看效果

##后端springboot配置

1、后端配置比较简单，新建一个maven工程，然后java目录下新建controller文件夹，处理逻辑；同时配置文件里设置端口为8443；

2、UserController中加@CrossOrigin注解处理跨域，加responsebody将返回信息处理为json格式；

3、新建user和result两个实体类，用于表示接收到的用户信息，和返回给前端的消息；

4、登录处理逻辑为，如果用户名或密码为空，将result中的message=""用户名或密码不能为空"返回前端；
如用户名或密码错误，同样返回； 成功登录后，转入hello world界面！