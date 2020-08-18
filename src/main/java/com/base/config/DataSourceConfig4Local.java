//package com.base.config;
//
//import javax.sql.DataSource;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import com.alibaba.druid.pool.DruidDataSource;
//@Configuration
//@EnableTransactionManagement
//@MapperScan(basePackages="com.bt.admin.security.admin.mapper",sqlSessionTemplateRef="sqlSessionTemplate4Local")
//public class DataSourceConfig4Local {
// 	@Bean(name = "dataSource4Local")
//    @ConfigurationProperties(prefix = "spring.datasource.local")
//    public DataSource dataSource4Base() {
//        return DataSourceBuilder.create().type(DruidDataSource.class).build();
//    }
// 	
// 	@Bean(name = "sqlSessionFactory4Local")
//    @Primary
//    public SqlSessionFactory testSqlSessionFactory(@Qualifier("dataSource4Local") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
//        return bean.getObject();
//    }
// 
//    @Bean(name = "transactionManager4Local")
//    @Primary
//    public DataSourceTransactionManager testTransactionManager(@Qualifier("dataSource4Local") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
// 
//    @Bean(name = "sqlSessionTemplate4Local")
//    @Primary
//    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("sqlSessionFactory4Local") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//}
