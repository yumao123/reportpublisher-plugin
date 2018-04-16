# 测试报告展示插件
用于产品构建后，在对应左侧菜单栏能查看本次的测试报告

## 如何使用
注：
保证本机已正常配置jdk以及maven的环境
```
mvn -version
```

1.下载代码,在工作目录执行```mvn package```打包,进入工作路径下的target目录,查看是否正确的生成reportpublisher-plugin.hpi

2.打开Jenkins,进入系统 > 插件管理 > 高级,选择该target目录下的reportpublisher-plugin.hpi,点击上传安装
![](https://github.com/yumao123/reportpublisher-plugin/blob/master/src/static/step1.png?raw=true)

3.在每一个job构建后,可以选择"测试报告输出配置",填入测试报告的路径,以及报告名
![](https://github.com/yumao123/reportpublisher-plugin/blob/master/src/static/step2.png?raw=true)

![](https://github.com/yumao123/reportpublisher-plugin/blob/master/src/static/step3.png?raw=true)

4.在构建结束后,左左边栏菜单多出一个菜单"查看测试报告",点击跳转到测试报告地址

![](https://github.com/yumao123/reportpublisher-plugin/blob/master/src/static/step4.png?raw=true)


