package com.chainsys.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAO {
	/*
	 * Pre condition
	 * name,price,id must e valid
	 */
	public void addBook(Book book) throws Exception{
		try {
			Connection connection=ConnectionUtil.getConnection();
			String sql = ("insert into books(name,price,id) values(?,?,?)");
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1,book.name);
			stmt.setInt(2, book.price);
			stmt.setInt(3, book.id);
			stmt.executeQuery();
			ConnectionUtil.close(connection, stmt, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("Unable to insert book");
		}
	}
	public void updateBook(Book book) throws SQLException{
		Connection connection=ConnectionUtil.getConnection();
		String sql="update books set name=? where id=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,book.name);
		stmt.setInt(2,book.id);
		stmt.executeQuery();
		ConnectionUtil.close(connection, stmt, null);
	}
	public void deleteBook(Book book) throws SQLException{
		Connection connection=ConnectionUtil.getConnection();
		String sql="delete from books where id=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, book.id);
		int rows=stmt.executeUpdate();
		System.out.println("rows affected:"+rows);
		ConnectionUtil.close(connection, stmt, null);
	}
	public void findAll() throws SQLException{
		Connection connection=ConnectionUtil.getConnection();
		String sql="Select name,price,id from books";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rset=stmt.executeQuery();
		while(rset.next()){
			System.out.println();
			System.out.println(rset.getInt("id"));
			System.out.println(rset.getString("name"));
			System.out.println(rset.getInt("price"));
		}
		ConnectionUtil.close(connection, stmt, rset);
	}
}