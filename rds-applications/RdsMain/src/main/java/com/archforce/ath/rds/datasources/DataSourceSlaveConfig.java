package com.archforce.ath.rds.datasources;

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
@MapperScan(basePackages = DataSourceSlaveConfig.PACKAGE, sqlSessionFactoryRef = "sqlSessionFactorySlave")
public class DataSourceSlaveConfig {

    public static final String PACKAGE = "com.archforce.ath.rds.mapper.mapperSlave";
    private static final String MAPPER_LOCATION = "classpath:com/archforce/ath/rds/mapper/mapperSlave/*.xml";

    @Value("${spring.datasourceSlave.driverClassName}")
    private String driverClassName;
    @Value("${spring.datasourceSlave.url}")
    private String url;
    @Value("${spring.datasourceSlave.username}")
    private String username;
    @Value("${spring.datasourceSlave.password}")
    private String password;
    @Value("${spring.datasourceSlave.druid.initial-size}")
    private int initialSize;
    @Value("${spring.datasourceSlave.druid.min-idle}")
    private int minIdle;
    @Value("${spring.datasourceSlave.druid.max-active}")
    private int maxActive;
    @Value("${spring.datasourceSlave.druid.max-wait}")
    private int maxWait;

    @Bean(name = "dataSourceSlave")
    public DataSource abroadDataSource() {
        return DruidDataSourceBuilder.newInstance().appendDriverClassName(driverClassName).appendUrl(url).appendUsername(username).appendPassword(password).appendInitialSize(initialSize).appendMinIdle(minIdle).appendMaxActive(maxActive).appendMaxWait(maxWait).getDataSource();
    }

    @Bean(name = "transactionManagerSlave")
    public DataSourceTransactionManager abroadTransactionManager() {
        return new DataSourceTransactionManager(abroadDataSource());
    }

    @Bean(name = "sqlSessionFactorySlave")
    public SqlSessionFactory abroadSqlSessionFactory(@Qualifier("dataSourceSlave") DataSource abroadDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(abroadDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
