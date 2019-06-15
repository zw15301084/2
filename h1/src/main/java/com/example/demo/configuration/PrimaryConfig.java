package com.example.demo.configuration;

import com.alibaba.fastjson.JSON;
import com.sun.tools.internal.xjc.api.J2SJAXBModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
        entityManagerFactoryRef="entityManagerFactoryPrimary",
        transactionManagerRef="transactionManagerPrimary",
        basePackages= { "com.example.demo.repository.primary" }) //设置Repository所在位置
public class PrimaryConfig {


    @Resource
    private Properties jpaProperties;

    @Autowired

    @Qualifier("primaryDBSource")
    private DataSource primaryDataSource;

    @Primary
    @Bean(name = "primaryEntityManager")
    public EntityManager primaryEntityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
    }
    @Primary
    @Bean(name = "entityManagerFactoryPrimary")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary(EntityManagerFactoryBuilder builder) {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = builder
                .dataSource(primaryDataSource)
                .packages("com.example.demo.domain.primary")
                .persistenceUnit("primaryPersistenceUnit")
                .build();
        entityManagerFactory.setJpaProperties(jpaProperties);

        return entityManagerFactory;
    }

    /*private Map<String, String> getVendorProperties() {
        System.out.println(JSON.toJSONString(jpaProperties.getProperties()));
        return jpaProperties.getProperties();
    }*/

    @Primary
    @Bean(name = "transactionManagerPrimary")
    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
    }


}
