# Log4j

### 一、classpath下增加配置文件log4j.properties

```properties
#默认输出路径
log4j.rootLogger=info,stdout,logfile,busi1
log4j.appender.logfile=org.apache.log4j.FileAppender
log4j.appender.logfile.File=logs/cmsmgr.log
log4j.appender.logfile.layout=org.apache.log4j.PatternLayout
log4j.appender.logfile.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %F %p %m%n

log4j.logger.com.ibatis=INFO
log4j.logger.com.ibatis.common.jdbc.SimpleDataSource=INFO
log4j.logger.com.ibatis.common.jdbc.ScriptRunner=INFO
log4j.logger.com.ibatis.sqlmap.engine.impl.SqlMapClientDelegate=INFO
log4j.logger.java.sql.Connection=INFO
log4j.logger.java.sql.Statement=INFO
log4j.logger.java.sql.PreparedStatement=INFO
#输出到控制台
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.Threshold=INFO
log4j.appender.stdout.ImmediateFlush=true
log4j.appender.stdout.Target=System.err
log4j.appender.stdout.layout.ConversionPattern=[%-5p] %d(%r) --> [%t] %l: %m %x %n
#输出到busi1
log4j.logger.busi1= info, busi1
#每天产生一个日志文件
log4j.appender.busi1=org.apache.log4j.DailyRollingFileAppender
#日志文件格式
log4j.appender.busi1.DatePattern='.'yyyy-MM-dd-HH
#日志路径
log4j.appender.busi1.File=logs/busi1.log
#最低输出日志级别
log4j.appender.busi1.Threshold = INFO
#输出的布局样式
log4j.appender.busi1.layout=org.apache.log4j.PatternLayout
#自定义输出哪些信息
log4j.appender.busi1.layout.ConversionPattern=[%d{yyyy-MM-dd HH:mm:ss}] %l%t %m%n

#输出到busi
log4j.logger.busi= info, busi
log4j.appender.busi=org.apache.log4j.DailyRollingFileAppender
log4j.appender.busi.File=logs/busi.log
log4j.appender.busi.Threshold = INFO
log4j.appender.busi.DatePattern='.'yyyy-MM-dd-HH
log4j.appender.busi.layout=org.apache.log4j.PatternLayout
log4j.appender.busi.layout.ConversionPattern=[%d{yyyy-MM-dd HH:mm:ss}] %l%t %m%n
```

### 二、引入包

```xml
<!-- https://mvnrepository.com/artifact/log4j/log4j -->
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core -->
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-core</artifactId>
            <version>2.11.1</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api -->
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-api</artifactId>
            <version>2.11.1</version>
        </dependency>
```

### 三、使用

```java
public class Log4JTest {
//默认输出路径
private static org.apache.log4j.Logger logger1=org.apache.log4j.Logger.getLogger("Log4JTest");
//自定义输出路径
private static org.apache.log4j.Logger logger=org.apache.log4j.Logger.getLogger("busi");
public static void main(String[] args) {
new Log4JTest().testLog();
}

public void testLog(){

logger1.info("默认输出路径");
logger.info("自定义输出路径");
}
}
```





