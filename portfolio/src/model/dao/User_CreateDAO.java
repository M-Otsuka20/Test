package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.entity.User;

public class User_CreateDAO {

	//データベースURL
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/portfolio?useSSL=false";
	//ユーザー名
	private final String DB_USER = "root";
	//パスワード
	private final String DB_PASS = "root";

	//ユーザーを作る
	public boolean CreateUser(User createuser) {

		try {
			// JDBCドライバの読み込み
			Class.forName("com.mysql.jdbc.Driver");

			// データベースへ接続
			try (Connection conn = DriverManager.getConnection(
					JDBC_URL, DB_USER, DB_PASS)) {

//				String name = null;
//				String id = null;
//				String password = null;
//				String mail = null;

				// INSERT文を準備
				String sql = "INSERT INTO userdata (name,id,password,mail) VALUES(?,?,?,?)";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, createuser.getName());
				pstmt.setString(2, createuser.getId());
				pstmt.setString(3, createuser.getPassword());
				pstmt.setString(4, createuser.getMail());

				// SELECTを実行し、アカウント作成
				pstmt.executeUpdate();

				System.out.println("ユーザーつくる");
				System.out.println(1 + createuser.getId());
				System.out.println(1 + createuser.getPassword());
				System.out.println(1 + createuser.getName());
				System.out.println(1 + createuser.getMail());

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("失敗");
				return false;

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return true;

	}

}
