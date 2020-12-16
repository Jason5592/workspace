package com.archforce.ath.rds.datasource.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by Jason on 2019/6/24.
 */
@Configuration
@MapperScan(basePackages = DataSourceTwoConfig.PACKAGE, sqlSessionFactoryRef = "sqlSessionFactoryTwo")
public class DataSourceTwoConfig {

    public static final String PACKAGE = "com.archforce.ath.rds.mapper.mapperTwo";
    private static final String MAPPER_LOCATION = "classpath:com/archforce/ath/rds/mapper/mapperTwo/*.xml";

    @Value("${spring.datasource.two.driverClassName}")
    private String driverClassName;
    @Value("${spring.datasource.two.url}")
    private String url;
    @Value("${spring.datasource.two.username}")
    private String username;
    @Value("${spring.datasource.two.password}")
    private String password;
    @Value("${spring.datasource.two.druid.initial-size}")
    private int initialSize;
    @Value("${spring.datasource.two.druid.min-idle}")
    private int minIdle;
    @Value("${spring.datasource.two.druid.max-active}")
    private int maxActive;
    @Value("${spring.datasource.two.druid.max-wait}")
    private int maxWait;

    @Bean(name = "dataSourceTwo")
    public DataSource abroadDataSource() {
        return DruidDataSourceBuilder.newInstance().appendDriverClassName(driverClassName).appendUrl(url).appendUsername(username).appendPassword(password).appendInitialSize(initialSize).appendMinIdle(minIdle).appendMaxActive(maxActive).appendMaxWait(maxWait).getDataSource();
    }

    @Bean(name = "transactionManagerTwo")
    public DataSourceTransactionManager abroadTransactionManager() {
        return new DataSourceTransactionManager(abroadDataSource());
    }

    @Bean(name = "sqlSessionFactoryTwo")
    public SqlSessionFactory abroadSqlSessionFactory(@Qualifier("dataSourceTwo") DataSource abroadDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(abroadDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
