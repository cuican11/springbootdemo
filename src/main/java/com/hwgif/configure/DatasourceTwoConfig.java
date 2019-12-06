package com.hwgif.configure;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by lc.huang on 2019/11/20.
 * Description    网上说Springboot不支持自动配置druid连接池（即无法通过配置项直接支持相应的连接池连接池）
 * 这里配置项可以通过定制化DataSource来实现
 * 定置化DataSource类：
 */

@Configuration
//扫描 Mapper 接口并容器管理
@MapperScan(basePackages = DatasourceTwoConfig.PACKAGE, sqlSessionFactoryRef = "sqlSessionFactoryTwo")
public class DatasourceTwoConfig {
    // 精确到 master 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.hwgif.demotwo.dao.impl";
    static final String MAPPER_LOCATION = "classpath:conf/mappertwo/*.xml";

    @Value("${spring.datasource.two.url}")
    private String url;
    @Value("${spring.datasource.two.username}")
    private String user;
    @Value("${spring.datasource.two.password}")
    private String password;
    @Value("${spring.datasource.two.driverClassName}")
    private String driverClass;

    @Value("${spring.datasource.two.maxActive}")
    private Integer maxActive;
    @Value("${spring.datasource.two.minIdle}")
    private Integer minIdle;
    @Value("${spring.datasource.two.initialSize}")
    private Integer initialSize;
    @Value("${spring.datasource.two.maxWait}")
    private Long maxWait;
    @Value("${spring.datasource.two.timeBetweenEvictionRunsMillis}")
    private Long timeBetweenEvictionRunsMillis;
    @Value("${spring.datasource.two.minEvictableIdleTimeMillis}")
    private Long minEvictableIdleTimeMillis;
    @Value("${spring.datasource.two.testWhileIdle}")
    private Boolean testWhileIdle;
    @Value("${spring.datasource.two.testWhileIdle}")
    private Boolean testOnBorrow;
    @Value("${spring.datasource.two.testOnBorrow}")
    private Boolean testOnReturn;

    @Bean(name = "dataSourceTwo")
//    @Primary   //从库DataSource 不需要此注解
    public DataSource dataSourceTwo() {
        //jdbc配置
        DruidDataSource dataSourceTwo = new DruidDataSource();
        dataSourceTwo.setDriverClassName(driverClass);
        dataSourceTwo.setUrl(url);
        dataSourceTwo.setUsername(user);
        dataSourceTwo.setPassword(password);

        //连接池配置
        dataSourceTwo.setMaxActive(maxActive);
        dataSourceTwo.setMinIdle(minIdle);
        dataSourceTwo.setInitialSize(initialSize);
        dataSourceTwo.setMaxWait(maxWait);
        dataSourceTwo.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSourceTwo.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSourceTwo.setTestWhileIdle(testWhileIdle);
        dataSourceTwo.setTestOnBorrow(testOnBorrow);
        dataSourceTwo.setTestOnReturn(testOnReturn);
        dataSourceTwo.setValidationQuery("SELECT 'x'");

        dataSourceTwo.setPoolPreparedStatements(true);
        dataSourceTwo.setMaxPoolPreparedStatementPerConnectionSize(20);

        try {
            dataSourceTwo.setFilters("stat");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataSourceTwo;
    }

    @Bean(name = "transactionManagerTwo")
    public DataSourceTransactionManager transactionManagerTwo() {
        return new DataSourceTransactionManager(dataSourceTwo());
    }

    @Bean(name = "sqlSessionFactoryTwo")
    public SqlSessionFactory twoSqlSessionFactory(@Qualifier("dataSourceTwo") DataSource dataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setTypeAliasesPackage("cm.hwgif.demotwo.**.bean");
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(DatasourceTwoConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate twoSqlSessionTemplate(@Qualifier("sqlSessionFactoryTwo") SqlSessionFactory
                                                                sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
