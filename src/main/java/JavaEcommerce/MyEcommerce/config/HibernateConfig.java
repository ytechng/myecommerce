package JavaEcommerce.MyEcommerce.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"JavaEcommerce.MyEcommerce.dao"})
@EnableTransactionManagement
public class HibernateConfig {
	 
	// Change values below based on the DBMS of choice
	private static final String DATABASE_URL = "jdbc:h2:tcp://localhost/~/myecommerce";
	private static final String DATABASE_DRIVER = "org.h2.Driver";
	private static final String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private static final String DATABASE_USERNAME = "sa";
	private static final String DATABASE_PASSWORD = "";
	
	// dataSource bean will be available
	@Bean
	public DataSource getDataSource() {
		
		BasicDataSource dataSource = new BasicDataSource();
		
		// Providing the database connection information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		
		return dataSource;
	}
	
	
	// sessionFactory bean will be available
	@Bean
	public SessionFactory getSessionFactory(DataSource ds) {
		
		// Note the hibernate version used
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(ds);
		
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("JavaEcommerce.MyEcommerce.dto");
		
		return builder.buildSessionFactory();
		
	}


	// All hibernate properties will be returned in this method
	private Properties getHibernateProperties() {

		Properties properties = new Properties();
		
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true"); 
		properties.put("hibernate.format_sql", "true");
		
		return properties;
	}
	
	
	// transactionManagement bean will be available
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sf) {
		
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sf);
		
		return transactionManager;
	}

}
