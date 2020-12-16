package com.archforce.ath.rds.datasources;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by Jason on 2019/6/24.
 */
@Configuration
@MapperScan(basePackages = DataSourceMasterConfig.PACKAGE, sqlSessionFactoryRef = "sqlSessionFactoryMaster")
public class DataSourceMasterConfig {

    public static final String PACKAGE = "com.archforce.ath.rds.mapper.mapperMaster";
    private static final String MAPPER_LOCATION = "classpath:com/archforce/ath/rds/mapper/mapperMaster/*.xml";

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.druid.initial-size}")
    private int initialSize;
    @Value("${spring.datasource.druid.min-idle}")
    private int minIdle;
    @Value("${spring.datasource.druid.max-active}")
    private int maxActive;
    @Value("${spring.datasource.druid.max-wait}")
    private int maxWait;

    @Bean(name = "dataSourceMaster")
    @Primary
    public DataSource abroadDataSource() {
        return DruidDataSourceBuilder.newInstance().appendDriverClassName(driverClassName).appendUrl(url).appendUsername(username).appendPassword(password).appendInitialSize(initialSize).appendMinIdle(minIdle).appendMaxActive(maxActive).appendMaxWait(maxWait).getDataSource();
    }

    @Bean(name = "transactionManagerMaster")
    @Primary
    public DataSourceTransactionManager abroadTransactionManager() {
        return new DataSourceTransactionManager(abroadDataSource());
    }

    @Bean(name = "sqlSessionFactoryMaster")
    @Primary
    public SqlSessionFactory abroadSqlSessionFactory(@Qualifier("dataSourceMaster") DataSource abroadDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(abroadDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
