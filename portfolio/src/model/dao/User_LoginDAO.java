package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.User;

public class User_LoginDAO {

	//データベースURL
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/portfolio?useSSL=false";
	//ユーザー名
	private final String DB_USER = "root";
	//パスワード
	private final String DB_PASS = "root";

	//ユーザーを探す
	public User findByLogin(User user) {
		//初期化
		User useraccount = null;

		try {
			// JDBCドライバの読み込み
			Class.forName("com.mysql.jdbc.Driver");

			// データベースへ接続
			try (Connection conn = DriverManager.getConnection(
					JDBC_URL, DB_USER, DB_PASS)) {

				// SELECT文を準備
				String sql = "SELECT * FROM userdata WHERE id = ? AND password = ? ";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, user.getId());
				pstmt.setString(2, user.getPassword());

				// SELECTを実行し、結果表を取得
				ResultSet rs = pstmt.executeQuery();

				// 一致したユーザーが存在した場合
				// そのユーザーを表すAccountインスタンスを生成
				if (rs.next()) {
					String id = rs.getString("id");
					String password = rs.getString("password");
					String name = rs.getString("name");
					String mail = rs.getString("mail");
					useraccount = new User(id, password, name, mail);

				}

				System.out.println("ユーザーあった");
				System.out.println(1 + useraccount.getId());
				System.out.println(1+ useraccount.getPassword());
				System.out.println(1 + useraccount.getName());
				System.out.println(1 + useraccount.getMail());

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("失敗");

				return null;

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} //見つかったユーザーを返す
		return useraccount;

	}

}