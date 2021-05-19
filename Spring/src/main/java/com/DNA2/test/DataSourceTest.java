package com.DNA2.test;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/18 21:18
 */
public class DataSourceTest {
    public static void main(String[] args) throws Exception {
        DataSourceTest dataSourceTest = new DataSourceTest();
        dataSourceTest.test1();
        //dataSourceTest.test2();
        dataSourceTest.test3();
    }
    /**
    * @Description 读取配置文件创建c3p0数据源
    * @Return []
    * @Author 脱氧核糖
    * @Date 2021/5/18 21:19
    */
    public void test1() throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource("DNAc3p0");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    /**
    * @Description 读取配置文件获取druid数据源
    * @Return []
    * @Author 脱氧核糖
    * @Date 2021/5/18 21:31
    */
    public void test2() throws Exception {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(new File("src/main/resources/druid.properties"));
        properties.load(fileInputStream);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    /**
    * @Description Spring容器产生druid数据源对象
    * @Return []
    * @Author 脱氧核糖
    * @Date 2021/5/18 21:51
    */
    public void test3() throws SQLException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = (DataSource) app.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

}
