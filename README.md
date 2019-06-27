maven坑有点多..记录一下吧
    我用的是Goals: tomcat:run，这样会导致一个问题：尽管我配置的是tomcat8.5，但默认使用tomcat6，而tomcat6不支持jdk1.8版本 
    这里就需要添加tomcat7-maven-plugin的插件 
    注意：如果你的版本是tomcat7-maven-plugin 2.0 的话，由于它不支持 jdk 1.8，所以把它换成 tomcat7-maven-plugin 2.2就行了 
    在pom.xml里添加如下代码：
    
    <plugin>
        <groupId>org.apache.tomcat.maven</groupId>
        <artifactId>tomcat7-maven-plugin</artifactId>
        <version>2.2</version>
    </plugin>
    
换源 
    $maven/conf/setting.xml
        <mirror>
            <id>sjtugmaven</id>
            <name>sjtug maven</name>
            <url>https://mirrors.sjtug.sjtu.edu.cn/maven-central/</url>
            <mirrorOf>central</mirrorOf>
        </mirror>
    
 <scope>test</scope> 防止冲突,更改作用域
 IDEA设置,VM option 读取本地仓库-DarchetypeCatalog=internal    