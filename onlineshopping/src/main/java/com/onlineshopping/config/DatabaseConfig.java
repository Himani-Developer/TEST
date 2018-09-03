package com.onlineshopping.config;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.onlineshopping")
@EnableTransactionManagement

public class DatabaseConfig {
	private final String DBdriver="org.h2.Driver";
	private final String DBurl="jdbc:h2:tcp://localhost/~/himani";
	private final String DBusername="sa";
	private final String DBpassword="";
	
 @Bean(name="dataSource")
	public DataSource getdataSource()
	{
	 DriverManagerDataSource dataSource=new DriverManagerDataSource();
	 dataSource.setDriverClassName(DBdriver);
	 dataSource.setUrl(DBurl);
	 dataSource.setUsername(DBusername);
	 dataSource.setPassword(DBpassword);
	 System.out.println("Data source object is created");
	 return dataSource;
	}
 
 @Bean(name="sessionFactory")
 public SessionFactory getSessionFactory(DataSource dataSource)
 {
	 LocalSessionFactoryBuilder lsfb= new LocalSessionFactoryBuilder(dataSource);
	 lsfb.addProperties(getHibernateProp());
	 lsfb.scanPackages("com.onlineshopping.model");   //mapping  lsfb.addAnnotedClass(User.class)
	 System.out.println("Session factory is created");
	 return lsfb.buildSessionFactory();
	 
 }
 
 private Properties getHibernateProp()
 {
	 Properties prop=new Properties();
	 prop.put("hibernate.hbm2ddl.auto","update");  //create-drop , validate, create
	 prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");  //DBDialect
	 prop.put("hibernate.show_sql", "true");
	 prop.put("hibernate.format_sql", "true");
	 return prop;
 }
 
 @Bean 
 public HibernateTransactionManager getTransaction(SessionFactory sessionFactory)
 {
	 System.out.println("Hibernate transaction manager is created");
 return new HibernateTransactionManager(sessionFactory);
 
 }
 
  
}

