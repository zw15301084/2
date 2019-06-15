package com.example.demo.configuration;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactorySecondary",
        transactionManagerRef="transactionManagerSecondary",
        basePackages= { "com.example.demo.repository.secondary" }) //设置Repository所在位置
public class SecondaryConfig {

    @Resource
    private Properties jpaProperties;

    @Autowired
    @Qualifier("secondaryDataSource")
    private DataSource secondaryDataSource;

    @Bean(name = "entityManagerSecondary")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactorySecondary(builder).getObject().createEntityManager();
    }

    @Bean(name = "entityManagerFactorySecondary")
    public LocalContainerEntityManagerFactoryBean entityManagerFactorySecondary (EntityManagerFactoryBuilder builder) {
        LocalContainerEntityManagerFactoryBean entityManagerFactory
                = builder
                .dataSource(secondaryDataSource)
                .packages("com.example.demo.domain.secondary")//设置实体类所在位置
                .persistenceUnit("secondaryPersistenceUnit")//持久化单元创建一个默认即可，多个便要分别命名
                .build();
        entityManagerFactory.setJpaProperties(jpaProperties);
        return entityManagerFactory;
/*
        return builder
                .dataSource(secondaryDataSource)
                .properties(getVendorProperties())
                .packages("com.example.demo.domain.secondary") //设置实体类所在位置
                .persistenceUnit("secondaryPersistenceUnit")
                .build();*/
    }

   /* private Map<String, String> getVendorProperties() {
        System.out.println(JSON.toJSONString(jpaProperties.getProperties()));
        return jpaProperties.getProperties();
    }*/

    @Bean(name = "transactionManagerSecondary")
    PlatformTransactionManager transactionManagerSecondary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactorySecondary(builder).getObject());
    }
}
