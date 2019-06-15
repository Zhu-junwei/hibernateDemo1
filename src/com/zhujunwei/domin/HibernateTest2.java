package com.zhujunwei.domin;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.junit.jupiter.api.Test;

import com.zhujunwei.utils.HibernateUtils;

/**
 * 使用Hibernate工具类获取Session对象
 * 先查再改（直接修改的话，如果对象的相关属性没有设置会变为null,先查再改的话只会改变对象修改的内容，没有修改的部分不会改变）
 * 先查再删（直接删除的话，级联的记录不会被删除，先查后删级联的记录会删除）
 * @author zhujunwei
 * 2019年3月18日 下午5:57:17
 */
public class HibernateTest2 {

	/**
	 *  保存对象
	 */
	@Test
	public void demo1() {
	
		Session session = HibernateUtils.openSession();
		//4、手动开启事务
		Transaction transaction = session.beginTransaction();
		//5、编写代码
		Customer customer = new Customer();
		customer.setCust_name("伟");
		session.save(customer);
		//6、事务提交
		transaction.commit();
		//7、资源释放
		session.close();
	}
	
	/**
	 *  查询对象
	 */
	@Test
	public void demo2() {
		
		Session session = HibernateUtils.openSession();
		//4、手动开启事务
		Transaction transaction = session.beginTransaction();
		//5、编写代码
		//通过get方法获取对象
		Customer customer = session.get(Customer.class, 2L);
		System.out.println(customer);
		
//		Customer customer2 = session.get(Customer.class, 2);
//		System.out.println(customer2);
		//6、事务提交
		transaction.commit();
		//7、资源释放
		session.close();
	}
	
	/**
	 *  修改对象
	 */
	@Test
	public void demo3() {
		
		Session session = HibernateUtils.openSession();
		//4、手动开启事务
		Transaction transaction = session.beginTransaction();
		//5、编写代码
		//通过get方法获取对象
		Customer customer = session.get(Customer.class, 2L);
		customer.setCust_name("LLL");
		session.update(customer);
		
		//6、事务提交
		transaction.commit();
		//7、资源释放
		session.close();
	}
	
	/**
	 *  删除对象
	 */
	@Test
	public void demo4() {
		
		Session session = HibernateUtils.openSession();
		//4、手动开启事务
		Transaction transaction = session.beginTransaction();
		//5、编写代码
		//通过get方法获取对象
		Customer customer = session.get(Customer.class, 3L);
		session.delete(customer);
		
		//6、事务提交
		transaction.commit();
		//7、资源释放
		session.close();
	}
	
	/**
	 *  查询所有对象
	 */
	@Test
	public void demo5() {
		
		Session session = HibernateUtils.openSession();
		//4、手动开启事务
		Transaction transaction = session.beginTransaction();
		//5、编写代码
		//通过get方法获取对象
		//接受HQL hibernate sql language
		
//		@SuppressWarnings("unchecked")
//		Query<Customer> query = session.createQuery("from Customer");
//		List<Customer> list = query.list();
//		for (Customer customer : list) {
//			System.out.println(customer);
//			
//		}
		
		//接收sql
		@SuppressWarnings("unchecked")
		NativeQuery<Object[]> query = session.createSQLQuery("select * from cst_customer");
		List<Object[]> list = query.list();
		for (Object[] customer : list) {
			System.out.println(Arrays.toString(customer));
		}
		
		//6、事务提交
		transaction.commit();
		//7、资源释放
		session.close();
	}
	
	
}
