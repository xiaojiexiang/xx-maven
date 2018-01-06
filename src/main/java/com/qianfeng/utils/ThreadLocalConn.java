package com.qianfeng.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ThreadLocalConn {
	private static ComboPooledDataSource pool = new ComboPooledDataSource();
	//ThreadLocal用于存放当前线程使用的Connection对象
	private static ThreadLocal<Connection> tl = new ThreadLocal<>();
	//是从连接池中获得一个连接
	public static Connection getConnection() throws SQLException{
		return pool.getConnection();
	}
	//获得一个当前的连接对象
	public static Connection getCurrentConnection() throws SQLException{
		//1.要想获得一个当前conn对象，该对象是从ThreadLocal对象中获得。
		Connection conn = tl.get();
		//2.如果是从service层调用该方法，那么tl中还没有conn，因此获得的是null
		if(conn==null){
			//3.往tl中塞入一个conn对象。  
			conn = getConnection();
			tl.set(conn);
		}
		//3.当第一次之后的再使用，就可以从tl获得之前存入的conn对象。
		return tl.get();
	}
	//获得一个连接池
	public static DataSource getDataSource(){
		return pool;
	}
	//开启事务的方法：事务是基于Connection对象的。
	public static void beginTransaction() throws SQLException {
		/*//如果从池子里拿的连接，下次使用时可能是另外一个
		Connection conn = getConnection();
		conn.setAutoCommit(false);*/
		Connection conn = getCurrentConnection();
		conn.setAutoCommit(false);
		
	}
	//提交事务，通过conn.commit
	public static void commit() throws SQLException {
		Connection conn = getCurrentConnection();
		conn.commit();
		
	}
	//回滚事务
	public static void rollback() throws SQLException {
		getCurrentConnection().rollback();
		
	}
}
