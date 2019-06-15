package com.example.demo.configuration;

import java.util.Properties;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactorySecondary",
        transactionManagerRef="transactionManagerSecondary",
        basePackages= { "com.example.demo.repository.secondary" }) //璁剧疆Repository鎵�鍦ㄤ綅缃�
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
                .packages("com.example.demo.domain.secondary")//璁剧疆瀹炰綋绫绘墍鍦ㄤ綅缃�
                .persistenceUnit("secondaryPersistenceUnit")//鎸佷箙鍖栧崟鍏冨垱寤轰竴涓粯璁ゅ嵆鍙紝澶氫釜渚胯鍒嗗埆鍛藉悕
                .build();
        entityManagerFactory.setJpaProperties(jpaProperties);
        return entityManagerFactory;
/*
        return builder
                .dataSource(secondaryDataSource)
                .properties(getVendorProperties())
                .packages("com.example.demo.domain.secondary") //璁剧疆瀹炰綋绫绘墍鍦ㄤ綅缃�
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
