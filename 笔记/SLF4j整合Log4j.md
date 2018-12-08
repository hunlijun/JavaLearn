# SLF4j整合Log4j

![1544250380979](C:\Users\Freeking\AppData\Roaming\Typora\typora-user-images\1544250380979.png)

### 一、导入包

```xml
<dependency> 
  <groupId>org.slf4j</groupId>
  <artifactId>slf4j-log4j12</artifactId>
  <version>1.8.0-alpha2</version>
</dependency>
```

### 二、类路径下增加log4j配置文件

```properties
# rootLogger参数分别为：根Logger级别，输出器stdout，输出器log
log4j.rootLogger = info,stdout,log

# 输出信息到控制台
log4j.appender.stdout = org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout = org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern = %d [%-5p] %l %rms: %m%n

# 输出DEBUG级别以上的日志到D://logs/debug.log
log4j.appender.log = org.apache.log4j.DailyRollingFileAppender
log4j.appender.log.DatePattern = '.'yyyy-MM-dd
log4j.appender.log.File = D://debug.log
log4j.appender.log.Encoding = UTF-8
#log4j.appender.log.Threshold = INFO
log4j.appender.log.layout = org.apache.log4j.PatternLayout
log4j.appender.log.layout.ConversionPattern = %d [%-5p] (%c.%t): %m%n 
```

### 三、测试代码

```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {

    private static final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    public static void main(String[] args) {
        logger.info("Current Time: {}", System.currentTimeMillis());
        logger.info("Current Time: " + System.currentTimeMillis());
        logger.info("Current Time: {}", System.currentTimeMillis());
        logger.trace("trace log");
        logger.warn("warn log");
        logger.debug("debug log");
        logger.info("info log");
        logger.error("error log");
    }
}
```

