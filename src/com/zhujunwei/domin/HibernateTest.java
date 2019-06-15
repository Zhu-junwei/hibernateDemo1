package com.zhujunwei.domin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

public class HibernateTest {
	
	@Test
	public void demo1() {
		//1、加载Hibernate的核心配置文件：hibernate.cfg.xml
		Configuration configuration = new Configuration().configure();
		//2、创建一个SessionFactory对象：类似于JDBC中的连接池
		SessionFactory sessionFactory = configuration.buildSessionFactory();
//		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
//		SessionFactory sessionFactory = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		//3、通过SessionFactory获取Session对象：类似JDBC中的Connection
		Session session = sessionFactory.openSession();
		//4、手动开启事务
		Transaction transaction = session.beginTransaction();
		//5、编写代码
		Customer customer = new Customer();
		customer.setCust_name("朱俊sdf伟12");
		session.save(customer);
		//6、事务提交
		transaction.commit();
		//7、资源释放
		session.close();
	}
}
