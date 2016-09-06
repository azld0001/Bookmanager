package com.test;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.azld.model.User;
import com.azld.model.UserKey;
import com.azld.service.impl.*;
import com.azld.service.*;
import com.azld.IDao.*;
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml, classpath:spring.xml"})  

public class UserServiceTest 
{
//	private static Logger logger = Logger.getLogger(TestMyBatis.class);  
	
//	@Resource("userService")
//	private UserService		aUserService;
	
	@Resource
	private UserMapper auserwapper;
	
	@Resource
//	private UserService auserservice;
	
//	@Test
//	public void test1()
//	{
//		System.out.println("begin select");
//		User auser = auserwapper.selectByPrimaryKey(1);
//		System.out.println(auser);
//		System.out.println("end select");
//	}
//	@Test
//	public void testserver()
//	{
////		User auser = new User();
////		auser.setName("user0009");
////		
////		User buser = this.auserservice.getuserwithPK(auser);
////		System.out.println(buser);
////		System.out.println("end select");
//
//	}
	
	
	@Test
	public void test_add()
	{
		User auser = new User();
		auser.setName("user0013");
		auser.setPassword(auser.getName());
		auser.setType(1);
		System.out.println("begin insert");
		
		UserKey userkey1 = new UserKey();
		userkey1.setName(auser.getName());

		UserKey uk = new UserKey();
		uk.setName(auser.getName());
		User buser = this.auserwapper.selectByPrimaryKeyName(uk);
		if( buser == null )
		{
			Integer uid = this.auserwapper.insert(auser);
			auser.setId(uid);
//			return auser;
		}
		else
		{
//			return null;
		}

		
		User btest = this.auserwapper.selectByPrimaryKey(userkey1);
		if( btest == null )
		{
			this.auserwapper.insert(auser);
		}
		else
		{
			System.out.println(btest);
		}
			
//		auserwapper.insertSelective(auser);
//		UserKey userkey2 = new UserKey();
//		userkey2.setName(auser.getName());
//		userkey2.setId(9);
//		User buser = this.auserwapper.selectByPrimaryKey(userkey2);
//		User causer = this.auserwapper.selectByPrimaryKeyID(userkey2);
//		
//		System.out.println(buser);
//		System.out.println(causer);
//		System.out.println("end insert");
//		System.out.println("end");
	}
	
}