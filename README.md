# 如何编译 TOMCAT 源码
1. 克隆tomcat 源码
```bash
git clone -b 9.0.44 https://github.com/apache/tomcat.git
```
2. 安装 [ant](https://dlcdn.apache.org//ant/binaries/apache-ant-1.10.12-bin.zip/) 

3. 修改依赖包的目录,建议改到项目内部libs目录
```bash
sed -iE 's#(^base.path=).*$#\1XXX#p' build.properties.default
```
4. 执行命令构建
```bash
ant deploy
# 使用eclipse 项目构建 用IDEA 打开 IDEA 的有坑不要趟
ant ide-eclipse
```
4. 从ant 安装目录复制 ant.jar 放入libs 目录,并将libs目录add as library

5. idea 打开项目试着运行一下 bootstrap 看是否有缺少包 注释掉测试文件 test/org/apache/coyote/http2/TestStream.java
和 test/util/TestCookieFilter.java 的报错信息

6. 设置项目JDK建议使用JDK 11 (JDK8 需要修改字符集乱码影响不大)

7. idea 配置tomcat 启动参数
```bash
-Djava.util.logging.config.file=/Users/huyiyu/github/tomcat/conf/logging.properties -Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager -Djdk.tls.ephemeralDHKeySize=2048 -Djava.protocol.handler.pkgs=org.apache.catalina.webresources -Dorg.apache.catalina.security.SecurityListener.UMASK=0027 -Dcatalina.base=/Users/huyiyu/github/tomcat/ -Dcatalina.home=/Users/huyiyu/github/tomcat/
```
8. 将output 编译好的webapp 覆盖源码webapp
```bash
mv webapps webapps-backup
cp -r output/build/webapps webapps
```
9. bootstrap 静态代码块中添加主动初始化JSP代码
```java
try {
    Class<?> aClass = Class.forName("org.apache.jasper.servlet.JasperInitializer");
} catch (ClassNotFoundException e) {
    e.printStackTrace();
}
```
