＃springBoot多环境项目+MybatisPlus+swagger2+redis
spring:
  profiles:
    active: test  
    include:
      - mybatis-plus
      - redis
