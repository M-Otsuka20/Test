package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.Cosme;

public class Item_RomandDAO {

	//データベースURL
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/portfolio?useSSL=false";
	//ユーザー名
	private final String DB_USER = "root";
	//パスワード
	private final String DB_PASS = "root";

	//ユーザーを探す
	public Cosme findItem_romand(Cosme cosme) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			try (Connection conn = DriverManager.getConnection(
					JDBC_URL, DB_USER, DB_PASS)) {
				String sql = "SELECT * FROM cosmedata WHERE maker=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, cosme.getCode());

				ResultSet rs = pStmt.executeQuery();
				if (rs.next()) {
					String code = rs.getString("code");
					String name = rs.getString("name");
					int price = rs.getInt("price");
					String category = rs.getString("category");
					int stock = rs.getInt("stock");
					String maker = rs.getString("maker");
					String makercode = rs.getString("makercode");
					cosme = new Cosme(code, name, price, category, stock, maker, makercode);
				}
			} catch (SQLException e) {
				e.printStackTrace();

				return null;

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} // 見つかったユーザーまたはnullを返す
		return cosme;
	}
}